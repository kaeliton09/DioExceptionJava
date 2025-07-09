package br.com.dio.exception;

public class userNotFoundException extends RuntimeException{
    public userNotFoundException(String message) {
        super(message);
    }
}
