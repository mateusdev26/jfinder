package com.jfinder.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Puzzle {
    private List<List<Character>> grid ;
    private List<String> hiddenWords ;
}
