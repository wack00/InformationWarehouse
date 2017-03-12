package com.vacko.springapp.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vacko.springapp.entities.Post;

public interface PostService {

	public Post placePost(String decription);

	public List<Post> listPosts();

	public List<Post> listNotApprovedPosts();

	public void delete(int id);

	public void update(int id);

	public void updatePost(Post p);

	public Post findOne(int id);

	public Page<Post> findAllPosts(Pageable pageable);

	public Page<Post> findAllPostsApproved(Pageable pageable);

	public Page<Post> findByState(Boolean state, Pageable pageable);

	public int getApprovedPostsSize();

	public int getAmmountOfPostsWaitingApproval();

}
