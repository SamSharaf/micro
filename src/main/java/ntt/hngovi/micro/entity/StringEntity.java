/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntt.hngovi.micro.entity;

import java.io.Serializable;
/**
 *
 * @author ngovih
 */

public class StringEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String message;

    public StringEntity() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
}
