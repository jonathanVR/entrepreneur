package com.entrepreneur.startupweekend.ws;

import com.entrepreneur.startupweekend.modelo.GpsMessage;
import com.entrepreneur.startupweekend.modelo.Usuario;
import com.pusher.rest.Pusher;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

@Component
@Path("/posicion")
@Api(value = "posicion", description = "WS para la Posicion")
public class PosicionWS {

    public PosicionWS() {
    }
   
    @PUT
    @Path("/putPosicion/{claveCliente}/{latitud}/{longitud}")
    @ApiOperation(value = "ws para almacenar la posicion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUsuario(@PathParam("claveCliente")String claveCliente) {
        try {
            Pusher pusher = new Pusher("154195", "eb77ec29726941e8ea60", "3c719e822f3327203963");//apiId, apiKey, apiSecret
            GpsMessage gpsMessage = new GpsMessage("CEL-VLADY", 0L, 0L);
            //pusher.trigger("channel-hackaton", "gps", Collections.singletonMap("message", "Aqui desde la casa del Henry "+new Date()));
            pusher.trigger("hackaton", "gps", gpsMessage);
            return Response.status(200).entity(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    

}
