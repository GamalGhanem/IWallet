package com.example.gamal.iwallet.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class WalletContract  {

    public static final String CONTENT_AUTHORITY = "com.example.gamal.iwallet";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_WALLET = "wallet";

    public static abstract class WalletEntry implements BaseColumns {

        // uri path of the wallet table
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_WALLET);

        //table name constant
        public  static final String USERS_TABLE_NAME = "users";

        public static final String USER_ID = BaseColumns._ID;
        public static final String USERS_COLUMN_NAME = "name";
        public static final String USERS_COLUMN_Email = "email";
        public static final String USERS_COLUMN_PASSWORD = "password";

    }
}
