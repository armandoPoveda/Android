package com.example.arpoga.actividadalertdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button boton_Fecha, boton_Hora, boton_Color;
    private TextView View_Fecha, View_Hora, View_Color;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View_Fecha = findViewById(R.id.textView_Fecha);
        View_Hora = findViewById(R.id.textView_Hora);
        View_Color = findViewById(R.id.textView_Color);

        boton_Hora = findViewById(R.id.button_Elegir_Hora);
        boton_Hora.setOnClickListener(this);
        boton_Fecha = findViewById(R.id.button_Elegir_Fecha);
        boton_Fecha.setOnClickListener(this);
        boton_Color = findViewById(R.id.button_Elegir_Color);
        boton_Color.setOnClickListener(this);

        builder = new AlertDialog.Builder(MainActivity.this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_Elegir_Hora:

                DialogFragment timePickerDialog = new MyTimePickerDialog();
                timePickerDialog.show(getFragmentManager(), "SimpleDialog");
                break;

            case R.id.button_Elegir_Fecha:

                DialogFragment dialogFragment = new MyDatePickerDialog();
                dialogFragment.show(getFragmentManager(), "SimpleDialog");
                break;

            case R.id.button_Elegir_Color:

                DialogFragment dialogofragmento = new MyDialogFragment();
                dialogofragmento.show(getFragmentManager(), "SimpleDialog");
                break;

        }

    }
    @Override
    protected void onSaveInstanceState(Bundle guardar) {
        super.onSaveInstanceState(guardar);
        guardar.putString("hora", View_Hora.getText().toString());
        guardar.putString("fecha", View_Fecha.getText().toString());
        guardar.putInt("color", View_Color.getTextColors().getDefaultColor());
    }

    @Override
    protected void onRestoreInstanceState(Bundle restaurar) {
        super.onRestoreInstanceState(restaurar);
        View_Hora.setText(restaurar.getString("hora"));
        View_Fecha.setText(restaurar.getString("fecha"));
        View_Color.setTextColor(restaurar.getInt("color"));
    }
}
