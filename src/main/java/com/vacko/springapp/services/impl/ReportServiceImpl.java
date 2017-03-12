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
import com.vacko.springapp.entities.Report;
import com.vacko.springapp.repositories.CommentRepository;
import com.vacko.springapp.repositories.PostRepository;
import com.vacko.springapp.repositories.ReportRepository;
import com.vacko.springapp.services.ReportService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	@SuppressWarnings("restriction")
	@Resource
	ReportRepository reportRepository;

	@PersistenceContext
	private EntityManager em;

	public Report placeReport(String decription, Comment comment) {

		Report report = new Report(decription, comment);

		reportRepository.save(report);

		return report;

	}

	@Override
	public void update(int id) {
		// not yet implemented!
	}

	@Override
	public Report findOne(int id) {

		return reportRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		reportRepository.delete(id);

	}

	@Override
	public int getAmmountOfReportsWaitingReview() {
		List<Object> results = em.createNativeQuery(
				"select count(*) from report where state = 0").getResultList();
		return Integer.parseInt(results.get(0).toString());
	}

}
