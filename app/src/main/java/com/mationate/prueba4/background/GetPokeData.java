package com.mationate.prueba4.background;

import android.os.AsyncTask;

import com.mationate.prueba4.models.Pokemon;
import com.mationate.prueba4.models.PokemonWrapper;
import com.mationate.prueba4.network.GetPoke;
import com.mationate.prueba4.network.PokemonInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class GetPokeData extends AsyncTask<Integer, Void, List<Pokemon>> {


    @Override
    protected List<Pokemon> doInBackground(Integer... params) {
        int offset = params[0];
        GetPoke request = new PokemonInterceptor().get();
        Call<PokemonWrapper> call = request.getPokemonList(30, offset);
        List<Pokemon> pokemons = new ArrayList<>();

        try {

            Response<PokemonWrapper> response = call.execute();
            if (response.code() == 200 && response.isSuccessful()) {
                PokemonWrapper getPoke = response.body();
                if (getPoke != null) {
                    List<Pokemon> list = getPoke.getResults();
                    if (list != null && list.size() > 0) {
                        pokemons.addAll(list);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemons;
    }
}
