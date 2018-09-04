package com.mationate.prueba4.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mationate.prueba4.R;
import com.mationate.prueba4.models.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private List<Pokemon> pokeList = new ArrayList<>();

    public PokemonAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Pokemon pokemon = pokeList.get(position);

        holder.name.setText(pokemon.getName());
        Picasso.get()
                .load("http://pokeapi.co/media/sprites/pokemon/" + pokemon.getNumber() + ".png")
                .centerCrop()
                .fit()
                .into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return pokeList.size();
    }

    public void update(List<Pokemon> list) {
        pokeList.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView photo;


        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTv);
            photo = itemView.findViewById(R.id.photoIv);
        }

    }
}
