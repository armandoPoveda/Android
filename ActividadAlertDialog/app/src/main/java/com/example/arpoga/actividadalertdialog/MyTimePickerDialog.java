package com.example.arpoga.actividadalertdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static android.app.Activity.RESULT_OK;

/**
 * Created by arpoga on 18/01/2018.
 */

public class MyTimePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        Calendar C = Calendar.getInstance();
       int hora = C.get(Calendar.HOUR);
        int minutos = C.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hora, minutos,true);

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hora, int minutos) {
        ((TextView) getActivity().findViewById(R.id.textView_Hora)).setText(hora+":"+minutos);

        Intent i = new Intent(getContext(), MainActivity.class);
        i.putExtra("hora", hora);
        i.putExtra("minuto", minutos);


    }

}
