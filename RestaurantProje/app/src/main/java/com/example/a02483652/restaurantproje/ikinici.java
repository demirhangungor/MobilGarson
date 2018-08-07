package com.example.a02483652.restaurantproje;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class ikinici extends Activity {

    public String str;
    RadioGroup radioGroup;
    RadioButton selectRadioButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikinci);

        TextView text = (TextView) findViewById(R.id.editText3);
        Intent intent = getIntent();
        String str = getIntent().getStringExtra("MESSAGE_KEY");
        text.setText(str);

    }

    public void dashBoardClick(View v) {

        Intent intent = new Intent(this,Dashboard.class);
        startActivity(intent);
    }
}

