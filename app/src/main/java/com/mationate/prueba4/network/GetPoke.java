package com.mationate.prueba4.network;

import com.mationate.prueba4.models.PokeType;
import com.mationate.prueba4.models.PokemonWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetPoke {

    @GET("pokemon")
    Call<PokemonWrapper> getPokemonList(@Query("limit")int limit, @Query("offset")  int offset);

    @GET("pokemon/{id}")
    Call<PokeType> getPokemon(@Path("id") int id);
}
