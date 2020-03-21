package com.example.dietaryz;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.app.DatePickerDialog;
import android.widget.EditText;
import android.widget.DatePicker;
import java.util.Calendar;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.dietaryz.util.Constants;


public class Food_Entry extends AppCompatActivity {

    private EditText txtfoodname, txtfoodtype,txtmeal,txtnote,txtname,editdate;
    private Button btnadd, btnback;
    private DatePickerDialog picker;
    private TextClock clock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_entry);

        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        picker = new DatePickerDialog(Food_Entry.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        editdate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock.setText("Time: "+clock.getText());
            }
        });


        initialize();
        actionInitializer();
    }

    private void initialize(){
        txtfoodname = (EditText) findViewById(R.id.txtfoodname);
        txtfoodtype = (EditText) findViewById(R.id.txtfoodtype);
        //txtdate = (EditText) findViewById(R.id.txtdate);
        editdate=(EditText) findViewById(R.id.editdate);
        editdate.setInputType(InputType.TYPE_NULL);
        clock = (TextClock) findViewById(R.id.tclock);
        txtmeal = (EditText) findViewById(R.id.txtmeal);
        txtnote = (EditText) findViewById(R.id.txtnote);
        txtname  = (EditText) findViewById(R.id.txtname);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnback = (Button) findViewById(R.id.btnback);

    }

    private void actionInitializer(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    Intent state = new Intent(getBaseContext(), Food_Entry.class);
                    state.putExtra(Constants.foodname, txtfoodname.getText().toString().trim());
                    state.putExtra(Constants.foodtype, txtfoodtype.getText().toString().trim());
                    // state.putExtra( Constants.DATE, txtdate.getText().toString().trim() );
                    state.putExtra(Constants.meal, txtmeal.getText().toString().trim());
                    state.putExtra(Constants.note, txtnote.getText().toString().trim());
                    state.putExtra(Constants.name, txtname.getText().toString().trim());


                    setResult(RESULT_OK, state);
                    finish();
                }






            }

        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        }


    private boolean isValid(){

        if( txtfoodname.getText().toString().trim().isEmpty() || txtfoodname.getText() == null ){
            Snackbar.make( txtfoodname, "Please enter name", Snackbar.LENGTH_LONG).show();
            txtfoodname.requestFocus();
            return false;
        }

        if( txtfoodtype.getText().toString().trim().isEmpty() || txtfoodtype.getText() == null ){
            Snackbar.make( txtfoodtype, "Please enter phone", Snackbar.LENGTH_LONG).show();
            txtfoodtype.requestFocus();
            return false;
        }

        /*if( txtdate.getText().toString().trim().isEmpty() || txtdate.getText() == null ){
            Snackbar.make( txtdate, "Please enter email", Snackbar.LENGTH_LONG).show();
            txtdate.requestFocus();
            return false;
        }*/

        if( txtmeal.getText().toString().trim().isEmpty() || txtmeal.getText() == null ){
            Snackbar.make( txtmeal, "Please enter address", Snackbar.LENGTH_LONG).show();
            txtmeal.requestFocus();
            return false;
        }
        if( txtnote.getText().toString().trim().isEmpty() || txtnote.getText() == null ){
            Snackbar.make( txtnote, "Please enter address", Snackbar.LENGTH_LONG).show();
            txtnote.requestFocus();
            return false;
        }
        if( txtname.getText().toString().trim().isEmpty() || txtname.getText() == null ){
            Snackbar.make( txtname, "Please enter address", Snackbar.LENGTH_LONG).show();
            txtname.requestFocus();
            return false;
        }


        return true;
    }

}


