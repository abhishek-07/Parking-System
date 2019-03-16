package www.santhoshnetha99.com.virtusa;

import android.provider.BaseColumns;

public class parkingdetails {


    /* A contract class contains constants that define names for URIs, tables, and columns.  */
    public static final class tableschema implements BaseColumns {

        // Table Name
        public static final String TABLE_NAME = "checkin";

        // Columns
        public static final String _ID = BaseColumns._ID;
        public static final String IN_TIME = "intime";
        public static final String VECHILE_TYPE = "vechiletype";
        public static final String SPACE_TAKEN="spacetaken";
        public static final String OUT_TIME="outtime";

    }


}
