package com.core.application.httpclinet;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpHeaders;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.Optional;

public class CustomHttpRequest {

    private final HttpRequest httpRequest;

    // Private constructor to enforce usage of builder pattern
    private CustomHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public static CustomHttpRequestBuilder newBuilder() {
        return new CustomHttpRequestBuilder();
    }

    // Getter for the underlying HttpRequest
    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    // Wrapper methods
    public URI uri() {
        return httpRequest.uri();
    }

    public String method() {
        return httpRequest.method();
    }

    public Optional<BodyPublisher> bodyPublisher() {
        return httpRequest.bodyPublisher();
    }

    public HttpHeaders headers() {
        return httpRequest.headers();
    }

    public Optional<Duration> timeout() {
        return httpRequest.timeout();
    }

    public Optional<Version> version() {
        return httpRequest.version();
    }

    // Inner static builder class
    public static class CustomHttpRequestBuilder {

        private HttpRequest.Builder builder;

        public CustomHttpRequestBuilder() {
            this.builder = HttpRequest.newBuilder();
        }

        public CustomHttpRequestBuilder uri(String uri) {
            this.builder.uri(URI.create(uri));
            return this;
        }

        public CustomHttpRequestBuilder header(String name, String value) {
            this.builder.header(name, value);
            return this;
        }

        public CustomHttpRequestBuilder method(String method, BodyPublisher bodyPublisher) {
            this.builder.method(method, bodyPublisher);
            return this;
        }

        public CustomHttpRequestBuilder timeout(Duration duration) {
            this.builder.timeout(duration);
            return this;
        }

        public CustomHttpRequestBuilder version(Version version) {
            this.builder.version(version);
            return this;
        }

        public CustomHttpRequest build() {
            return new CustomHttpRequest(builder.build());
        }
    }
}
