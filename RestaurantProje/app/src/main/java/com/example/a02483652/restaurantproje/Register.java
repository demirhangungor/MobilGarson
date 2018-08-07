package com.example.a02483652.restaurantproje;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class Register extends AppCompatActivity {

    Context context = this;
    private EditText Rname, Rpassword, Rmail;
    private String kullanıcıAdı, passwordGir, mailRegister;
    String kayıtOlundu;
    RegisterSQL loginRegisterSQL;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);

        loginRegisterSQL = new RegisterSQL(getApplicationContext());
        loginRegisterSQL = loginRegisterSQL.open();

        Rname = (EditText) findViewById(R.id.name);
        Rpassword = (EditText) findViewById(R.id.password);
        Rmail = (EditText) findViewById(R.id.mail);
    }
    public void OK(View view) {

        kullanıcıAdı = Rname.getText().toString();
        passwordGir = Rpassword.getText().toString();
        mailRegister = Rmail.getText().toString();

        if (kullanıcıAdı.equals("") || (passwordGir.equals("") || (mailRegister.equals("")))) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("ALERT");
            alertDialog.setMessage("All Fields Must Be Filled!");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            alertDialog.show();

        } else {

            kayıtOlundu = loginRegisterSQL.insertEntry(kullanıcıAdı, passwordGir);

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Succesful");
            alertDialog.setMessage("Sign In Now " + kayıtOlundu);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            alertDialog.show();
            finish();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginRegisterSQL.close();
    }
}




