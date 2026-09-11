package com.planthealthbackend.planthealthbackend.controller;

import com.planthealthbackend.planthealthbackend.dto.SuggestionDto;
import com.planthealthbackend.planthealthbackend.service.SuggestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @GetMapping
    public List<SuggestionDto> getSuggestions() {
        return suggestionService.getSuggestions();
    }
}
