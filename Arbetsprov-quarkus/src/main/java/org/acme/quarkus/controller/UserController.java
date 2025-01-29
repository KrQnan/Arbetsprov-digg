package org.acme.quarkus.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/digg")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @GET
    @Path("/user")
    public Response listUsers() {
        //Vi använder panache för att enkelt lista alla våra entities
        return Response.status(200).entity(Users.listAll()).build();

    }

    @GET
    @Path("/user/{id}")
    public Response getUserById(@PathParam("id") Long id) {
        //Felhantering om id ej finns
        return Response.status(200).entity(Users.findByIdOptional(id)
                .orElseThrow(() ->
                        new WebApplicationException(
                                Response
                                        .status(404)
                                        .entity("Kunde inte hitta användare med id: " + id)
                                        .build())
                )).build();
    }

    @POST
    @Path("/create")
    @Transactional
    public Response addUser(Users user) {
        try{
            //Här kollar vi om användaren redan är sparad, isånnafall så tar vi bort den temporära användaren vi har i metoden
            if(user.isPersistent()){
                user.delete();
            }
            //Om användaren är ny så sparar vi den
            user.persist();
            log.info("Användare sparad: " + user.name);
            return Response.status(200).entity(("Användare tillagd")).build();
        }
        catch (Exception e){
            throw new WebApplicationException(Response.status(406).entity("Gick ej att skapa användare").build());
        }
    }

    @POST
    @Path("/delete/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        //Fel hantering om id ej finns
        Users.findByIdOptional(id)
                .orElseThrow(() ->
                        new WebApplicationException(
                                Response
                                        .status(404)
                                        .entity("Kunde inte ta bort användare med id: " + id)
                                        .build())
                );
        //Här använder vi en bra panache metod för att hitta en användare med id och ta bort den
        Users.deleteById(id);
        log.info("Användare borttagen");
        return Response.status(204).entity("Användare borttagen").build();
    }

    @POST
    @Path("/update/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id, Users newuser) {
        //Fel hantering om id ej finns
        Users.findByIdOptional(id)
                .orElseThrow(() ->
                        new WebApplicationException(
                                Response
                                        .status(404)
                                        .entity("Kunde inte uppdatera användare med id: " + id)
                                        .build())
                );
        //Vi hämtar en användare vi vill uppdatera baserat på id sedan skriver vi över det gamla med nytt och sparar
        Users user = Users.findById(id);
        user.name = newuser.name;
        user.address = newuser.address;
        user.telephone = newuser.telephone;
        user.email = newuser.email;
        user.persistAndFlush();
        log.info("Användare uppdaterad: " + user.name);
        return Response.status(200).entity("Användare uppdaterad").build();
    }
}
