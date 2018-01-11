/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntt.hngovi.micro.business;

import ntt.hngovi.micro.entity.StringEntity;

/**
 *
 * @author ngovih
 */
public class MessageControl {
    public StringEntity createMessage(String string) {
        StringEntity stringEntity = new StringEntity();
        stringEntity.setMessage(string);
        return stringEntity;
    }
}
