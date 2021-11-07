package com.wgy.aup.exception;

import javax.jws.soap.SOAPBinding;

/**
 * @author wgy
 * @version 2021/10/4 15:58:38
 */
public class UserLoginException extends BaseException {

   public UserLoginException(String message) {
        super(message);
    }
}
