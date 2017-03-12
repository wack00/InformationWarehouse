package com.vacko.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;


public interface CommentRepository extends JpaRepository<Comment,Integer> {
	
	
}
