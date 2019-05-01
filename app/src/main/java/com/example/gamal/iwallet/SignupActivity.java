package com.example.gamal.iwallet;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamal.iwallet.data.WalletContract;
import com.example.gamal.iwallet.data.WalletDbHelper;

public class SignupActivity extends AppCompatActivity {

    private WalletDbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Button signupBtn = (Button)findViewById(R.id.btn_signup);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        TextView linkLogin = (TextView)findViewById(R.id.link_login);
        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //switch to sign-up activity
                Intent newIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(newIntent);
            }
        });

        dbHelper = new WalletDbHelper(this);
    }

    public void signup() {
        EditText inputName = (EditText)findViewById(R.id.input_name);
        EditText inputEmail = (EditText)findViewById(R.id.input_email);
        EditText inputPassword = (EditText)findViewById(R.id.input_password);
        String name = String.valueOf(inputName.getText());
        String email = String.valueOf(inputEmail.getText());
        String password = String.valueOf(inputPassword.getText());
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WalletContract.WalletEntry.USERS_COLUMN_NAME, name);
        values.put(WalletContract.WalletEntry.USERS_COLUMN_Email, email);
        values.put(WalletContract.WalletEntry.USERS_COLUMN_PASSWORD, password);

        Cursor cursor = Utils.findUser(db, email, password);
        if(cursor != null && cursor.getCount() > 0) {
            inputEmail.setText("");
            inputPassword.setText("");
            Toast.makeText(this, "This Email is Already Registered !!!", Toast.LENGTH_SHORT).show();
        }
        else {
            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(WalletContract.WalletEntry.USERS_TABLE_NAME, null, values);
        }

    }
}
