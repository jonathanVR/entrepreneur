package com.entrepreneur.startupweekend.ws;

import com.entrepreneur.startupweekend.modelo.Usuario;
import com.entrepreneur.startupweekend.servicios.UsuarioService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/usuario")
@Api(value = "usuario", description = "WS para Usuario")
public class UsuarioWS {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioWS() {
    }

    @PUT
    @Path("/put")
    @ApiOperation(value = "ws para insertar un Usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUsuario(@ApiParam(value = "usuario", required = true) Usuario usuario) {
        try {
            usuario = usuarioService.persistUsuario(usuario);
            return Response.status(200).entity(usuario).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
    @GET
    @Path("/get")
    @ApiOperation(value = "ws para listar los usuarios")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUsuarios(){
        try {
            
            return Response.status(200).entity(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

}
