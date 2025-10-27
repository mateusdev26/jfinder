package com.jfinder.service;

import com.jfinder.domain.Word;
import com.jfinder.request.Puzzle;
import com.jfinder.util.FinderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class JfinderService {
    private final FinderUtil finderUtil ;

    public List<Word> find(Puzzle puzzle) {
        return finderUtil.findWords(puzzle);
    }
}
