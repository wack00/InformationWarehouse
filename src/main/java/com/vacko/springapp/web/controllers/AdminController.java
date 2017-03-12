package com.vacko.springapp.web.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vacko.springapp.entities.*;
import com.vacko.springapp.services.CommentService;
import com.vacko.springapp.services.PostService;
import com.vacko.springapp.services.ReportService;

@Controller
public class AdminController {

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	@Autowired
	ReportService reportService;

	// getting pannel
	@RequestMapping(value = "postPannel")
	public ModelAndView postPannel() {

		List<Post> posts;
		posts = postService.listNotApprovedPosts();

		ModelAndView m = new ModelAndView("postPannel");
		m.addObject("posts", posts);

		return m;
	}

	// getting pannel
	@RequestMapping(value = "adminPannel")
	public ModelAndView adminPannel() {
		ModelAndView m = new ModelAndView("adminPannel");
		m.addObject("numberPosts",
				postService.getAmmountOfPostsWaitingApproval());
		m.addObject("numberComments",
				commentService.getAmmountOfCommentsWaitingApproval());
		m.addObject("numberReports",
				reportService.getAmmountOfReportsWaitingReview());
		return m;
	}

	// getting pannel
	@RequestMapping(value = "commentPannel")
	public ModelAndView commentPannel() {

		List<Comment> comments;
		comments = commentService.listNotApprovedComments();

		ModelAndView m = new ModelAndView("commentPannel");
		m.addObject("comments", comments);

		return m;
	}

	// getting pannel
	@RequestMapping(value = "reportPannel")
	public ModelAndView reportPannel() {

		List<Comment> comments;
		comments = commentService.listComments();

		List<Comment> reportedComments = new ArrayList<Comment>();

		for (Comment c : comments) {
			if (!c.getReports().isEmpty()) {
				reportedComments.add(c);
			}
		}

		ModelAndView m = new ModelAndView("reportPannel");
		m.addObject("comments", reportedComments);

		return m;
	}

	// getting pannel details
	@RequestMapping(value = "commentDetail/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView commentDetail(@PathVariable("id") int id) {

		ModelAndView m = new ModelAndView("commentDetail");

		Comment c = commentService.findOne(id);

		m.addObject("comment", c);
		m.addObject("reports", c.getReports());
		m.addObject("id", id);
		return m;

	}

}