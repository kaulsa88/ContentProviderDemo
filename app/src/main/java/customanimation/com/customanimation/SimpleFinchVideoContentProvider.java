package customanimation.com.customanimation;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class SimpleFinchVideoContentProvider extends ContentProvider {
    public static final String DATABASE_NAME = "simple_video.db";
    public static final int DATABASE_VERSION = 2;
    public static final String VIDEO_TABLE_NAME = "video";
    private static UriMatcher sUriMatcher;
    private final static int VIDEOS = 1;
    private final static int VIDEO_ID = 2;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(FinchVideos.SIMPLE_AUTHORITY, FinchVideos.SimpleVideos.VIDEO, VIDEOS);
        sUriMatcher.addURI(FinchVideos.SIMPLE_AUTHORITY, FinchVideos.SimpleVideos.VIDEO + "/#", VIDEO_ID);
    }

   // public DataBaseOpenHelper mOpenHelper;

    public SimpleFinchVideoContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
