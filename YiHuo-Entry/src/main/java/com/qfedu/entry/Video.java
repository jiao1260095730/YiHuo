package com.qfedu.entry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video {
    private Integer id;

    private String name;

    private String createTime;

    private Integer buyNum;

    private String videoImgUrl;

    private String videoUrl;

    private String showTime;

    private Integer teacherId;

    private String typeId;

    private Integer labelId;

    private String desc;
}
