package com.example.clubolympus.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.clubolympus.data.ClubOlympusContract.*;


public class OlympusContentProvider extends ContentProvider {

    public OlympusDatabaseHendler dbOpenHelper;

    public static final int MEMBERS = 111;
    public static final int MEMBER_ID = 222;

    public static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(ClubOlympusContract.AUTHORITY,
                ClubOlympusContract.PATH_MEMBERS, MEMBERS);
        uriMatcher.addURI(ClubOlympusContract.AUTHORITY,
                ClubOlympusContract.PATH_MEMBERS + "/#", MEMBER_ID);
    }

    @Override
    public boolean onCreate() {
        dbOpenHelper = new OlympusDatabaseHendler(getContext());
        return true;
    }

    @Override
    public Cursor query( Uri uri,  String[] projection, String selection,
                         String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor;
        int match = uriMatcher.match(uri);
        switch (match) {
            case MEMBERS:
                cursor = db.query(MemberEntry.TABLE_NAME, projection, selection,
                        selectionArgs,null, null, sortOrder);
                break;
            case MEMBER_ID:
                selection = MemberEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(MemberEntry.TABLE_NAME, projection, selection,
                        selectionArgs,null, null, sortOrder);

                break;
            default:
                throw new IllegalArgumentException("Can't query incorrect URI "+uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        int match = uriMatcher.match(uri);
        switch (match) {
            case MEMBERS:
                return MemberEntry.CONTENT_MULTIPLE_ITEMS;
            case MEMBER_ID:
                return MemberEntry.CONTENT_SINGLE_ITEM;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //Data validation
        String firstName = values.getAsString(MemberEntry.KEY_FIRST_NAME);
        if (firstName==null){
            throw new IllegalArgumentException("You have to input first name");
        }
        String lastName = values.getAsString(MemberEntry.KEY_LAST_NAME);
        if (lastName==null){
            throw new IllegalArgumentException("You have to input last name");
        }
        Integer gender = values.getAsInteger(MemberEntry.KEY_GENDER);
        if (gender==null||
                !(gender==MemberEntry.GENDER_UNKNOWN||
                gender==MemberEntry.GENDER_FEMALE||
                gender==MemberEntry.GENDER_MALE)){
            throw new IllegalArgumentException("You have to input correct gender");
        }
        String sport = values.getAsString(MemberEntry.KEY_SPORT);
        if (sport==null){
            throw new IllegalArgumentException("You have to input sport");
        }
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        int math = uriMatcher.match(uri);

        switch (math){
            case MEMBERS:
                long id = db.insert(MemberEntry.TABLE_NAME, null, values);
                if (id==-1){
                    Log.e("insertMethod", "Insertion of data in table faild for "+uri);
                    return null;
                }

                getContext().getContentResolver().notifyChange(uri,null);

                return ContentUris.withAppendedId(uri,id);
            default:
                throw new IllegalArgumentException("Insertion of data in table faild for "+uri);
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int match = uriMatcher.match(uri);
        int rowsDeleted;
        switch (match) {
            case MEMBERS:
                rowsDeleted = db.delete(MemberEntry.TABLE_NAME,selection,selectionArgs);
                break;
            case MEMBER_ID:
                selection = MemberEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted = db.delete(MemberEntry.TABLE_NAME,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Can't delete this URI "+uri);
        }
        if (rowsDeleted !=0){
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return rowsDeleted;
    }

    @Override
    public int update( Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        //Data validation
        if(values.containsKey(MemberEntry.KEY_FIRST_NAME)){
            String firstName = values.getAsString(MemberEntry.KEY_FIRST_NAME);
            if (firstName==null){
                throw new IllegalArgumentException("You have to input first name");

            }
        }
        if (values.containsKey(MemberEntry.KEY_LAST_NAME)){
            String lastName = values.getAsString(MemberEntry.KEY_LAST_NAME);
            if (lastName==null){
                throw new IllegalArgumentException("You have to input last name");

            }
        }

        if(values.containsKey(MemberEntry.KEY_GENDER)){
            Integer gender = values.getAsInteger(MemberEntry.KEY_GENDER);
            if (gender==null||
                    !(gender==MemberEntry.GENDER_UNKNOWN||
                    gender==MemberEntry.GENDER_FEMALE||
                    gender==MemberEntry.GENDER_MALE)){
                throw new IllegalArgumentException("You have to input correct gender");

            }
        }

        if(values.containsKey(MemberEntry.KEY_SPORT)){
            String sport = values.getAsString(MemberEntry.KEY_SPORT);
            if (sport==null){
                throw new IllegalArgumentException("You have to input sport");
            }
        }

        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int match = uriMatcher.match(uri);
        int rowsUpdated;
        switch (match) {
            case MEMBERS:
                rowsUpdated =  db.update(MemberEntry.TABLE_NAME,values,selection,selectionArgs);
                break;

            case MEMBER_ID:
                selection = MemberEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};

                rowsUpdated =  db.update(MemberEntry.TABLE_NAME,values,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Can't update this URI "+uri);
        }
        if(rowsUpdated !=0){
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return rowsUpdated;
    }

    //URI - Unified Resource Identifier
    //content://com.example.clubolympus/members
    //URL - Unified Resource Locator
    //http://google.com
    //content://com.example.clubolympus/members/34
    //content://  -scheme
    // com.example.clubolympus - content authority
    // members - type of data (TABLE_NAME)
    // 34 - row id

    //content://com.android.contacts/contacts
    //content://com.android.calendar/events
    //content://user_dictionary/words


}
