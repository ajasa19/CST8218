/*
 *Class:    SpriteFacadeREST
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cst8218.jasa0008.entity.Sprite;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ajasa
 * http://localhost:8080/AsimSprite-war/webresources/cst8218.jasa0008.entity.sprite
 */
/*@DeclareRoles({"Admin,RestGroup"})*/
    /*@RolesAllowed({"Admin,RestGroup"})*/
@Stateless
@Path("cst8218.jasa0008.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "AsimSprite-ejbPU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    /**
    * POST without id 
    * create sprite entity if no id is supplied to request can be overriden
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sprite entity) {
        super.create(entity);
    } 
    
    /**
    * POST with id 
    * edit sprite object values if id is supplied in request and id is valid
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    // Response method found on net
    public Response editPost(@PathParam("id") Long id, Sprite entity) {
        try {
            Sprite sprite = super.find(id);
            if ( sprite.getId().equals(id) ) {
                super.edit(entity);
            } else {
                throw new Exception ("no id");
            }
            return Response.status(Response.Status.OK).build(); 
            //return Response.status(Response.Status.OK).entity(sprite).build(); //debug   
        } catch (Exception e) {
            return Response.serverError().build();
        }   
    }

    /**
    * PUT with id 
    * edit sprite object values if id is supplied in request and id is valid
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Long id, Sprite entity) {
        try {
            Sprite sprite = super.find(id);
            if ( sprite.getId().equals(id) ) {
                super.edit(entity);   
            }  else {
               throw new Exception ("no id");
            }
            return Response.status(Response.Status.OK).build();
            //return Response.status(Response.Status.OK).entity(sprite).build(); //debug
        } catch (Exception e) {
            return Response.serverError().build();
        }   
    }

    /**
    * DELETE with id 
    * delete sprite if passed id is found
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /** 
    * GET with id 
    * Get and display values of sprite object matching supplied id
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sprite find(@PathParam("id") Long id) {
        return super.find(id);
    }

     /** 
    * GET without id 
    * Get and display values of all sprite objects can be overriden
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    /** 
    * GET with id span
    * Get and display values of sprite object matching supplied id span (eg. 1 - 3)
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /** 
    * GET with count
    * Get and display number of sprite objects
    */
    /*@RolesAllowed({"Admin,RestGroup"})*/
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /** 
    * EntityManager
    * supply EntityManager to all requests
    */ 
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
