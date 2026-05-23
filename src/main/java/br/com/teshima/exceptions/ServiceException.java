package br.com.teshima.exceptions;

public class ServiceException extends RuntimeException{

    public ServiceException(String msg) {
        super(msg);
    }
}
