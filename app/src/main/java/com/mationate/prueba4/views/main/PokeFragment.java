package com.mationate.prueba4.views.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mationate.prueba4.R;
import com.mationate.prueba4.adapters.PokemonAdapter;
import com.mationate.prueba4.background.GetPokeData;
import com.mationate.prueba4.models.Pokemon;

import java.util.List;


public class PokeFragment extends Fragment  {

    private PokemonAdapter adapter;
    private GridLayoutManager layoutManager;
    private boolean pendingRequest = false;
    private View horizontalLoading;


    public PokeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poke, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.pokemonsRv);
        horizontalLoading = view.findViewById(R.id.pokemonsPbh);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PokemonAdapter();
        recyclerView.setAdapter(adapter);
        new GetPokes().execute(0);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int position = layoutManager.findLastVisibleItemPosition();
                int total = layoutManager.getItemCount();

                if (total - 15 < position) {
                    if (!pendingRequest) {
                        pendingRequest = true;
                        horizontalLoading.animate().alpha(1).setDuration(200).start();
                        new GetPokes().execute(total);
                    }
                }
            }
        });


    }



    private class GetPokes extends GetPokeData {

        @Override
        protected void onPostExecute(List<Pokemon> pokemons) {
            getView().findViewById(R.id.pokemonsPb).animate().alpha(0).setDuration(200).start();
            horizontalLoading.animate().alpha(0).setDuration(200).start();
            adapter.update(pokemons);
            pendingRequest = false;
        }
    }
}
