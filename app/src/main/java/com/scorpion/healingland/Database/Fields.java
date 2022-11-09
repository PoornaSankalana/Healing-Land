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
        public static final String COLUMN_1 = "FirstName";
        public static final String COLUMN_2= "LastName";
        public static final String COLUMN_3 = "Email";
        public static final String COLUMN_4 = "Phone";
        public static final String COLUMN_5 = "Password";
    }

    public static class EventData implements BaseColumns{
        public static final String TABLE_NAME = "EventInfo";
        public static final String COLUMN_1 = "EventName";
        public static final String COLUMN_2= "EventDescription";
        public static final String COLUMN_3 = "Date";
        public static final String COLUMN_4 = "Time";
        public static final String COLUMN_5 = "Venue";
        public static final String COLUMN_6 = "CoordinatorName";
        public static final String COLUMN_7 = "CoordinatorNumber";
        public static final String COLUMN_8 = "ImageUrl";
    }
}
