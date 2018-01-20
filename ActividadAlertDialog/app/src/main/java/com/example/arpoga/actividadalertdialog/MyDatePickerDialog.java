package com.example.arpoga.actividadalertdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by arpoga on 18/01/2018.
 */

public class MyDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this  ,  year, month, day);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        ((TextView) getActivity().findViewById(R.id.textView_Fecha)).setText(day + "/" + (month + 1) + "/" + year);


    }
}
