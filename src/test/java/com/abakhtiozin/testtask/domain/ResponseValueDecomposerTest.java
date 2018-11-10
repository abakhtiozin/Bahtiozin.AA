package com.abakhtiozin.testtask.domain;

import org.junit.Assert;
import org.junit.Test;

public class ResponseValueDecomposerTest {

    @Test
    public void stringDecompose() {
        final String given = "ABC8A89A";
        final ResponseValueDecomposer decomposer = new ResponseValueDecomposer(given);
        final Result result = decomposer.decompose();
        Assert.assertEquals(5, result.countOfUniqueCharacters());
        Assert.assertEquals("Wrong count of occurrence 'A' character ",3, result.getCountOfCharOccurrence('A'));
        Assert.assertEquals("Wrong count of occurrence 'B' character ",1, result.getCountOfCharOccurrence('B'));
        Assert.assertEquals("Wrong count of occurrence 'C' character ",1, result.getCountOfCharOccurrence('C'));
        Assert.assertEquals("Wrong count of occurrence '8' character ",2, result.getCountOfCharOccurrence('8'));
        Assert.assertEquals("Wrong count of occurrence '9' character ",1, result.getCountOfCharOccurrence('9'));
    }

    @Test
    public void emptyStringDecompose() {
        final String given = "";
        final ResponseValueDecomposer decomposer = new ResponseValueDecomposer(given);
        final Result result = decomposer.decompose();
        Assert.assertEquals(0, result.countOfUniqueCharacters());
        Assert.assertEquals("Wrong count of occurrence 'A' character ",0, result.getCountOfCharOccurrence('A'));
    }
}