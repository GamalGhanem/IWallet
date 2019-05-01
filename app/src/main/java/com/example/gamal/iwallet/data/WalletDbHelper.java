package com.example.gamal.iwallet.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WalletDbHelper extends SQLiteOpenHelper {

    /** Name of the database file */
    private static final String DATABASE_NAME = "wallet_organiser.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public WalletDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERS_TABLE = "CREATE TABLE " + WalletContract.WalletEntry.USERS_TABLE_NAME + "("
                + WalletContract.WalletEntry.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + WalletContract.WalletEntry.USERS_COLUMN_NAME + " TEXT NOT NULL, "
                + WalletContract.WalletEntry.USERS_COLUMN_Email + " TEXT NOT NULL, "
                + WalletContract.WalletEntry.USERS_COLUMN_PASSWORD + " TEXT NOT NULL );";

        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
