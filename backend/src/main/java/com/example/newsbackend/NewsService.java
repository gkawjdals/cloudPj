package com.example.newsbackend;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;


    public List<NewsEntity> getAllSummaries() {
        return newsRepository.findAll();
    }

    public Optional<NewsEntity> getSummaryById(Long id) {
        return newsRepository.findById(id);
    }

    public NewsEntity saveSummary(NewsEntity summary) {
        return newsRepository.save(summary);
    }
}