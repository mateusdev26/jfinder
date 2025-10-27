package com.jfinder.controller;

import com.jfinder.domain.Word;
import com.jfinder.request.Puzzle;
import com.jfinder.service.JfinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/jfinder")
@RequiredArgsConstructor
public class JfinderController {
    private final JfinderService jfinderService;
    @GetMapping("/find")
    public List<Word> find(@RequestBody Puzzle puzzle){
        return jfinderService.find(puzzle);
    }
}
