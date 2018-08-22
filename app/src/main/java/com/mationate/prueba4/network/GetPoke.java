package com.mationate.prueba4.network;

import com.mationate.prueba4.models.Pokemon;
import com.mationate.prueba4.models.PokemonWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPoke {

    @GET("pokemon")
    Call<PokemonWrapper> getPokemonList(@Query("limit")int limit, @Query("offset")  int offset);
}
