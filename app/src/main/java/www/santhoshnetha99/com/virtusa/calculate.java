package www.santhoshnetha99.com.virtusa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class calculate extends AppCompatActivity {

    public Date date1,date2;
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

      Intent intent=getIntent();
        String start=intent.getStringExtra("starttime");
        String end=intent.getStringExtra("endtime");
        int type=intent.getIntExtra("type",0);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH::MM:SS");
        try {
            date1=simpleDateFormat.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            date2=simpleDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long difference =date2.getTime()-date1.getTime();
        int days=(int)(difference/(1000*60*60*24));
        int hours=(int)((difference/(1000*60*60*24*days))/(1000*60*60));
        int min=(int)(difference-(1000*60*60*24*days)-(1000*60*60*hours))/(1000*60);
        hours=(hours<0?-hours:hours);
        txt1=(TextView)findViewById(R.id.strt_time);
        txt2=(TextView)findViewById(R.id.end_time);
        txt3=(TextView)findViewById(R.id.amu);
        txt1.setText(start);
        txt2.setText(end);
        txt3.setText(hours*type);

    }
}
