package com.scorpion.healingland.Database;

import android.provider.BaseColumns;

public final class Fields {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Fields(){}

    /*
    * This inner class defines the table columns
    */
    public static class UserData implements BaseColumns{
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1 = "firstname";
        public static final String COLUMN_2 = "lastname";
        public static final String COLUMN_3 = "email";
        public static final String COLUMN_4 = "phone";
        public static final String COLUMN_5 = "password";
    }
}
