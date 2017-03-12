package com.vacko.springapp.services;

import java.util.List;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;

public interface CommentService {

	public Comment placeComment(String authorName, String text, Post post,
			Comment parentComment);

	public Comment placeRootComment(String authorName, String text, Post post,
			Comment parentComment);

	public List<Comment> listComments();

	public List<Comment> listNotApprovedComments();

	public void update(Comment c);

	public void updateComment(Comment p);

	public void delete(int id);

	public Comment findOne(int id);

	public int getAmmountOfCommentsWaitingApproval();
}
