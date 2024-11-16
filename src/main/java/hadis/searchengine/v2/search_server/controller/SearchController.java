package hadis.searchengine.v2.search_server.controller;

import hadis.searchengine.v2.search_server.entity.Note;
import hadis.searchengine.v2.search_server.service.SearchService;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@RequestMapping("/search-server")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/{query}")
    public ResponseEntity<Iterator<SearchHit<Note>>> search(@PathVariable String query) {
        return ResponseEntity.ok(searchService.search(query));
    }
}