package com.simplilearn.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.project.entities.product;
@Repository
public interface product_repo extends JpaRepository<product, Integer> {

}
