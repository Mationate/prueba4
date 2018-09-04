package com.mationate.prueba4.background;

import android.os.AsyncTask;

import com.mationate.prueba4.models.PokeType;
import com.mationate.prueba4.network.GetPoke;
import com.mationate.prueba4.network.PokemonInterceptor;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class GetPokeTypeData extends AsyncTask<Integer, Void, PokeType> {
    @Override
    protected PokeType doInBackground(Integer... params) {
        int id = params[0];
        GetPoke request = new PokemonInterceptor().get();
        Call<PokeType> call = request.getPokemon(id);
        try {
            Response<PokeType> response = call.execute();
            if (response.code() == 200 && response.isSuccessful()) {
                PokeType getPoke = response.body();
                if (getPoke != null){
                    return getPoke;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
