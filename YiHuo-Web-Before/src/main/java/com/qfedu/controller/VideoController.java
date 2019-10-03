package com.qfedu.controller;

import com.qfedu.entry.Video;
import com.qfedu.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;


    @RequestMapping("/showList")
    public String videoList(Model model) {
        List<Video> videoList = videoService.selectAllVideo();
        model.addAttribute("videoList", videoList);
        return "";
    }

}
