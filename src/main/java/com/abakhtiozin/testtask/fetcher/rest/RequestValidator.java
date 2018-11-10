package com.abakhtiozin.testtask.fetcher.rest;

interface RequestValidator {

   default boolean validate(final String url) {
        final String regex = "\\b(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (!url.matches(regex)) {
            throw new WrongUrlException(url, regex);
        } else return true;
    }
}
