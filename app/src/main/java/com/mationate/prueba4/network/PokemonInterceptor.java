package com.mationate.prueba4.network;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonInterceptor {

    public static final String BASE_URL = "http://pokeapi.co/api/v2/";


    public GetPoke get() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetPoke poke = interceptor.create(GetPoke.class);
        return  poke;
    }

}
