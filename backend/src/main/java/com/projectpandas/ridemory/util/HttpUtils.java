package com.projectpandas.ridemory.util;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;

public class HttpUtils {
    /**
     * Opinionated helper method that removes some boilerplate.
     *
     * @param url url to send request to
     * @return semi-initiated builder
     */
    public static Builder request(String url) {
        return HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json");
    }

    // TODO: figure out generic send helper
    public static HttpRequest POST(Builder builder) {
        // return builder.POST(HttpRequest.Bod)
        return null;
    }
}
