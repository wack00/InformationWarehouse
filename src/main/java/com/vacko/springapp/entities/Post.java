package com.vacko.springapp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	private Date dateCreated;

	private int sum;
	private String description;

	private int countApprove;

	private int countDisapprove;

	private boolean state;

	@JsonIgnore
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

	public Post(String description, int countApprove, int countDisapprove,
			boolean state) {
		super();
		this.description = description;
		this.countApprove = countApprove;
		this.countDisapprove = countDisapprove;
		this.state = state;
		this.dateCreated = new Date();
	}

	public Post(String description) {
		super();
		this.description = description;
		this.dateCreated = new Date();
		this.comments = new ArrayList<Comment>();
		// this.comments.add(new Comment("rootComment", "rootComment", this,
		// null));
		this.state = false;
	}

	public String getDescription() {
		return description;

	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Post() {

	}

	public int getId() {
		return postId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setId(int id) {
		this.postId = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
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
