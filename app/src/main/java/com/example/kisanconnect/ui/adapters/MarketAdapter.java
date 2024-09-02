package com.example.kisanconnect.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yourappname.R;
import com.yourappname.models.Market;
import java.util.ArrayList;
import java.util.List;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {

    private List<Market> markets = new ArrayList<>();

    @NonNull
    @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_market, parent, false);
        return new MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {
        Market market = markets.get(position);
        // Bind market data to views
    }

    @Override
    public int getItemCount() {
        return markets.size();
    }

    public void submitList(List<Market> markets) {
        this.markets = markets;
        notifyDataSetChanged();
    }

    static class MarketViewHolder extends RecyclerView.ViewHolder {
        public MarketViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views
        }
    }
}