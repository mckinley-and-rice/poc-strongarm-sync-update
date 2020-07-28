package com.syncupdate;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AthleteProvider extends ContentProvider {
    private static final int QUERY1 = 1;
    private static final int QUERY2 = 2;

//    SQLiteDatabase db;

    private static final UriMatcher uriMatcher;
    static {
        // Add all our query types to our UriMatcher
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AthleteContract.CONTENT_AUTHORITY, AthleteContract.PATH_ATHLETES, QUERY1);
        uriMatcher.addURI(AthleteContract.CONTENT_AUTHORITY, AthleteContract.PATH_ATHLETES + "/#", QUERY2);
    }

    @Override
    public boolean onCreate() {
//        this.db = DatabaseClient.getInstance(getContext()).getDB();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Cursor c;
        switch (uriMatcher.match(uri)) {
            // Query for multiple article results
            case QUERY1:
//                c = db.query(ArticleContract.Articles.NAME,
//                        projection,
//                        selection,
//                        selectionArgs,
//                        null,
//                        null,
//                        sortOrder);
                break;

            // Query for single article result
            case QUERY2:
                long _id = ContentUris.parseId(uri);
//                c = db.query(ArticleContract.Articles.NAME,
//                        projection,
//                        ArticleContract.Articles.COL_ID + "=?",
//                        new String[] { String.valueOf(_id) },
//                        null,
//                        null,
//                        sortOrder);
                break;
            default: throw new IllegalArgumentException("Invalid URI!");
        }

        assert getContext() != null;
//        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case QUERY1:
                return ArticleContract.Articles.CONTENT_TYPE;
            case QUERY2:
                return ArticleContract.Articles.CONTENT_ITEM_TYPE;
            default: throw new IllegalArgumentException("Invalid URI!");
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
            Uri returnUri;
            long _id;

            switch (uriMatcher.match(uri)) {
                case QUERY1:
//                    _id = db.insert(ArticleContract.Articles.NAME, null, values);
//                    returnUri = ContentUris.withAppendedId(AthleteContract.Athletes.CONTENT_URI, _id);
                    break;
                default: throw new IllegalArgumentException("Invalid URI!");
            }

            // Notify any observers to update the UI
            assert getContext() != null;
            getContext().getContentResolver().notifyChange(uri, null);
            return null;
//            return returnUri;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int rows;
        switch (uriMatcher.match(uri)) {
            case QUERY1:
                rows = db.delete(AthleteContract.Athletes.FIRST_NAME, selection, selectionArgs);
                break;
            default: throw new IllegalArgumentException("Invalid URI!");
        }

        // Notify any observers to update the UI
        if (rows != 0) {
            assert getContext() != null;
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rows;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int rows;
        switch (uriMatcher.match(uri)) {
            case QUERY1:
                rows = db.update(AthleteContract.Athletes.FIRST_NAME, values, selection, selectionArgs);
                break;
            default: throw new IllegalArgumentException("Invalid URI!");
        }

        // Notify any observers to update the UI
        if (rows != 0) {
            assert getContext() != null;
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rows;
    }
}
