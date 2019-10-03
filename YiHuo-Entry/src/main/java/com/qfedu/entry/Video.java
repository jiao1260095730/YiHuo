package com.qfedu.entry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video {
    private int id;
    private String desc;
    private String createTime;
    private int buyNum;
    private String videoImgUrl;
    private String videoUrl;
    private String showTime;
    private int teacherId;
    private int courseId;
    private String labelId;
}
