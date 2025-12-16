package edu.upc.dsa_android_DriveNdodge.api;

import java.util.List;

import edu.upc.dsa_android_DriveNdodge.models.Item;
import edu.upc.dsa_android_DriveNdodge.models.Ranking;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamService {

    @GET("/v1/teams/ranking")
    Call<List<Ranking>> getRanking();
}
