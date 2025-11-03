package com.jfinder.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Puzzle {
    @NotEmpty(message = "The 'grid' mustn't be empty")
    private List<List<Character>> grid ;
    @NotEmpty(message = "The 'hiddenWords' mustn't be empty")
    private List<String> hiddenWords ;
}
