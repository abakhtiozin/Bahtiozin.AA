package com.abakhtiozin.testtask.fetcher.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JavaNetHttpProvider implements HttpProvider, RequestValidator {

    @Override
    public Response send(final Request request) {
        Response response = null;
        if (validate(request.getUrl())) {
            HttpURLConnection con = null;
            try {
                final URL url = new URL(request.getUrl());
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod(request.getHttpMethod());
                final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                response = new Response(
                        con.getResponseCode(),
                        con.getHeaderFields(),
                        content.toString()
                );
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                con.disconnect();
            }
        }
        return response;
    }
}
