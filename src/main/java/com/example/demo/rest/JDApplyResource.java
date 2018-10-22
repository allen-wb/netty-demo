package com.example.demo.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.AbstractMap.SimpleEntry;

/**
 * Created on 18/10/22
 *
 * @author wb
 */
@Produces(MediaType.APPLICATION_JSON)
@Path("/demo")
public class JDApplyResource {

    private static Map<String, Double> salePriceMap = Collections.unmodifiableMap(Stream.of(
            new SimpleEntry<>("50", 50.0),
            new SimpleEntry<>("100", 100.0),
            new SimpleEntry<>("200", 200.0),
            new SimpleEntry<>("500", 500.0),
            new SimpleEntry<>("1000", 1000.0),
            new SimpleEntry<>("2000", 2000.0),
            new SimpleEntry<>("5000", 5000.0)
    ).collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));


    @POST
    @Path("test")
    public String test(@Context UriInfo uriInfo, @QueryParam("id") String id, @QueryParam("name") String name) throws Exception {
        System.out.println("get +++++++++++++++++++++++++++++++++++++++++++++++++");
//        if (name == null) {
//            throw new Exception("");
//        }
        return "success";
    }


}
