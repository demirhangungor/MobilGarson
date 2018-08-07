package com.example.a02483652.restaurantproje;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private EditText editText2, editText;
    public String kullanıcıAdı, passwordGir;
    String storedPassword;
    Context context = this;

    RegisterSQL loginRegisterSQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText2 = (EditText) findViewById(R.id.editText2);
        editText = (EditText) findViewById(R.id.editText);

        loginRegisterSQL = new RegisterSQL(getApplicationContext());
        loginRegisterSQL = loginRegisterSQL.open();
    }

    public void girisClick(View view) {
        try {

            kullanıcıAdı = editText2.getText().toString();
            passwordGir = editText.getText().toString();

            /** if ( passwordGir.equals("")) {


             AlertDialog alertDialog = new AlertDialog.Builder(this).create();
             alertDialog.setTitle("ALERT");
             alertDialog.setMessage("Fill All Fields ");
             alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent(MainActivity.this, ikinici.class);
            startActivity(intent);
            }
            });
             alertDialog.show();


             }
             else if (!kullanıcıAdı.equals("")) {     */

            storedPassword = loginRegisterSQL.getSinlgeEntry(passwordGir);

            if (passwordGir.equals(storedPassword)) {
                // Toast.makeText(ikinici.this,"Congrats: Login Succesful",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, ikinici.class);
                intent.putExtra("MESSAGE_KEY",kullanıcıAdı);
                startActivity(intent);

            } else {

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("ALERT");
                alertDialog.setMessage("Incorrect Username or Password!");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        } catch (Exception e) {
            Log.e("Error", "error login");
        }
    }

    public void signUp(View view) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginRegisterSQL.close();
    }

}


