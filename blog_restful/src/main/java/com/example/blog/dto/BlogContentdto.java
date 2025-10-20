package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogContentdto {
    private int id;
    private String title;
    private String metadata;
    private String content;
    private String author;
    private Date createdAt;
    private Date lastUpdatedAt;
    private int typeId;
}
