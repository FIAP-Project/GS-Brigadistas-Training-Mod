package com.cerbon.brigadista_training.http;

import org.apache.http.client.HttpResponseException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

public class ApiClient {

    private final HttpClient client;
    private final URI baseUri;
    private final Map<String, String> headers;

    public ApiClient(String baseUrl, Map<String, String> headers) {
        this.baseUri = URI.create(baseUrl.endsWith("/") ? baseUrl : baseUrl + "/");
        this.headers = headers;
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    public String get(String endpoint) throws Exception {
        HttpRequest.Builder request = newRequest(endpoint).GET();
        headers.forEach(request::header);
        return send(request);
    }

    public String post(String endpoint, String payload) throws Exception {
        HttpRequest.Builder request = newRequest(endpoint).POST(HttpRequest.BodyPublishers.ofString(payload));
        headers.forEach(request::header);
        return send(request);
    }

    public String put(String endpoint, String payload) throws Exception {
        HttpRequest.Builder request = newRequest(endpoint).PUT(HttpRequest.BodyPublishers.ofString(payload));
        headers.forEach(request::header);
        return send(request);
    }

    public String delete(String endpoint) throws Exception {
        HttpRequest.Builder request = newRequest(endpoint).DELETE();
        headers.forEach(request::header);
        return send(request);
    }

    public String delete(String endpoint, String payload) throws Exception {
        HttpRequest.Builder request = newRequest(endpoint).method("DELETE", HttpRequest.BodyPublishers.ofString(payload));
        headers.forEach(request::header);
        return send(request);
    }

    private HttpRequest.Builder newRequest(String endpoint) {
        return HttpRequest.newBuilder(this.baseUri.resolve(endpoint));
    }

    private String send(HttpRequest.Builder request) throws Exception {
        HttpResponse<String> response = this.client.send(
                request.build(),
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() >= 200 && response.statusCode() < 300)
            return response.body();

        throw new HttpResponseException(response.statusCode(), response.body());
    }
}
