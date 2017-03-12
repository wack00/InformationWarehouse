package com.vacko.springapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacko.springapp.entities.Post;
import com.vacko.springapp.repositories.CommentRepository;
import com.vacko.springapp.repositories.PostRepository;
import com.vacko.springapp.services.PostService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@SuppressWarnings("restriction")
	@Resource
	PostRepository postRepository;

	@PersistenceContext
	private EntityManager em;

	public Post placePost(String decription) {
		Post post = new Post(decription);

		post = postRepository.save(post);

		return post;
	}

	public List<Post> listPosts() {

		return postRepository.findAll();
	}

	public List<Post> listNotApprovedPosts() {

		List<Post> posts = postRepository.findAll();
		List<Post> toReturnPosts = new ArrayList<Post>();
		for (Post p : posts) {
			if (!p.isState()) {
				toReturnPosts.add(p);
			}
		}
		return toReturnPosts;
	}

	public void delete(int id) {
		postRepository.delete(id);
	}

	@Override
	public void update(int id) {
		Post p = postRepository.findOne(id);
		this.delete(id);
		Post pp = new Post(p.getDescription());
		pp.setState(true);
		postRepository.save(pp);
	}

	@Override
	public Post findOne(int id) {

		return postRepository.findOne(id);
	}

	public Page<Post> findAllPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
	}

	@Override
	public void updatePost(Post p) {
		postRepository.save(p);

	}

	@Override
	public Page<Post> findAllPostsApproved(Pageable pageable) {
		Page<Post> allPosts = postRepository.findAll(pageable);

		List<Post> forReturn = new ArrayList<Post>();

		for (Post p : allPosts) {
			if (p.isState()) {
				forReturn.add(p);

			}
		}

		return new PageImpl<Post>(forReturn);
	}

	@Override
	public Page<Post> findByState(Boolean state, Pageable pageable) {

		return postRepository.findByState(state, pageable);
	}

	@Override
	public int getApprovedPostsSize() {
		List<Object> results = em.createNativeQuery(
				"select count(*) from post where state=1 ").getResultList();
		return Integer.parseInt(results.get(0).toString());
	}

	@Override
	public int getAmmountOfPostsWaitingApproval() {
		List<Object> results = em.createNativeQuery(
				"select count(*) from post where state = 0").getResultList();
		return Integer.parseInt(results.get(0).toString());

	}

}
