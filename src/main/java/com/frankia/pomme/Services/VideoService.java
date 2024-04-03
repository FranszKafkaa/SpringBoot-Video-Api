package com.frankia.pomme.Services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.frankia.pomme.Entity.Video;

public interface VideoService {
    Video Store(Video video, MultipartFile file);
    List<Video> listAll();
    
} 