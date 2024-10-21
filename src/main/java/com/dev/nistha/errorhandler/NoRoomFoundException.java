package com.dev.nistha.errorhandler;

public class NoRoomFoundException extends Throwable {

    public NoRoomFoundException(String s) {
        super(String.format("Error: %s", s));
    }

}
