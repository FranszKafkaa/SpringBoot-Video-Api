package com.frankia.pomme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frankia.pomme.Entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{}
