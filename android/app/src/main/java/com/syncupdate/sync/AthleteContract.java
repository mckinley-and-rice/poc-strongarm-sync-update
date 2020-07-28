package com.syncupdate.sync;

import android.net.Uri;

public class AthleteContract {
    //ContentProvider information
    public static final String CONTENT_AUTHORITY = "com.syncupdate";
    static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    static final String PATH_ATHLETES = "getUpdatedAthletes";

    // Database information
    static final String DB_NAME = "athletes_db";
    static final int DB_VERSION = 1;

    public static abstract class Athletes {
        public static final String ID = "id";
        public static final String EXTERNAL_ID = "external_id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String SETTINGS_ID = "settings_id";
        public static final String SETTINGS = "settings";
        public static final String WAREHOUSE_ID = "warehouse_id";
        public static final String GROUP_ID = "group_id";



        // ContentProvider information for articles
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ATHLETES).build();
        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_URI + "/" + PATH_ATHLETES;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_URI + "/" + PATH_ATHLETES;
    }
}
