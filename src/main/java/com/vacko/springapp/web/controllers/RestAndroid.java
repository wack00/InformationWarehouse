package com.vacko.springapp.web.controllers;

import java.util.List;

import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;
import com.vacko.springapp.services.CommentService;
import com.vacko.springapp.services.PostService;
import com.vacko.springapp.services.ReportService;

@Controller
public class RestAndroid {

	@Autowired
	PostService postService;
	@Autowired
	CommentService commentService;
	@Autowired
	ReportService reportService;

	private static int POSTSPERPAGE = 5;

	@RequestMapping(value = "/rest/allPosts", method = RequestMethod.GET)
	public @ResponseBody List<Post> getAllPosts() {

		List<Post> posts = postService.listPosts();

		for (Post p : posts) {
			p.setComments(null);
		}

		return posts;
	}

	// rest best
	@RequestMapping(value = "rest/pag/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Post> pag(@PathVariable("id") int id) {

		Page<Post> posts = postService.findAllPostsApproved(new PageRequest(
				id - 1, POSTSPERPAGE, Direction.DESC, "state"));

		List<Post> listPosts = posts.getContent();

		for (Post p : listPosts) {
			p.setComments(null);
		}

		return listPosts;

	}

	// rest/popular
	@RequestMapping(value = "rest/popular/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Post> sortPopular(@PathVariable("id") int id) {

		// popular post is post which has highest sum of approval disapproval

		Page<Post> postsPage = postService.findByState(true, new PageRequest(
				id - 1, POSTSPERPAGE, Direction.DESC, "sum"));

		List<Post> posts = (List<Post>) postsPage.getContent();

		for (Post p : posts) {
			p.setComments(null);

		}

		return posts;

	}

	// rest/newest
	@RequestMapping(value = "rest/newest/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Post> sortNewest(@PathVariable("id") int id) {

		Page<Post> postsPage = postService.findByState(true, new PageRequest(
				id - 1, POSTSPERPAGE, Direction.DESC, "dateCreated"));

		List<Post> posts = (List<Post>) postsPage.getContent();

		for (Post p : posts) {
			p.setComments(null);

		}

		return posts;

	}

	// getting post via rest
	@RequestMapping(value = "/rest/post/{id}", method = RequestMethod.GET)
	public @ResponseBody Post getPost(@PathVariable("id") Integer id) {

		Post p = postService.findOne(id);

		return p;
	}

	// getting comments via rest
	@RequestMapping(value = "/rest/comments/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Comment> getPostComments(
			@PathVariable("id") Integer id) {

		Post p = postService.findOne(id);

		List<Comment> comments;

		for (int i = 0; i < p.getComments().size(); i++) {

			p.getComments().get(i).setComments(null);

		}

		return p.getComments();
	}

	// post method for add post
	@RequestMapping(value = { "/rest/post/" }, method = { RequestMethod.POST })
	public @ResponseBody String addPost(@RequestParam String description,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Post p = postService.placePost(description);
		commentService.placeRootComment("rootComment", "rootComment", p, null);

		httpResponse_p.setStatus(HttpStatus.CREATED.value());

		return "Created! ";

	}

	// post method adding comment
	@RequestMapping(value = { "/rest/comment/" }, method = { RequestMethod.POST })
	public @ResponseBody String addComment(@RequestParam String description,
			@RequestParam String authorName, @RequestParam Integer postId,
			@RequestParam Integer parentComment,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Post p = postService.findOne(postId);
		Comment c = commentService.findOne(parentComment);

		commentService.placeComment(authorName, description, p, c);

		httpResponse_p.setStatus(HttpStatus.CREATED.value());

		return "Created! ";

	}

	// post method adding report
	@RequestMapping(value = { "/rest/report/" }, method = { RequestMethod.POST })
	public @ResponseBody String addReport(@RequestParam String description,
			@RequestParam Integer commentId,
			HttpServletResponse httpResponse_p, WebRequest request_p)
			throws NotFoundException {

		Comment c = commentService.findOne(commentId);

		if (c == null) {
			throw new NotFoundException("Comment not found");
		}

		reportService.placeReport(description, c);

		return "Comment Reported! ";

	}

}
