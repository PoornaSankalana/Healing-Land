package com.scorpion.healingland.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HealingLandDB.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_GARDEN_TIPS);
        db.execSQL(SQL_CREATE_EVENT);
        db.execSQL(SQL_CREATE_DISEASES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_DELETE_GARDEN_TIPS);
        db.execSQL(SQL_DELETE_EVENT);
        db.execSQL(SQL_DELETE_DISEASES);
        onCreate(db);
    }

    // User table creation
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + Fields.UserData.TABLE_NAME + " (" +
            Fields.UserData.COLUMN_1 + " TEXT," +
            Fields.UserData.COLUMN_2 + " TEXT," +
            Fields.UserData.COLUMN_3 + " TEXT PRIMARY KEY," +
            Fields.UserData.COLUMN_4 + " TEXT," +
            Fields.UserData.COLUMN_5 + " TEXT)";

    // GardenTips table creation
    private static final String SQL_CREATE_GARDEN_TIPS = "CREATE TABLE " + Fields.GardenTipsData.TABLE_NAME + " (" +
            Fields.GardenTipsData.COLUMN_1 + " TEXT PRIMARY KEY," +
            Fields.GardenTipsData.COLUMN_2 + " TEXT," +
            Fields.GardenTipsData.COLUMN_3 + " TEXT," +
            Fields.GardenTipsData.COLUMN_4 + " TEXT," +
            Fields.GardenTipsData.COLUMN_5 + " TEXT," +
            Fields.GardenTipsData.COLUMN_6 + " TEXT," +
            Fields.GardenTipsData.COLUMN_7 + " TEXT," +
            Fields.GardenTipsData.COLUMN_8 + " TEXT)";

    // Event table creation
    private static final String SQL_CREATE_EVENT = "CREATE TABLE " + Fields.EventData.TABLE_NAME + " (" +
            Fields.EventData.COLUMN_1 + " TEXT PRIMARY KEY," +
            Fields.EventData.COLUMN_2 + " TEXT," +
            Fields.EventData.COLUMN_3 + " TEXT," +
            Fields.EventData.COLUMN_4 + " TEXT," +
            Fields.EventData.COLUMN_5 + " TEXT," +
            Fields.EventData.COLUMN_6 + " TEXT," +
            Fields.EventData.COLUMN_7 + " TEXT," +
            Fields.EventData.COLUMN_8 + " TEXT," +
            Fields.EventData.COLUMN_9 + " TEXT)";

    // Diseases table creation
    private static final String SQL_CREATE_DISEASES = "CREATE TABLE " + Fields.DiseasesData.TABLE_NAME + " (" +
            Fields.DiseasesData.COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Fields.DiseasesData.COLUMN_2 + " TEXT," +
            Fields.DiseasesData.COLUMN_3 + " TEXT," +
            Fields.DiseasesData.COLUMN_4 + " TEXT," +
            Fields.DiseasesData.COLUMN_5 + " TEXT)";

    // Drop user table
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Fields.UserData.TABLE_NAME;

    // Drop GardenTips table
    private static final String SQL_DELETE_GARDEN_TIPS =
            "DROP TABLE IF EXISTS " + Fields.GardenTipsData.TABLE_NAME;

    // Drop Event table
    private static final String SQL_DELETE_EVENT =
            "DROP TABLE IF EXISTS " + Fields.EventData.TABLE_NAME;

    // Drop Diseases table
    private static final String SQL_DELETE_DISEASES =
            "DROP TABLE IF EXISTS " + Fields.DiseasesData.TABLE_NAME;

    public long RegisterUser (String firstname, String lastname, String email, String phone, String password){
        // Get the database instance in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(Fields.UserData.COLUMN_1, firstname);
        contentValues.put(Fields.UserData.COLUMN_2, lastname);
        contentValues.put(Fields.UserData.COLUMN_3, email);
        contentValues.put(Fields.UserData.COLUMN_4, phone);
        contentValues.put(Fields.UserData.COLUMN_5, password);

        // insert the new row and returning
        long newRow = db.insert(Fields.UserData.TABLE_NAME, null, contentValues);

        return newRow;
    }

    public boolean userLogin (String email, String password) {
        // Get the database instance in read mode
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
//                BaseColumns._ID,
                Fields.UserData.COLUMN_3,
                Fields.UserData.COLUMN_5
        };

        // Filter results where email and password
        String selection = Fields.UserData.COLUMN_3 + " = ? AND " + Fields.UserData.COLUMN_5 + " = ?";
        String[] selectionArgs = { email, password };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                Fields.UserData.COLUMN_3 + " ASC";

        Cursor cursor = db.query(
                Fields.UserData.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        String ValidUser = null;
        while(cursor.moveToNext()) {
            ValidUser = cursor.getString(cursor.getColumnIndexOrThrow(Fields.UserData.COLUMN_3));
        }
        cursor.close();

       // return a boolean
        if(ValidUser.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    public long AddGardenTips (String plantCode, String plantName, String botanicalName, String plantType, String water, String plantingTip, String fertilizerTip, String imageUrl){
        // Get the database instance in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(Fields.GardenTipsData.COLUMN_1, plantCode);
        contentValues.put(Fields.GardenTipsData.COLUMN_2, plantName);
        contentValues.put(Fields.GardenTipsData.COLUMN_3, botanicalName);
        contentValues.put(Fields.GardenTipsData.COLUMN_4, plantType);
        contentValues.put(Fields.GardenTipsData.COLUMN_5, water);
        contentValues.put(Fields.GardenTipsData.COLUMN_6, plantingTip);
        contentValues.put(Fields.GardenTipsData.COLUMN_7, fertilizerTip);
        contentValues.put(Fields.GardenTipsData.COLUMN_8, imageUrl);

        // insert the new row and returning
        long newRow = db.insert(Fields.GardenTipsData.TABLE_NAME, null, contentValues);

        return newRow;
    }

    public long AddEvent (String eventId, String eventName, String eventDescription, String date, String time, String venue, String cname, String cNumber, String imgUrl){
        // Get the database instance in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(Fields.EventData.COLUMN_1, eventId);
        contentValues.put(Fields.EventData.COLUMN_2, eventName);
        contentValues.put(Fields.EventData.COLUMN_3, eventDescription);
        contentValues.put(Fields.EventData.COLUMN_4, date);
        contentValues.put(Fields.EventData.COLUMN_5, time);
        contentValues.put(Fields.EventData.COLUMN_6, venue);
        contentValues.put(Fields.EventData.COLUMN_7, cname);
        contentValues.put(Fields.EventData.COLUMN_8, cNumber);
        contentValues.put(Fields.EventData.COLUMN_9, imgUrl);

        // insert the new row and returning
        long newRow = db.insert(Fields.EventData.TABLE_NAME, null, contentValues);

        return newRow;
    }

    public long AddDisease (String diseaseName, String diseaseDesc, String cause, String prevention){
        // Get the database instance in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(Fields.DiseasesData.COLUMN_2, diseaseName);
        contentValues.put(Fields.DiseasesData.COLUMN_3, diseaseDesc);
        contentValues.put(Fields.DiseasesData.COLUMN_4, cause);
        contentValues.put(Fields.DiseasesData.COLUMN_5, prevention);

        // insert the new row and returning
        long newRow = db.insert(Fields.DiseasesData.TABLE_NAME, null, contentValues);

        return newRow;
    }


    public Cursor getdata(String user) {

        SQLiteDatabase MyDB = this.getWritableDatabase();


        Cursor cursor = MyDB.rawQuery("select * from users where username=?", new String[]{user});

        return cursor;

    }


    public Boolean EditGardenTips(String plantCode, String plantName, String botanicalName, String plantType, String water, String plantingTip, String fertilizerTip, String imageUrl) {
        SQLiteDatabase db =getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(Fields.GardenTipsData.COLUMN_2, plantName);
        values.put(Fields.GardenTipsData.COLUMN_3, botanicalName);
        values.put(Fields.GardenTipsData.COLUMN_4, plantType);
        values.put(Fields.GardenTipsData.COLUMN_5, water);
        values.put(Fields.GardenTipsData.COLUMN_6, plantingTip);
        values.put(Fields.GardenTipsData.COLUMN_7, fertilizerTip);
        values.put(Fields.GardenTipsData.COLUMN_8, imageUrl);

        // Which row to update, based on the title
        String selection = Fields.GardenTipsData.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = {plantCode};

        int count = db.update(
                Fields.GardenTipsData.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if(count >=1){
            return true;
        }
        else {
            return false;
        }
    }

    public void  deleteGardenTips (String plantCode){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = Fields.GardenTipsData.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { plantCode };
        // Issue SQL statement.
        int deletedRows = db.delete(Fields.GardenTipsData.TABLE_NAME, selection, selectionArgs);
    }

    public List GetYourTips (){

        String plantCode = "P1001";
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Fields.GardenTipsData.COLUMN_1,
                Fields.GardenTipsData.COLUMN_2,
                Fields.GardenTipsData.COLUMN_3,
                Fields.GardenTipsData.COLUMN_4,
                Fields.GardenTipsData.COLUMN_5,
                Fields.GardenTipsData.COLUMN_6,
                Fields.GardenTipsData.COLUMN_7,
                Fields.GardenTipsData.COLUMN_8,

        };

// Filter results WHERE "title" = 'My Title'
        String selection = Fields.GardenTipsData.COLUMN_1 + " = ?";
        String[] selectionArgs = { plantCode };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                Fields.GardenTipsData.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                Fields.GardenTipsData.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List plantCodes = new ArrayList<>();
        while(cursor.moveToNext()) {
            long plantCod = cursor.getLong(cursor.getColumnIndexOrThrow(Fields.GardenTipsData.COLUMN_1));
            plantCodes.add(plantCod);
        }
        cursor.close();
        return plantCodes;
    }
}