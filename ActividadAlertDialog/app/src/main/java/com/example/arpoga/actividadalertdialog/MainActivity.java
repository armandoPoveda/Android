package com.example.arpoga.actividadalertdialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button boton_Fecha, boton_Hora, boton_Color;
    private TextView View_Fecha, View_Hora;
    private LinearLayout linear_Color;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View_Fecha = findViewById(R.id.textView_Fecha);
        View_Hora = findViewById(R.id.textView_Hora);
        linear_Color = findViewById(R.id.linearLayout_Color);

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
                final Calendar C = Calendar.getInstance();
                int hora = C.get(Calendar.HOUR);
                int minutos = C.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        View_Hora.setText(hour+":"+minute);
                    }
                },hora, minutos, false);
                timePickerDialog.show();
                break;

            case R.id.button_Elegir_Fecha:

                final Calendar c = Calendar.getInstance();
                int anyo = c.get(Calendar.YEAR);
                int mes = c.get(Calendar.MONTH);
                int dia = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        View_Fecha.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, anyo, mes, dia);
                datePickerDialog.show();
                break;

            case R.id.button_Elegir_Color:

                builder.setTitle(R.string.Titulo).setItems(R.array.color_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int posicion) {

                        switch (posicion) {
                            case 0:

                                linear_Color.setBackgroundColor(Color.BLUE);
                                break;

                            case 1:

                                linear_Color.setBackgroundColor(Color.GREEN);
                                break;

                            case 2:

                                linear_Color.setBackgroundColor(Color.RED);
                                break;
                        }
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;

        }

    }

}
