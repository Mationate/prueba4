package com.mationate.prueba4.views.finder;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.mationate.prueba4.R;
import com.mationate.prueba4.background.GetPokeTypeData;
import com.mationate.prueba4.models.PokeType;
import com.mationate.prueba4.views.main.InfoActivity;

public class FinderDialogFragment extends DialogFragment {



    public FinderDialogFragment() {
    }

    public static FinderDialogFragment newInstance() {
        return new FinderDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_finder, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View btn = view.findViewById(R.id.searchBtn);
        final EditText editText = view.findViewById(R.id.searchEt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (text.trim().length() > 0 && text.trim().length() <= 807) {
                    int id = Integer.parseInt(text);
                    new GetPokemon().execute(id);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
    }

    private class GetPokemon extends GetPokeTypeData {

        @Override
        protected void onPreExecute() {
            setCancelable(false);
        }

        @Override
        protected void onPostExecute(PokeType pokeType) {
            setCancelable(true);

            if (pokeType != null) {

                dismiss();
                Intent intent = new Intent(getContext(), InfoActivity.class);
                intent.putExtra("poketype",pokeType);
                startActivity(intent);
            }

        }
    }

}
