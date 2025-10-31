package com.jfinder.util;

import com.jfinder.domain.Word;
import com.jfinder.exception.GridNotValidException;
import com.jfinder.request.Puzzle;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@RequiredArgsConstructor
class FinderUtilTest {

    private final FinderUtil finderUtil = new FinderUtil();
    @Test
    @DisplayName("Should get words horizontally")
    void shouldGetWordsHorizontally(){
        List<List<Character>> grid = List.of(
                List.of('D','O','G'),
                List.of('C','A','T'),
                List.of('O','N','E')
        );
       List<String> hiddenWords = List.of("DOG","CAT","ONE");
       List<Word> expected = List.of(
               new Word("DOG",1,3,3,3),
               new Word("CAT",1,2,3,2),
               new Word("ONE",1,1,3,1)
       );
       assertEquals(finderUtil.findWords(grid,hiddenWords),expected);
    }
    @Test
    @DisplayName("Should throw GridNotValidException")
    void shouldThrowGridNotValidException(){
        List<List<Character>> notValidGrid = List.of(
                List.of('X', 'X', 'X', 'X'),
                List.of('X', 'X', 'X', 'X'),
                List.of('X', 'X', 'X', 'X')

        );
        assertThrows(GridNotValidException.class, () -> finderUtil.findWords(notValidGrid, List.of()));
    }

}








