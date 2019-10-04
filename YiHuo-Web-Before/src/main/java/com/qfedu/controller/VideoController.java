package com.qfedu.controller;

import com.qfedu.entry.Video;
import com.qfedu.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/video")
@Api(tags = "该类实现所有关于video的功能")
public class VideoController {

    @Autowired
    VideoService videoService;



    @ResponseBody
    @RequestMapping(value = "/showList",method = RequestMethod.POST)
    @ApiOperation(value = "该方法用来展示视频列表")
    public String videoList(Model model) {
        List<Video> videoList = videoService.selectAllVideo();
        model.addAttribute("videoList", videoList);
        return "success";
    }

}
