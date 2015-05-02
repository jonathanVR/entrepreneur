package com.entrepreneur.shuffle.ws;

import com.entrepreneur.shuffle.modelo.adm.AdmUsuario;
import com.entrepreneur.shuffle.servicios.adm.AdmUsuarioService;
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
@Path("/admUsuario")
@Api(value = "admUsuario", description = "WS for AdmUsuario")
public class AdmUsuarioWS {

    @Autowired
    private AdmUsuarioService admUsuarioService;

    public AdmUsuarioWS() {
    }

    @PUT
    @Path("/putAdmUsuario")
    @ApiOperation(value = "operation to INSERT a AdmUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putAdmUsuario(@ApiParam(value = "admUsuario", required = true) AdmUsuario admUsuario) {
        try {
            admUsuario = admUsuarioService.persistAdmUsuario(admUsuario);
            return Response.status(200).entity(admUsuario).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

}
