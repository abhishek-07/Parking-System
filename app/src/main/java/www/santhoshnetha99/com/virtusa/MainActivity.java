package www.santhoshnetha99.com.virtusa;
import www.santhoshnetha99.com.virtusa.parkingdetails.tableschema;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public EditText carno;
    public EditText intime;
    public EditText vechiletype;

    Button bt1;
    private SQLiteDatabase database;
    private database databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carno=(EditText)findViewById(R.id.carno);
        vechiletype=(EditText)findViewById(R.id.vechiletype);

        bt1=(Button)findViewById(R.id.bt1);
        databaseHelper = new database(MainActivity.this);
        database = databaseHelper.getWritableDatabase();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int spacetaken;
                String carno1 	= carno.getText().toString();
                int vechiletype1=Integer.parseInt(vechiletype.getText().toString());
                if (vechiletype1==4)
                    spacetaken=1;
                else
                    spacetaken=4;
                String str=getcurrectTime();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("vehicleno","abcd");
                contentvalues.put("intime", "santhosh");
                contentvalues.put("vehicletype",4);
                contentvalues.put("outtime","123");
                contentvalues.put("spacetaken",5);

                long rowId = database.insert("checkin",null, contentvalues);

                Log.v("check", "data acquired");
                Toast.makeText(MainActivity.this, "Data Acquired"+rowId,Toast.LENGTH_SHORT).show();


            }
        });




    }

    public String getcurrectTime(){
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat mdformat=new SimpleDateFormat("HH:MM:SS");
        String strDate=mdformat.format(calendar.getTime());
        return strDate;
    }
}
