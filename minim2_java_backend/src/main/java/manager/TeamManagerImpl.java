package manager;

import database.BaseDeDatos;
import database.impl.BaseDeDatosHashMap;
import database.models.Ranking;
import database.models.Usuario;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TeamManagerImpl implements TeamManager {
    private static final Logger LOGGER = Logger.getLogger(AuthManagerImpl.class);

    private static TeamManagerImpl instance;
    private final BaseDeDatos baseDeDatos;

    private TeamManagerImpl() {
        this.baseDeDatos = BaseDeDatosHashMap.getInstance();
    }

    public static TeamManagerImpl getInstance() {
        if (instance == null) {
            instance = new TeamManagerImpl();
            LOGGER.info("Instancia de TeamManager creado");
        }
        return instance;
    }



    @Override
    public List<Ranking> getTeamsRanking() {
        LOGGER.info("Iniciando lista de rankings de usuarios");
        List<Ranking> ranking = new ArrayList<>(this.baseDeDatos.getTeamsRanking());
        ranking.sort((u1, u2) ->
                Integer.compare(u2.getPoints(), u1.getPoints()));
        int users = ranking.size();
        for(int i = 0 ; i < users; i++) {
            LOGGER.info("Lista de rankings de usuarios creado= " + ranking.get(i).getName() + " / " + ranking.get(i).getPoints());
        }

        return ranking;
    }
}
