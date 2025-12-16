package services;

import database.models.Item;
import database.models.Ranking;
import database.models.Usuario;
import manager.ShopManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import manager.TeamManagerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/teams", description = "Servicios de equipos")
@Path("/teams")
public class TeamService {

    private final TeamManagerImpl teamManager;

    public TeamService() {
        this.teamManager = TeamManagerImpl.getInstance();
    }

    @GET
    @Path("/ranking")
    @ApiOperation(value = "Obtener todos los ranking ordenados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Item.class, responseContainer = "List")
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRanking() {
        List<Ranking> rankings = teamManager.getTeamsRanking();
        GenericEntity<List<Ranking>> entity = new GenericEntity<List<Ranking>>(rankings) {};
        return Response.status(200).entity(entity).build();
    }
}