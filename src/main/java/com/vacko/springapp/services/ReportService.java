package com.vacko.springapp.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vacko.springapp.entities.Comment;
import com.vacko.springapp.entities.Post;
import com.vacko.springapp.entities.Report;

public interface ReportService {

	public Report placeReport(String decription, Comment comment);

	public void update(int id);

	public Report findOne(int id);

	public void delete(int id);

	public int getAmmountOfReportsWaitingReview();

}
