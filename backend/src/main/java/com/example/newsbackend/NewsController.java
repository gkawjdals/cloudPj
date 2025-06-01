package com.example.newsbackend;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/summaries")
@CrossOrigin
public class NewsController {

    private final NewsService newsService;


    @GetMapping
    public List<NewsEntity> getAll() {
        return newsService.getAllSummaries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsEntity> getById(@PathVariable Long id) {
        return newsService.getSummaryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NewsEntity save(@RequestBody NewsEntity summary) {
        return newsService.saveSummary(summary);
    }
}
