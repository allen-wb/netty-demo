package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created on 18/10/22
 *
 * @author wb
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("/demo")
public class JDApplyResource {

    private final static Logger logger = LoggerFactory.getLogger(JDApplyResource.class);

    @POST
    @Path("test")
    public String test(@QueryParam("id") String id, @QueryParam("name") String name) {
        logger.info("id=" + id + ", name=" + name);
        return "success";
    }


}
