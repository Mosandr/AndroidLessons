package com.example.clubolympus.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.clubolympus.data.ClubOlympusContract.MemberEntry;

public class OlympusDatabaseHendler extends SQLiteOpenHelper {


    public OlympusDatabaseHendler(Context context) {
        super(context, ClubOlympusContract.DATABASE_NAME, null,
                ClubOlympusContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEMBERS_TABLE = "CREATE TABLE "+ MemberEntry.TABLE_NAME + "("
                +MemberEntry._ID + " INTEGER PRIMARY KEY,"
                +MemberEntry.KEY_FIRST_NAME + " TEXT,"
                +MemberEntry.KEY_LAST_NAME + " TEXT,"
                +MemberEntry.KEY_GENDER + " INTEGER NOT NULL,"
                +MemberEntry.KEY_SPORT + " TEXT" + ")";
        db.execSQL(CREATE_MEMBERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MemberEntry.TABLE_NAME);
        onCreate(db);
    }
}
