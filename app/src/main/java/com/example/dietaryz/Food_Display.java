package com.example.dietaryz;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dietaryz.util.Constants;


public class Food_Display extends AppCompatActivity {

    private TextView txtgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_display);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //ActionBar ab = getSupportActionBar();
        //ab.setDisplayHomeAsUpEnabled( true );

        txtgroup = (TextView) findViewById(R.id.txtfoodtype);

        Bundle bundle = getIntent( ).getExtras( );
        if( bundle!= null && bundle.getString(Constants.foodname) != null ){
            ((TextView)findViewById(R.id.txtfoodname)).setText( bundle.getString(Constants.foodname) );
            txtgroup.setText( bundle.getString(Constants.foodtype) );
           // ((TextView)findViewById(R.id.txtdate)).setText( bundle.getString(Constants.DATE) );
            ((TextView)findViewById(R.id.txtmeal)).setText( bundle.getString(Constants.meal) );
            ((TextView)findViewById(R.id.txtnote)).setText( bundle.getString(Constants.note) );
            ((TextView)findViewById(R.id.txtname)).setText( bundle.getString(Constants.name) );

        }
    }

}
