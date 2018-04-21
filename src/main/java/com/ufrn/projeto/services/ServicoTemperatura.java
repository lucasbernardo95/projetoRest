/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.projeto.services;

import com.ufrn.projeto.dao.implementations.TemperaturaDaoImpl;
import com.ufrn.projeto.dao.interfaces.ITemperaturaDao;
import com.ufrn.projeto.model.Temperatura;
import com.ufrn.projeto.response.OutputMessage;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.criterion.Order;

/**
 *
 * @author Aluno
 */
@Path("/temperatura")
public class ServicoTemperatura {
    
    @GET
    @Path("/teste")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teste() {
        return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new OutputMessage(500, "Teste funcionando"))
                    .build();

    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Temperatura t) {

        try {
            ITemperaturaDao temperaturaDAO = new TemperaturaDaoImpl();
            temperaturaDAO.save(t);
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new OutputMessage(500, e.getMessage()))
                    .build();

        }

        return Response
                .status(Response.Status.CREATED)
                .entity(t)
                .build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        ITemperaturaDao temperaturaDAO = new TemperaturaDaoImpl();
        Temperatura obj = temperaturaDAO.findById(id);
        if (obj == null) {
            return Response
                    .status(Response.Status.NO_CONTENT)
                    .build();

        }
        try {
            temperaturaDAO.delete(obj);
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new OutputMessage(500, e.getMessage()))
                    .build();

        }
        return Response
                .status(Response.Status.OK)
                .entity(new OutputMessage(200, "Objeto removido."))
                .build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Temperatura t) {
        try {
            ITemperaturaDao temperaturaDAO = new TemperaturaDaoImpl();
            temperaturaDAO.save(t);
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new OutputMessage(500, e.getMessage()))
                    .build();

        }

        return Response
                .status(Response.Status.OK)
                .entity(t)
                .build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listById(@PathParam("id") int id) {
        try {
            ITemperaturaDao temperaturaDAO = new TemperaturaDaoImpl();
            Temperatura obj = temperaturaDAO.findById(id);
            if (obj == null) {
                return Response
                        .status(Response.Status.NO_CONTENT)
                        .build();

            } else {
                return Response
                        .status(Response.Status.OK)
                        .entity(obj)
                        .build();

            }
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new OutputMessage(500, e.getMessage()))
                    .build();

        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll(
            @QueryParam("orderby") @DefaultValue("id") String orderBy,
            @QueryParam("sort") @DefaultValue("asc") String sort) {
        try {
            ITemperaturaDao temperaturaDAO = new TemperaturaDaoImpl();
            List<Temperatura> obj;
            if (sort.equals("desc")) {
                obj = temperaturaDAO.findAll(Order.desc(orderBy));
            } else {
                obj = temperaturaDAO.findAll(Order.asc(orderBy));
            }
            if (obj == null) {
                return Response
                        .status(Response.Status.NO_CONTENT)
                        .build();

            } else {
                return Response
                        .status(Response.Status.OK)
                        .entity(obj)
                        .build();

            }
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new OutputMessage(500, e.getMessage()))
                    .build();

        }
    }
}
