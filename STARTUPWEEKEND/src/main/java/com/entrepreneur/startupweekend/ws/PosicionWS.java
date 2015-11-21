package com.entrepreneur.startupweekend.ws;

import com.entrepreneur.startupweekend.modelo.GpsMessage;
import com.entrepreneur.startupweekend.modelo.Posicion;
import com.entrepreneur.startupweekend.modelo.UserPreferences;
import com.entrepreneur.startupweekend.servicios.ServiceSW;
import com.pusher.rest.Pusher;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/posicion")
@Api(value = "posicion", description = "WS para la Posicion")
public class PosicionWS {
    
    @Autowired
    private ServiceSW usuarioService;

    public PosicionWS() {
    }
   
    @POST
    @Path("/mobileGps")
    @ApiOperation(value = "ws para almacenar la posicion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response mobileGps(GpsMessage gpsMessage) {
        try {
            Posicion posicion = new Posicion();
            posicion.setIdUsuario(gpsMessage.getSerial());
            posicion.setLatitud(gpsMessage.getLatitude());
            posicion.setLongitud(gpsMessage.getLongitude());
            usuarioService.persistPosicion(posicion);
            
            Pusher pusher = new Pusher("154195", "eb77ec29726941e8ea60", "3c719e822f3327203963");//apiId, apiKey, apiSecret
            //GpsMessage gpsMessage = new GpsMessage(idUsuario, latitud, longitud);
            pusher.trigger("mobileGps", "gps", gpsMessage);
            return Response.status(200).entity(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
    @POST
    @Path("/inZone/{idUsuario}/{zone}")
    @ApiOperation(value = "ws para almacenar la posicion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inZone(@PathParam("idUsuario")String idUsuario, @PathParam("idZone") String zone) {
        try {
            
            //Get User Preferences
            UserPreferences  userPreferences;
                    
            //Get Customers in Zone
            //List<Cliente> customers=getCustomersInZone(idZone);
            
            //Match Preferences vs Customers
            
            
            //Send Notifications
            
            return Response.status(200).entity(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
    
    
    

}
