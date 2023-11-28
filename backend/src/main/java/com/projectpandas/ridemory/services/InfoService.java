package com.projectpandas.ridemory.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    // TODO: figure out best way to organize the following:
    // TSA wait times
    // Traffic times
    // Uber/Lyft price estimates
    // Transloc

    public final HttpClient client;
    public static final String TSAWaitTimeAPI = "https://www.atl.com/times/";

    // @Autowired
    public InfoService() {
        client = HttpClient.newHttpClient();
    }

    public CompletableFuture<String> getTSAWaitTime() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TSAWaitTimeAPI))
                .GET()
                .build();

        CompletableFuture<String> response = client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        // TODO: trim and process response to just return checkpoints and their wait
        // times

        return response;
    }
}
