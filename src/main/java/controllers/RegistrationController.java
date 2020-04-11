package controllers;

import ejb.Registration;
import ejb.UserDataService;
import domain.UserData;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.UnsupportedEncodingException;

@Path("/registration")
@ApplicationScoped
public class RegistrationController {

    @Context
    UriInfo uriInfo;

    @EJB
    private Registration registration;

    @EJB
    private UserDataService userRecord;

    @GET
    @Path("/register/{login}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserData getUser(@PathParam("login") String Login, @PathParam("password") String Password, @Context HttpServletRequest request) throws UnsupportedEncodingException {

        UserData user = new UserData();

        String hashPassword = Password;

        user.setPassword(Password);
        user.setLogin(Login);
        int statusCode = registration.addUser(user);
        HttpSession session = request.getSession();
        if(statusCode == 200){
            int user_id = userRecord.getUser(Login,hashPassword).getId();
            session.setAttribute("login", Login);
            session.setAttribute("id", user_id);
            return  user;
        }
        else{
            return null;
        }
    }
}