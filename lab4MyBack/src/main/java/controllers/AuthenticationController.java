package controllers;

import ejb.Authentication;
import ejb.DotDataService;
import ejb.UserDataService;
import domain.DotData;
import util.SendedDot;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sign")
public class AuthenticationController {

    @EJB
    Authentication authentication;

    @EJB
    DotDataService hitDataRecord;

    @EJB
    UserDataService userRecord;

    @GET
    @Path("/in/{login}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SendedDot> signIn(@PathParam("login") String Login, @PathParam("password") String Password, @Context HttpServletRequest request) {
        boolean searchingResult = authentication.findUser(Login,Password);
        HttpSession session = request.getSession(true);
        if(searchingResult){
            int user_id = userRecord.getUser(Login, Password).getId();
            session.setAttribute("login", Login);
            session.setAttribute("id", user_id);
            return hitDataRecord.getDotData(user_id);
        }
        return null;
    }

    @GET
    @Path("/out")
    @Produces(MediaType.APPLICATION_JSON)
    public Response signOut(String content, @Context HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("login");
            session.removeAttribute("id");
            return Response.ok().build();
        }
        catch (Exception e){
            return Response.status(500).build();
        }
    }
}