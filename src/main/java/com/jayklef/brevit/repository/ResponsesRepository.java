package com.jayklef.brevit.repository;

import com.jayklef.brevit.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsesRepository extends JpaRepository<Answers, Long> {
}
