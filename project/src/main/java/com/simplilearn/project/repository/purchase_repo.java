package com.simplilearn.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.project.entities.Purchase;

public interface purchase_repo extends JpaRepository<Purchase, Integer> {

}
