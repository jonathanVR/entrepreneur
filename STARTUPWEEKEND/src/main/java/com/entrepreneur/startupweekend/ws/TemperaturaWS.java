package com.entrepreneur.startupweekend.ws;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

@Component
@Path("/temperatura")
@Api(value = "temperatura", description = "WS para Temperatura")
public class TemperaturaWS {

    public TemperaturaWS() {
    }

    @PUT
    @Path("/put/{cliente}/{temperatura}")
    @ApiOperation(value = "ws para insertar la temperatura de un lugar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUsuario(@PathParam("cliente")String cliente, @PathParam("temperatura")String temperatura) {
        try {            
            System.out.println("Hello World!!!");
            
          
            return Response.status(200).entity("Hola Mundo").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

    @GET
    @Path("/get")
    @ApiOperation(value = "ws para guardar la temperatura")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsuarios(){
        try {            
            return Response.status(200).entity("hola mundo").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
}
