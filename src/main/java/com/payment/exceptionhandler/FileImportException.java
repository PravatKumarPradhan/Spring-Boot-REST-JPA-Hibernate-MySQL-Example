/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payment.exceptionhandler;

/**
 *
 * @author Gulam Mustafa
 */
public class FileImportException extends Exception {

    public FileImportException() {
    }

    public FileImportException(String message) {
        super(message);
    }

    public FileImportException(Throwable cause) {
        super(cause);
    }

    public FileImportException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileImportException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
