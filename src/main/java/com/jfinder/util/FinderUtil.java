package com.jfinder.util;

import com.jfinder.JfinderApplication;
import com.jfinder.domain.Word;
import com.jfinder.exception.GridNotValidException;
import com.jfinder.request.Puzzle;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@Log4j2
@Component
public class FinderUtil {
    public List<Word> findWords(List<List<Character>> grid,List<String> hiddenWords){
        return findWords(new Puzzle(grid,hiddenWords));
    }
    public List<Word> findWords(Puzzle puzzle) {
        final List<List<Character>> grid = puzzle.getGrid();
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i) == null || grid.get(i).size() != grid.size()) {
                log.warn("Grid inválido na linha {}", i);
                throw new GridNotValidException("This grid isn't valid. Make sure that it's a perfect square");
            }
        }
            final List<String> hiddenWords = puzzle.getHiddenWords();
            List<Word> output = new ArrayList<>();
            log.info("Words found:");
            for (boolean isHorizontal : new boolean[]{true, false}) {
                List<List<Character>> currentGrid = isHorizontal ? grid : rotate90degrees(grid);
                for (List<Character> row : currentGrid) {
                    String rowString = row.stream()
                            .map(String::valueOf)
                            .reduce("", String::concat);

                    for (String word : hiddenWords) {
                        int startIndex = rowString.indexOf(word);
                        if (startIndex != -1) {
                            int firstX = isHorizontal ? startIndex + 1 : currentGrid.indexOf(row);
                            int firstY = isHorizontal ? currentGrid.reversed().indexOf(row) + 1 : startIndex;
                            int lastX = isHorizontal ? startIndex + word.length() : currentGrid.indexOf(row);
                            int lastY = isHorizontal ? currentGrid.reversed().indexOf(row) + 1 : startIndex + word.length();
                            Word toAdd = new Word(word, firstX, firstY, lastX, lastY);
                            log.info("  " + toAdd.getWord() + " found : " + output.add(toAdd) + " , horizontal : " + isHorizontal);

                        }
                    }
                }
            }
            return output;
        }

    private List<List<Character>> rotate90degrees(List<List<Character>> toRotate) {
        List<List<Character>> output = new ArrayList<>();
        for (int y = 0; y < toRotate.size(); y++) {
            List<Character> newRow = new ArrayList<>();
            for (int x = 0; x < toRotate.getFirst().size(); x++) {
                newRow.add(toRotate.get(toRotate.size() - 1 - x).get(y));
            }
            output.add(newRow);
        }
        return output;
    }
}

