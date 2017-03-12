package com.vacko.springapp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private Date dateCreated;
	private String authorName;
	private String text;
	private int countApprove;
	private int countDisapprove;
	private boolean state;

	
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "replyId")
	private Comment parentComment;

	
	@OneToMany(mappedBy = "parentComment")
	private List<Comment> comments = new ArrayList<Comment>();

	@OneToMany(mappedBy = "comment")
	private List<Report> reports;

	public Comment() {
		super();
	}

	public Comment(String authorName, String text, Post post,
			Comment parentComment) {
		this.authorName = authorName;
		this.text = text;
		this.post = post;
		this.dateCreated = new Date();
		this.parentComment = parentComment;
		this.comments = new ArrayList<Comment>();
	}

	public Comment(String authorName, String text, Post post,
			Comment parentComment, boolean state) {
		this.authorName = authorName;
		this.text = text;
		this.post = post;
		this.dateCreated = new Date();
		this.parentComment = parentComment;
		this.comments = new ArrayList<Comment>();
		this.state = true;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getCountApprove() {
		return countApprove;
	}

	public void setCountApprove(int countApprove) {
		this.countApprove = countApprove;
	}

	public int getCountDisapprove() {
		return countDisapprove;
	}

	public void setCountDisapprove(int countDisapprove) {
		this.countDisapprove = countDisapprove;
	}

	public Comment getParentComment() {
		return parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getId() {
		return commentId;
	}

	public void setId(int id) {
		this.commentId = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String returnDate() {
		Date now = new Date();

		long diff = (now.getTime() - this.getDateCreated().getTime()) / 1000;

		long year = diff / (60 * 60 * 24 * 30 * 365);
		long month = diff / (60 * 60 * 24 * 7 * 4);
		long week = diff / (60 * 60 * 24 * 7);
		long day = diff / (60 * 60 * 24);
		long hour = diff / (60 * 60);
		long minute = diff / 60;

		if (minute < 15 && hour == 0) {
			return "5min";
		} else if (minute > 15 && minute < 30 && hour == 0) {
			return "15min";
		} else if (minute > 30 && hour == 0) {
			return "30min";
		} else if (hour == 0) {
			return "1h";
		} else if (day == 0) {
			return "" + hour + "h";
		} else if (week == 0) {
			return "" + day + "d";
		} else if (month == 0) {
			return "" + week + "w";
		} else if (year == 0) {
			return "" + month + "m";
		} else {
			return "" + year + "y";
		}

	}

}
