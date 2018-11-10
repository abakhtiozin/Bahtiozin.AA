package com.abakhtiozin.testtask.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseValueDecomposer {
    private final String value;

    public ResponseValueDecomposer(final String value) {
        this.value = value;
    }

    public Result decompose() {
        final Map<Character, Integer> result = new LinkedHashMap<>();
        if (!value.isEmpty()) {
            for (final char singleChar : value.toCharArray()) {
                if (result.containsKey(singleChar)) {
                    result.put(singleChar, result.get(singleChar) + 1);
                } else {
                    result.put(singleChar, 1);
                }
            }
        }
        return new Result(result);
    }
}
