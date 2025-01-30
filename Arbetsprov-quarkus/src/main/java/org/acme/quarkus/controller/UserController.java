package org.acme.quarkus.controller;

import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.DTO.User;
import org.acme.Entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/digg")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @GET
    @Path("/user")
    public Response listUsers() {
        //Vi använder panache för att enkelt lista alla våra entities
        return Response.status(200).entity(UserEntity.listAll()).build();

    }

    @GET
    @Path("/user/{id}")
    public Response getUserById(@PathParam("id") Long id) {
        //Felhantering om id ej finns
        return Response.status(200).entity(UserEntity.findByIdOptional(id)
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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(@Valid User user) {
        UserEntity userEntity = new UserEntity(user);
        try{
            //Om användaren är ny så sparar vi den
            userEntity.persist();
            log.info("Användare sparad: " + user.name);
            return Response.status(200).entity(("Användare tillagd")).build();
        }
        catch (Exception e){
            throw new WebApplicationException(Response.status(406).entity(e.getMessage() + user).build());
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        //Fel hantering om id ej finns
        UserEntity.findByIdOptional(id)
                .orElseThrow(() ->
                        new WebApplicationException(
                                Response
                                        .status(404)
                                        .entity("Kunde inte ta bort användare med id: " + id)
                                        .build())
                );
        //Här använder vi en bra panache metod för att hitta en användare med id och ta bort den
        UserEntity.deleteById(id);
        log.info("Användare borttagen");
        return Response.status(204).entity("Användare borttagen").build();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id,@Valid User user) {
        try{
            //Vi kör en query för att uppdatera användaren där vi skickar in parametrarna
            UserEntity.update("name = ?1, address = ?2, email = ?3, telephone = ?4 where id = ?5",
                    user.name, user.address, user.email, user.telephone, id );
            //Vi sätter våran användare till en ny användare so vi skickar in
            UserEntity newUser = new UserEntity(user);
            newUser.id = id;
            log.info("Användare uppdaterad: " + user.name);
            return Response.status(200).entity(newUser).build();
        } catch (PersistenceException e){
            throw new WebApplicationException(Response.status(406).entity(e.getMessage() + user).build());
        }

    }
}
