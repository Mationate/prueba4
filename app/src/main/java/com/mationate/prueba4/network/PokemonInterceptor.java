package com.mationate.prueba4.network;


import com.mationate.prueba4.network.GetPoke;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonInterceptor {

    public static final String BASE_URL = "http://pokeapi.co/api/v2/";


    public GetPoke get() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetPoke poke = interceptor.create(GetPoke.class);
        /*The interceptor must return an interface, is the same interface where you wrote the methods for the request http*/
        return  poke;
    }

}
