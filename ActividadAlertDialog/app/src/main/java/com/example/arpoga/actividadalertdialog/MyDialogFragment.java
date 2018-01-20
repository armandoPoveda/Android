package com.example.arpoga.actividadalertdialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by arpoga on 18/01/2018.
 */

public class MyDialogFragment extends DialogFragment {

    public MyDialogFragment() {

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        return createSimpleDialog();

    }

    /**
     * Crea un diálogo de alerta sencillo
     * @return Nuevo diálogo
     */
    public AlertDialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.Titulo).setItems(R.array.color_array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int posicion) {

                int[] colores = getResources().getIntArray(R.array.rainbow);

                    ((TextView) getActivity().findViewById(R.id.textView_Color)).setTextColor(colores[posicion]);
            }
        });

        return builder.create();
    }

}
