package com.example.demo.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created on 18/10/22
 *
 * @author wb
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Response response;
        if (exception instanceof NotFoundException) {
            response = Response.status(Response.Status.NOT_FOUND).build();
        } else {
            response = Response.serverError().build();
        }
        return response;
    }
}
