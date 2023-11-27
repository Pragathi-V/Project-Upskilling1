package com.example.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot2.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long>{

}
