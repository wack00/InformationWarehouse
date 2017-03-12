package com.vacko.springapp.web.controllers;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;
import com.vacko.springapp.entities.Report;
import com.vacko.springapp.repositories.PostRepository;
import com.vacko.springapp.services.CommentService;
import com.vacko.springapp.services.PostService;
import com.vacko.springapp.services.ReportService;

@Controller
public class FrontController {

	@Autowired
	PostService postService;
	@Autowired
	CommentService commentService;
	@Autowired
	ReportService reportService;

	private static int POSTSPERPAGE = 5;

	// get post details
	@RequestMapping(value = "post/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView indexId(@PathVariable("id") int id) {

		ModelAndView m = new ModelAndView("post");
		Post p = postService.findOne(id);

		m.addObject("post", p);
		m.addObject("comments", p.getComments());
		m.addObject("randomPost", this.getRandomPost());
		m.addObject("rootCommentId", p.getComments().get(0).getCommentId());
		m.addObject("id", id);
		return m;
	}

	// get best posts
	@RequestMapping(value = "pag/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView pag(@PathVariable("id") int id) {

		ModelAndView m = new ModelAndView("pag");

		Page<Post> posts = postService.findAllPostsApproved(new PageRequest(
				id - 1, POSTSPERPAGE, Direction.DESC, "state"));

		double size = (double) postService.getApprovedPostsSize();

		int pages = (int) Math.ceil(size / POSTSPERPAGE);

		m.addObject("posts", posts.getContent());
		m.addObject("size", pages);
		m.addObject("currentPage", id);
		m.addObject("randomPost", this.getRandomPost());
		m.addObject("returnTag", "pag/" + id);
		m.addObject("currentPageTag", "pag");
		return m;

	}

	// get popular posts
	@RequestMapping(value = "sort/popular/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView sortPopular(@PathVariable("id") int id) {

		ModelAndView m = new ModelAndView("pag");

		// popular post is post which has highest sum of approval disapproval

		Page<Post> postsPage = postService.findByState(true, new PageRequest(
				id - 1, POSTSPERPAGE, Direction.DESC, "sum"));

		List<Post> posts = (List<Post>) postsPage.getContent();

		double size = (double) postService.getApprovedPostsSize();

		int pages = (int) Math.ceil(size / POSTSPERPAGE);

		m.addObject("posts", posts);
		m.addObject("size", pages);
		m.addObject("randomPost", this.getRandomPost());
		m.addObject("returnTag", "sort/popular/" + id);
		m.addObject("currentPage", id);
		m.addObject("currentPageTag", "sort/popular");
		return m;

	}

	// get newest posts
	@RequestMapping(value = "sort/newest/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView sortNewest(@PathVariable("id") int id) {

		ModelAndView m = new ModelAndView("pag");

		Page<Post> postsPage = postService.findByState(true, new PageRequest(
				id - 1, POSTSPERPAGE, Direction.DESC, "dateCreated"));

		List<Post> posts = (List<Post>) postsPage.getContent();

		double size = (double) postService.getApprovedPostsSize();
		int pages = (int) Math.ceil(size / POSTSPERPAGE);

		m.addObject("posts", posts);
		m.addObject("size", pages);
		m.addObject("randomPost", this.getRandomPost());
		m.addObject("currentPage", id);
		m.addObject("returnTag", "sort/newest/" + id);
		m.addObject("currentPageTag", "sort/newest");
		return m;

	}

	// get random post
	public Post getRandomPost() {

		List<Post> posts = postService.listPosts();

		Random r = new Random();

		Post p = null;
		int id;
		while (p == null) {
			id = r.nextInt(posts.size());
			p = posts.get(id);
		}

		return p;
	}

}
