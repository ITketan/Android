package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TimePicker timePicker;
    TimePickerDialog tp;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.ed);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tp = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            Time time = new Time(hourOfDay,minute,0);
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");
                            editText.setText(simpleDateFormat.format(time));
                        }
                    },0,0,false);
                    tp.show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

//        timePicker = findViewById(R.id.timePicker);
//        textView = findViewById(R.id.txt);
//        timePicker.setIs24HourView(false);
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                textView.setText(timePicker.getCurrentHour()+ ":" + timePicker.getCurrentMinute()  );
//            }
//        });
    }
}