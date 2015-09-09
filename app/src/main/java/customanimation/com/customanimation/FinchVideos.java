package customanimation.com.customanimation;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Salil Kaul on 1/9/15.
 */
public class FinchVideos {
    public static final String SIMPLE_AUTHORITY = "com.oreilly.demo.pa.finchvideo.FinchVideo";

    public static final class SimpleVideos implements BaseColumns {
        public static final Uri CONTENT_URI = VIDEOS_URI;
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.finch.video";
        public static final String CONTENT_VIDEO_TYPE = "vnd.android.cursor.item/vnd.finch.video";
        public static final String VIDEO = "video";
        public static final Uri VIDEOS_URI = Uri.parse("content://" + SIMPLE_AUTHORITY + "/" + SimpleVideos.VIDEO);
        /**
         * Column name for the title of the video
         * <P>Type: TEXT</P>
         */
        public static final String TITLE = "title";
        /**
         * Column name for the description of the video.
         */
        public static final String DESCRIPTION = "description";
        public static final String URI = "uri";
        public static final String MEDIA_ID = "media_id";

        private SimpleVideos() {

        }

    }

    /**
     * Unique identifier for an element of media
     */


}
