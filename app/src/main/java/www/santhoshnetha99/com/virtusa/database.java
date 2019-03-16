package www.santhoshnetha99.com.virtusa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import www.santhoshnetha99.com.virtusa.parkingdetails.tableschema;

public class database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "parkingdetails.db";
    private static final int DATABASE_VERSION = 1;

   /* private final String SQL_CREATE_TABLE
            = "CREATE TABLE " + tableschema.TABLE_NAME
            + " (" + tableschema._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + tableschema.IN_TIME + " TEXT NOT NULL, "
            + tableschema.VECHILE_TYPE + " INTEGER NOT NULL, "
            + tableschema.OUT_TIME+ " TEXT, "
            + tableschema.SPACE_TAKEN+" INTEGER NOT NULL);";
*/
    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE checkin"+"(id INTEGER PRIMARY KEY AUTOINCREMENT,vehicleno VARCHAR2(20),intime VARCHAR2(20),vehicletype NUMBER,outtime VARCHAR2(20),spacetaken NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Ideally we wouldn't want to delete all of our entries!
        db.execSQL("DROP TABLE IF EXISTS " + tableschema.TABLE_NAME);
        onCreate(db);	// Call to create a new db with upgraded schema and version
    }
}
