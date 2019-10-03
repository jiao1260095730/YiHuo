package com.qfedu.service.impl;

import com.qfedu.entry.Video;
import com.qfedu.mapper.VideoMapper;
import com.qfedu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;


    public List<Video> selectAllVideo() {
        return videoMapper.selectAllVideo();
    }
}
