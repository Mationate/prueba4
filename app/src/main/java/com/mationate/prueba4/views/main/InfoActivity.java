package com.mationate.prueba4.views.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mationate.prueba4.R;
import com.mationate.prueba4.models.PokeType;
import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    private PokeType pokeType;
    private ImageView pokeSprite;
    private TextView pokeName, pokeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        pokeName = findViewById(R.id.pokeName);
        pokeId = findViewById(R.id.pokeId);
        pokeSprite = findViewById(R.id.pokeSpriteIv);

        pokeType = (PokeType) getIntent().getSerializableExtra("poketype");


        try {
            for (String sprite : pokeType.getSprites().getSprites()) {
                Log.e("SPRITE", sprite);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Picasso
                .get()
                .load(pokeType.getSprites().getFront_default())
                .centerCrop()
                .fit()
                .into(pokeSprite);

        pokeName.setText(pokeType.getName());
        pokeId.setText(String.valueOf(pokeType.getId()));
    }
}
