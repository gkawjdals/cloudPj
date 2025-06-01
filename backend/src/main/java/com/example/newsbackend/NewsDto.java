package com.example.newsbackend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NewsDto {
    private String title;

    private String content;

    private String org_link;

    private String categories;

    private String img_url;

    private String keyword;

    private String hashtag;

}
