package com.denysque.testdemo.ui.search_city;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.denysque.testdemo.R;

import java.util.Objects;

public class SearchDialogFragment extends DialogFragment {
    private SearchCityCallback callback;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.searching_city, null))
                .setPositiveButton(R.string.search, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = getDialog().findViewById(R.id.searching_city__edit_text);
                        callback.cityWeather(editText.getText().toString().trim());
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (SearchCityCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement SearchCityCallback");
        }
    }
}
