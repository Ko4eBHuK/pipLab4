package controllers;

import ejb.DotDataService;
import domain.DotData;
import util.SendedDot;
import ejb.UserDataService;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/dotdata")
public class DotRecordController {

    @EJB
    DotDataService dotDataRecord;

    @EJB
    UserDataService userRecord;

    @GET
    @Path("/add/{x}/{y}/{r}")
    @Produces(MediaType.APPLICATION_JSON)
    public DotData addDot(@PathParam("x") String x, @PathParam("y") String y, @PathParam("r") String r, @Context HttpServletRequest request) throws IOException {

        DotData rawDotData = new DotData();

        rawDotData.setX(Double.parseDouble(x));
        rawDotData.setY(Double.parseDouble(y));
        rawDotData.setR(Double.parseDouble(r));

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        AreaCheckerController areaCheckerController = new AreaCheckerController();
        DotData fullDotData = areaCheckerController.isPointInArea(rawDotData,id);
        dotDataRecord.addDotData(fullDotData);

        return fullDotData;
    }

    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SendedDot> readHitData(@Context HttpServletRequest request){
        HttpSession session = request.getSession();
        int user_id = Integer.parseInt(session.getAttribute("id").toString());
        return dotDataRecord.getDotData(user_id);
    }
}