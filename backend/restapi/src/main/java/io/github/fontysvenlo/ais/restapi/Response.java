package io.github.fontysvenlo.ais.restapi;

public class Response {
    private final String status;
    private final Object body;

    public Response(String message, Object body) {
        this.status = message;
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public Object getBody() {
        return body;
    }
}