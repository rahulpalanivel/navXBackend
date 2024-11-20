package com.navx.backend.Auth;

public class SignupResponse {
    private String response;

    public SignupResponse(String message) {
        this.response = message;
    }

    public String getMessage() {
        return response;
    }

    public void setMessage(String message) {
        this.response = message;
    }
}
