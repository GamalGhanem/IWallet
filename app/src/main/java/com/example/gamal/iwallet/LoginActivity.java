package com.example.gamal.iwallet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamal.iwallet.data.WalletContract;
import com.example.gamal.iwallet.data.WalletDbHelper;

public class LoginActivity extends AppCompatActivity {

    private WalletDbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        dbHelper = new WalletDbHelper(this);

        Button loginBtn = (Button)findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputEmail = (EditText)findViewById(R.id.input_email);
                EditText inputPassword = (EditText)findViewById(R.id.input_password);
                String email = String.valueOf(inputEmail.getText());
                String password = String.valueOf(inputPassword.getText());
                boolean isReg = login(email, password);
                if (isReg) {
                    Intent newIntent = new Intent(LoginActivity.this, Profile.class);
                    startActivity(newIntent);
                }
                else {
                    inputEmail.setText("");
                    inputPassword.setText("");
                    Toast.makeText(LoginActivity.this, " Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView linkSignup = (TextView)findViewById(R.id.link_signup);
        linkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //switch to sign-up activity
                Intent newIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(newIntent);
            }
        });




    }

    public boolean login(String email, String password) {


        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = Utils.findUser(db, email, password);

        if (cursor != null && cursor.getCount() > 0) {
            return true;
        }

        return false;

    }


}
