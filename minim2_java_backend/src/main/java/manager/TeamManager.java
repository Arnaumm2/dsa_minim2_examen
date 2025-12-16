package manager;

import database.models.Ranking;
import database.models.Usuario;
import java.util.List;

public interface TeamManager {
    List<Ranking> getTeamsRanking();
}
