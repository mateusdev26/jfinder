package com.jfinder.domain;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Word {
    private String word ;
    private long fistX ;
    private long firstY ;
    private long lastX ;
    private long lastY ;
}
