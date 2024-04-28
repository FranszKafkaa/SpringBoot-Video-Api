package com.frankia.pomme.Actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.frankia.pomme.Entity.Video;
import com.frankia.pomme.Repository.VideoRepository;
import com.frankia.pomme.Services.VideoService;
import com.frankia.pomme.Utils.MinioUtils;

@Service
public class VideoAction implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MinioUtils minioUtils;

    @Override
    public Video Store(Video video, MultipartFile file) {
        try {
            minioUtils.uploadFile("main", file, video.getName(), file.getContentType());
            kafkaTemplate.send("video", "rola durassa");
            return videoRepository.save(video);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<Video> listAll() {
        return videoRepository.findAll();
    }

}
