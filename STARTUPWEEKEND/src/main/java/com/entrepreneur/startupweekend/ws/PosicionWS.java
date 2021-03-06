package com.entrepreneur.startupweekend.ws;

import com.entrepreneur.startupweekend.modelo.Feature;
import com.entrepreneur.startupweekend.modelo.GpsMessage;
import com.entrepreneur.startupweekend.modelo.Posicion;
import com.entrepreneur.startupweekend.modelo.UserPreferences;
import com.entrepreneur.startupweekend.modelo.Zona;
import com.entrepreneur.startupweekend.modelo.ZonaPojo;
import com.entrepreneur.startupweekend.modelo.ZonaPunto;
import com.entrepreneur.startupweekend.servicios.ServiceSW;
import com.pusher.rest.Pusher;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/posicion")
@Api(value = "posicion", description = "WS para la Posicion")
public class PosicionWS {
    
    @Autowired
    private ServiceSW serviceSW;

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
            serviceSW.persistPosicion(posicion);
            
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
    
    @POST
    @Path("/saveZone")
    @ApiOperation(value = "ws para almacenar la posicion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveZone(ZonaPojo zonaPojo) {
        try {
            
            Zona zone=new Zona();
            zone.setNombre(zonaPojo.getNombreZona());
            zone=serviceSW.persistZona(zone);
            
            for(ZonaPunto punto:zonaPojo.getCoordinates())
            {   
            }
            
            return Response.status(200).entity(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
    
    @GET
    @Path("/getZones")
    @ApiOperation(value = "ws para almacenar la posicion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getZones() {
        try {
            
            List<Zona> zonas= serviceSW.getZones();
            System.out.println("ZOnas::: "+zonas);
            List<Feature> features=new ArrayList<Feature>();
            
            Feature feature;
            Map<String,Object> values;
            Double[][] coordinates;
            
            for (Zona zona : zonas) {
               feature=new Feature();
               
               values=new HashMap<String, Object>();
               values.put("id", zona.getNombre());
               feature.setProperties(values);
               
               values=new HashMap<String, Object>();
               values.put("type","Polygon");
               
               List<ZonaPunto> puntos=serviceSW.getZonaPuntoByZona(zona);
               coordinates=new Double[puntos.size()][3];
               int i=0;
               for(ZonaPunto punto:puntos)
               {    coordinates[i][0]=punto.getLongitud();
                    coordinates[i][1]=punto.getLatitud();
                    coordinates[i][2]=0d;
                    i++;
               }
               values.put("coordinates", coordinates);
               feature.setGeometry(values);
               
               features.add(feature);
            }
            
            Map<String, Object> zones=new HashMap<String,Object>();
            zones.put("type", "FeatureCollection");
            zones.put("features", features);
            
            return Response.status(200).entity(zones).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
    @POST
    @Path("/notInZone")
    @ApiOperation(value = "ws for ")
    @Produces(MediaType.APPLICATION_JSON)
    public Response enviaCorreo(@FormParam("usuario") String usuario, @FormParam("zona") String zona) {
        try {                                    
            serviceSW.enviarCorreoPrueba(usuario, zona);
            return Response.status(200).entity("OK").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    
}
