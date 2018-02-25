/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.julianjupiter.jsr371mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author julez
 */
@Controller
@Path("hello-world")
public class HelloWorldController {
    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GET
    public String index() {
        logger.info("/app/hello-world");
        return "index.jsp";
    }
}
