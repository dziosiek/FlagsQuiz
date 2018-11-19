package com.quizgame.quizgame;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public interface Characters {
    LinkedList CHARACTERS = new LinkedList(){{
        for (char c = 'A'; c <= 'Z'; c++) {
            add(c);
        }

    }};
    void prev();
    void next();
    char get();
    void set();
}
