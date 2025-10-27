package com.jfinder.request;

import lombok.Getter;

import java.util.List;
@Getter
public class Puzzle {
    private List<List<Character>> grid ;
    private List<String> hiddenWords ;
}
