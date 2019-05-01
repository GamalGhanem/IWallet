package com.example.gamal.iwallet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gamal.iwallet.data.WalletContract;

public class Utils {

    public static Cursor findUser(SQLiteDatabase db, String email, String password) {
        //desired attributes
        String[] projection = {
                WalletContract.WalletEntry.USERS_COLUMN_NAME,
                WalletContract.WalletEntry.USERS_COLUMN_Email,
                WalletContract.WalletEntry.USERS_COLUMN_PASSWORD
        };

        //selection condition
        String selection = WalletContract.WalletEntry.USERS_COLUMN_Email + "=? AND "
                + WalletContract.WalletEntry.USERS_COLUMN_PASSWORD + "=?";

        //selection args: value for every ? in the selection
        String[] selectionArgs = new String[2];
        selectionArgs[0] = email;
        selectionArgs[1] = password;

        Cursor cursor = db.query(WalletContract.WalletEntry.USERS_TABLE_NAME,
                projection, selection, selectionArgs, null, null, null);

        return cursor;
    }
}
