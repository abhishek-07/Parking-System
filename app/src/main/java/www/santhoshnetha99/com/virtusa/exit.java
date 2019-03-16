package www.santhoshnetha99.com.virtusa;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import www.santhoshnetha99.com.virtusa.parkingdetails.tableschema;
public class exit extends AppCompatActivity {

    Button exit;
    EditText vehicle_nu;
    private SQLiteDatabase database;
    private database databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        vehicle_nu=(EditText)findViewById(R.id.vehicle_no);
        exit=(Button)findViewById(R.id.exit_btn);
        databaseHelper=new database(exit.this);
        database=databaseHelper.getWritableDatabase();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vcn;
                vcn=vehicle_nu.getText().toString();
                String str,end,star;
                //str=getcurrectTime();

                str="19:15:22";
                //check(vcn,str);
                star=getStartTime(vcn);
                end=str;
                //int type=getVehicleType(vcn);
                Intent intent=new Intent(v.getContext(),calculate.class);
                        intent.putExtra("starttime",star);
                        intent.putExtra("endtime",end);
                 startActivity(intent);
            }
        });
    }
    public void check(String vcn,String str){



        ContentValues contentValues=new ContentValues();
        contentValues.put(tableschema.OUT_TIME,str);
        String selection= tableschema._ID + "=?";
        String[] selectionArgs={vcn};
        int rowsUpdate=database.update(tableschema.TABLE_NAME,contentValues,selection,selectionArgs);
        /*
        ContentValues cv=new ContentValues();
        cv.put(tableschema.OUT_TIME,str);
        database.update(tableschema.TABLE_NAME,cv,"_ID="+vcn,null);
*/

   // database.execSQL("UPDATE "+tableschema.TABLE_NAME+" SET outtime="+str+" WHERE _ID="+vcn);
    }

    public String getcurrectTime(){
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat mdformat=new SimpleDateFormat("HH:MM:SS");
        String strDate=mdformat.format(calendar.getTime());
        return strDate;
    }
    public String getStartTime(String vcn){
        String[] projection= {tableschema.IN_TIME};
        String selection= tableschema._ID + "=?";
        String[] selectionArgs={vcn};
        String sortOrder=null;
        Cursor cursor=database.query(tableschema.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
        if(cursor!=null && cursor.moveToNext()){
            String str="";
            String[] columns=cursor.getColumnNames();
            for(String column:columns){
                str+=cursor.getString(cursor.getColumnIndex(column));
                return str;
            }
        }
        return null;
    }
    public int getVehicleType(String vcn){
        String[] projection= {parkingdetails.tableschema.VECHILE_TYPE};
        String selection= parkingdetails.tableschema._ID + "=?";
        String[] selectionArgs={vcn};
        String sortOrder=null;
        Cursor cursor=database.query(parkingdetails.tableschema.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
        if(cursor!=null && cursor.moveToNext()){
            int str;
            String[] columns=cursor.getColumnNames();
            for(String column:columns){
                str=cursor.getInt(cursor.getColumnIndex(column));
                return str;
            }
        }
        return 0;
    }

}
