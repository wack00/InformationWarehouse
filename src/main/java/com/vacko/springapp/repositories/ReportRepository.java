package com.vacko.springapp.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vacko.springapp.entities.Post;
import com.vacko.springapp.entities.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {

}
