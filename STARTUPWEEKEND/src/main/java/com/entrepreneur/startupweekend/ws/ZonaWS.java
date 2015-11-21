package com.entrepreneur.startupweekend.ws;

import com.entrepreneur.startupweekend.modelo.Zona;
import com.entrepreneur.startupweekend.servicios.ServiceSW;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/zona")
@Api(value = "zona", description = "WS para Zona")
public class ZonaWS {

    @Autowired
    private ServiceSW serviceSW;
    
    public ZonaWS() {
    }

    @PUT
    @Path("/put")
    @ApiOperation(value = "ws para insertar la zona")
    @Consumes(MediaType.APPLICATION_JSON)    
    public Response putZona(@ApiParam("zona")Zona zona) {
        try {                          
            serviceSW.persistZona(zona);
            return Response.status(200).entity(zona).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
    

}
