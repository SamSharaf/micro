/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntt.hngovi.micro.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import ntt.hngovi.micro.business.MessageControl;

/**
 *
 * @author ngovih
 */
@Path("message")
public class Message {
    @GET
    public String messaging() {
        return new MessageControl().createMessage("hello micro").getMessage();
    }
}
