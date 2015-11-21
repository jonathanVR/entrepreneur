package com.entrepreneur.startupweekend.ws;

import com.entrepreneur.startupweekend.modelo.Zona;
import com.entrepreneur.startupweekend.servicios.ServiceSW;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
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

    @POST
    @Path("/post")
    @ApiOperation(value = "ws para insertar la zona")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postZona(@FormParam("nombreZona")String nombreZona, @FormParam("jsonZona")String jsonZona) {
        try {  
            Zona zona = new Zona();
            zona.setNombre(nombreZona);
            zona.setJsonZona(jsonZona);
            serviceSW.persistZona(zona);
            return Response.status(200).entity(zona).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
    

}
