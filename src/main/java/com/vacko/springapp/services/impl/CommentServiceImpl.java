package com.vacko.springapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;
import com.vacko.springapp.repositories.CommentRepository;
import com.vacko.springapp.repositories.PostRepository;
import com.vacko.springapp.services.CommentService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@SuppressWarnings("restriction")
	@Resource
	CommentRepository commentRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Comment placeComment(String authorName, String text, Post post,
			Comment parentComment) {
		Comment c = new Comment(authorName, text, post, parentComment);
		commentRepository.save(c);
		return null;
	}

	@Override
	public List<Comment> listComments() {
		return commentRepository.findAll();
	}

	@Override
	public Comment findOne(int id) {
		Comment c = commentRepository.findOne(id);
		return c;
	}

	@Override
	public List<Comment> listNotApprovedComments() {
		List<Comment> comments = commentRepository.findAll();
		List<Comment> toReturnPosts = new ArrayList<Comment>();
		for (Comment p : comments) {
			if (!p.isState()) {
				toReturnPosts.add(p);
			}
		}
		return toReturnPosts;
	}

	@Override
	public void update(Comment c) {
		commentRepository.save(c);

	}

	@Override
	public void updateComment(Comment c) {
		commentRepository.save(c);
	}

	@Override
	public void delete(int id) {
		commentRepository.delete(id);

	}

	@Override
	public Comment placeRootComment(String authorName, String text, Post post,
			Comment parentComment) {
		Comment c = new Comment(authorName, text, post, parentComment, true);
		commentRepository.save(c);
		return null;
	}

	@Override
	public int getAmmountOfCommentsWaitingApproval() {
		List<Object> results = em.createNativeQuery(
				"select count(*) from comment where state = 0").getResultList();
		return Integer.parseInt(results.get(0).toString());
	}

}
