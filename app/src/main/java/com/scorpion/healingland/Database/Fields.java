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

    public static class GardenTipsData implements BaseColumns{
        public static final String TABLE_NAME = "GardenTipInfo";
        public static final String COLUMN_1 = "plant_code";
        public static final String COLUMN_2 = "plant_name";
        public static final String COLUMN_3= "botanical_name";
        public static final String COLUMN_4 = "plant_type";
        public static final String COLUMN_5 = "water";
        public static final String COLUMN_6 = "planting_tip";
        public static final String COLUMN_7 = "fertilizing_tip";
        public static final String COLUMN_8 = "image_url";
    }

    public static class EventData implements BaseColumns{
        public static final String TABLE_NAME = "EventInfo";
        public static final String COLUMN_1 = "eventId";
        public static final String COLUMN_2 = "eventName";
        public static final String COLUMN_3= "eventDescription";
        public static final String COLUMN_4 = "date";
        public static final String COLUMN_5 = "time";
        public static final String COLUMN_6 = "venue";
        public static final String COLUMN_7 = "cname";
        public static final String COLUMN_8 = "cNumber";
        public static final String COLUMN_9 = "imgUrl";

    }

    public static class DiseasesData implements BaseColumns {
        public static final String TABLE_NAME = "DiseaseInfo";
        public static final String COLUMN_1 = "diseaseId";
        public static final String COLUMN_2 = "diseaseName";
        public static final String COLUMN_3= "diseaseDescription";
        public static final String COLUMN_4 = "diseaseCause";
        public static final String COLUMN_5 = "howToPrevent";
    }
}
