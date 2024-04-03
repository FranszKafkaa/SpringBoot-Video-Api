package com.frankia.pomme.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.frankia.pomme.Entity.Video;
import com.frankia.pomme.Services.VideoService;

@RestController
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Video> store(@RequestParam("file") MultipartFile file, Video video) {
        return new ResponseEntity<Video>(videoService.Store(video, file), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Video>> listAll(){
        return new ResponseEntity<List<Video>>(videoService.listAll(), HttpStatus.ACCEPTED);
    }
}
