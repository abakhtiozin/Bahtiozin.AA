package com.abakhtiozin.testtask.domain;

import java.util.Map;

public class Result {
    private final Map<Character, Integer> result;

    Result(final Map<Character, Integer> result) {
        this.result = result;
    }

    public void print() {
        System.out.println("Result");
        result.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public int countOfUniqueCharacters() {
        return result.size();
    }

    public int getCountOfCharOccurrence(final char character) {
        return result.getOrDefault(character, 0);
    }
}
