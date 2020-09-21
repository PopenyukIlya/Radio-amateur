package com.example.servingwebcontent.exceptions;

import org.springframework.security.core.AuthenticationException;

public class EmailNotActivateException extends AuthenticationException {
    public EmailNotActivateException(String msg) {
        super(msg);
    }
}
