package com.vacko.springapp.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;
import com.vacko.springapp.entities.Report;
import com.vacko.springapp.services.CommentService;
import com.vacko.springapp.services.PostService;
import com.vacko.springapp.services.ReportService;

@Controller
public class ValueChangerController {

	@Autowired
	PostService postService;
	@Autowired
	CommentService commentService;
	@Autowired
	ReportService reportService;

	// update post value
	@RequestMapping(value = "countApproveDown/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity countApproveDown(@PathVariable("id") int id) {
		Post p = postService.findOne(id);
		p.setCountApprove(p.getCountApprove() - 1);

		p.setSum(p.getSum() - 1);

		postService.updatePost(p);

		return new ResponseEntity(p.getCountApprove(), HttpStatus.OK);
	}

	// update post value
	@RequestMapping(value = "countDisapproveDown/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity countDisapproveDown(@PathVariable("id") int id) {
		Post p = postService.findOne(id);
		p.setCountDisapprove(p.getCountDisapprove() - 1);

		p.setSum(p.getSum() - 1);

		postService.updatePost(p);
		return new ResponseEntity(p.getCountDisapprove(), HttpStatus.OK);
		// return "redirect:index";
	}

	// update post value
	@RequestMapping(value = "countApproveUp/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity countApproveUp(@PathVariable("id") int id) {
		Post p = postService.findOne(id);
		p.setCountApprove(p.getCountApprove() + 1);

		p.setSum(p.getSum() + 1);

		postService.updatePost(p);

		return new ResponseEntity(p.getCountApprove(), HttpStatus.OK);

	}

	// update post value
	@RequestMapping(value = "countDisapproveUp/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity countDisapproveUp(@PathVariable("id") int id) {
		Post p = postService.findOne(id);
		p.setCountDisapprove(p.getCountDisapprove() + 1);

		p.setSum(p.getSum() + 1);

		postService.updatePost(p);
		return new ResponseEntity(p.getCountDisapprove(), HttpStatus.OK);

	}

	// update comment value
	@RequestMapping(value = "commentCountApproveDown/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity CommentCountApproveDown(@PathVariable("id") int id) {

		Comment c = commentService.findOne(id);

		c.setCountApprove(c.getCountApprove() - 1);

		commentService.update(c);

		return new ResponseEntity(c.getCountApprove(), HttpStatus.OK);

	}

	// update comment value
	@RequestMapping(value = "commentCountDisapproveDown/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity CommentCountDisapproveDown(@PathVariable("id") int id) {

		Comment c = commentService.findOne(id);

		c.setCountDisapprove(c.getCountDisapprove() - 1);

		commentService.update(c);

		return new ResponseEntity(c.getCountDisapprove(), HttpStatus.OK);
	}

	// update comment value
	@RequestMapping(value = "commentCountApproveUp/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity CommentCountApproveUp(@PathVariable("id") int id) {

		Comment c = commentService.findOne(id);

		c.setCountApprove(c.getCountApprove() + 1);

		commentService.update(c);

		return new ResponseEntity(c.getCountApprove(), HttpStatus.OK);
	}

	// update comment value
	@RequestMapping(value = "commentCountDisapproveUp/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity CommentCountDisapproveUp(@PathVariable("id") int id) {

		Comment c = commentService.findOne(id);

		c.setCountDisapprove(c.getCountDisapprove() + 1);

		commentService.update(c);

		return new ResponseEntity(c.getCountDisapprove(), HttpStatus.OK);
	}

	// accept post
	@RequestMapping(value = "acceptPost/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity acceptPost(@PathVariable("id") int id) {

		Post post = postService.findOne(id);

		if (post != null) {
			post.setState(true);
			postService.updatePost(post);
			return new ResponseEntity("Post " + id + " accepted!",
					HttpStatus.OK);
		} else
			return new ResponseEntity("There is an error with post " + id
					+ " !", HttpStatus.BAD_REQUEST);
	}

	// deny post
	@RequestMapping(value = "denyPost/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity denyPost(@PathVariable("id") int id) {

		Post post = postService.findOne(id);

		if (post != null) {
			postService.delete(id);
			return new ResponseEntity("Post " + id + " denied!", HttpStatus.OK);
		} else
			return new ResponseEntity("There is an error with post " + id
					+ " !", HttpStatus.BAD_REQUEST);
	}

	// accept comment
	@RequestMapping(value = "acceptComment/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity acceptComment(@PathVariable("id") int id) {

		Comment comment = commentService.findOne(id);

		if (comment != null) {
			comment.setState(true);
			commentService.update(comment);
			return new ResponseEntity("Comment" + id + "accepted!",
					HttpStatus.OK);
		} else
			return new ResponseEntity("There is an error with comment " + id
					+ " !", HttpStatus.BAD_REQUEST);
	}

	// deny comment
	@RequestMapping(value = "denyComment/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity denyComment(@PathVariable("id") int id) {

		Comment comment = commentService.findOne(id);

		if (comment != null) {
			commentService.delete(id);
			return new ResponseEntity("Comment" + id + "denied!", HttpStatus.OK);
		} else
			return new ResponseEntity("There is an error with comment " + id
					+ " !", HttpStatus.BAD_REQUEST);
	}

	// accept reported comment
	@RequestMapping(value = "acceptReportedComment/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity acceptReportedComment(@PathVariable("id") int id) {

		Comment comment = commentService.findOne(id);

		if (comment != null) {
			List<Report> reports = comment.getReports();
			for (Report r : reports) {
				// Report fromDatabase = reportService.findOne(r.getReportId());
				reportService.delete(r.getReportId());
			}

			return new ResponseEntity("Reported Comment " + id
					+ " is accepted!", HttpStatus.OK);
		} else
			return new ResponseEntity(
					"There is an error with reported comment " + id + " !",
					HttpStatus.BAD_REQUEST);
	}

	// deny reported comment
	@RequestMapping(value = "denyReportedComment/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity denyReportedComment(@PathVariable("id") int id) {

		Comment comment = commentService.findOne(id);

		if (comment != null) {
			List<Report> reports = comment.getReports();
			for (Report r : reports) {
				// Report fromDatabase = reportService.findOne(r.getReportId());
				reportService.delete(r.getReportId());
			}
			commentService.delete(id);

			return new ResponseEntity("Reported Comment " + id
					+ " is rejected!", HttpStatus.OK);
		} else
			return new ResponseEntity(
					"There is an error with reported comment " + id + " !",
					HttpStatus.BAD_REQUEST);
	}
}
