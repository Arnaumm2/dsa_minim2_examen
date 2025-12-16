package edu.upc.dsa_android_DriveNdodge.ui.rankingMinim2;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import edu.upc.dsa_android_DriveNdodge.R;
import edu.upc.dsa_android_DriveNdodge.api.RetrofitClient;
import edu.upc.dsa_android_DriveNdodge.api.ShopService;
import edu.upc.dsa_android_DriveNdodge.api.TeamService;
import edu.upc.dsa_android_DriveNdodge.models.Ranking;
import edu.upc.dsa_android_DriveNdodge.models.UsrRanking;
import edu.upc.dsa_android_DriveNdodge.ui.rankingMinim2.RankingAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewRankingActivityMinim2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private List<Ranking> rankingList = new ArrayList<>();
    private RankingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_minim2);

        recyclerView = findViewById(R.id.recyclerViewRanking);
        progressBar = findViewById(R.id.progressBar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RankingAdapter(rankingList);
        recyclerView.setAdapter(adapter);

        loadRanking();
    }

    private void loadRanking() {
        progressBar.setVisibility(View.VISIBLE);

        TeamService service = RetrofitClient.getClient().create(TeamService.class);
        Call<List<Ranking>> call = service.getRanking();

        call.enqueue(new Callback<List<Ranking>>() {
            @Override
            public void onResponse(Call<List<Ranking>> call, Response<List<Ranking>> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    rankingList.clear();
                    rankingList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Ranking>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ViewRankingActivityMinim2.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }
}