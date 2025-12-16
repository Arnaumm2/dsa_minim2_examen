package edu.upc.dsa_android_DriveNdodge.ui.rankingMinim2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import edu.upc.dsa_android_DriveNdodge.R;
import edu.upc.dsa_android_DriveNdodge.models.Ranking;
import edu.upc.dsa_android_DriveNdodge.models.UsrRanking;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private List<Ranking> rankings;

    public RankingAdapter(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ranking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ranking ranking = rankings.get(position);

        // La posición es el índice + 1 (para que empiece en 1º, no en 0º)
        holder.position.setText((position + 1) + "º");
        holder.name.setText(ranking.getName());
        Glide.with(holder.itemView)
                .load(ranking.getAvatar())
                .placeholder(R.drawable.ic_avatar_placeholder)
                .error(R.drawable.ic_avatar_placeholder)
                .into(holder.imgAvatar);
        holder.points.setText(ranking.getPoints() + " pts");
    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView position, name, points;
        ImageView imgAvatar;

        public ViewHolder(View view) {
            super(view);
            position = view.findViewById(R.id.textPosition);
            name = view.findViewById(R.id.textUsername);
            imgAvatar = view.findViewById(R.id.imgAvatar);
            points = view.findViewById(R.id.textScore);
        }
    }
}