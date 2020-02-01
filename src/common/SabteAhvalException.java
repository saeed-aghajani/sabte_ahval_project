/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author saeed
 */
public class SabteAhvalException extends Exception {
    private CustomExceptionMessage customExceptionMessage;//persistence, roleback, checking
    private String field;
    private String message;

    public SabteAhvalException(CustomExceptionMessage customExceptionMessage, String field, String message) {
        this.customExceptionMessage = customExceptionMessage;
        this.field = field;
        this.message = message;
    }

    public CustomExceptionMessage getCustomExceptionMessage() {
        return customExceptionMessage;
    }

    public void setCustomExceptionMessage(CustomExceptionMessage customExceptionMessage) {
        this.customExceptionMessage = customExceptionMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
