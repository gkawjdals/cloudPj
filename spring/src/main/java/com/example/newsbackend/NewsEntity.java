package com.example.newsbackend;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String org_link;

    private String categories;

    private String img_url;

    private String keyword;

    private String hashtag;

    private String put_date;

}
