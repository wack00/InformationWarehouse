package com.vacko.springapp.web.controllers;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;
import com.vacko.springapp.services.CommentService;
import com.vacko.springapp.services.PostService;
import com.vacko.springapp.services.ReportService;

@Controller
public class CreaterController {

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	@Autowired
	ReportService reportService;

	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public String addPost(@RequestParam String descr,
			@RequestParam String returnTag) {
		Post p = postService.placePost(descr);

		commentService.placeRootComment("rootComment", "rootComment", p, null);

		return "redirect:" + returnTag;
	}

	@RequestMapping(value = "/reportComment", method = RequestMethod.POST)
	public String reportComment(@RequestParam String description,
			@RequestParam Integer commentId) throws NotFoundException {

		Comment c = commentService.findOne(commentId);
		if (c == null) {
			throw new NotFoundException("Comment not found");
		}

		reportService.placeReport(description, c);

		return "redirect:post/" + c.getPost().getPostId();
	}

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(@RequestParam String authorName,
			@RequestParam String descr, @RequestParam Integer postId,
			@RequestParam Integer parentComment) {

		Post p = postService.findOne(postId);
		Comment c = commentService.findOne(parentComment);

		commentService.placeComment(authorName, descr, p, c);

		return "redirect:post/" + postId;
	}
}
