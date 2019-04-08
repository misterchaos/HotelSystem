package com.hyc.www.exception;

/**
 * @author HYC kobe524348@gmail.com
 * @program XHotel
 * @description 用于封装和抛出dao层的异常
 * @date 2019-04-08 00:47
 */
public class DaoException extends RuntimeException {

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
