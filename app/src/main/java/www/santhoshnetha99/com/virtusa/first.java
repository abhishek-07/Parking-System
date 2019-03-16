package www.santhoshnetha99.com.virtusa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class first extends AppCompatActivity {

    TextView entry,exit,Report,amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        entry=(TextView)findViewById(R.id.entry_page);
        exit=(TextView)findViewById(R.id.exit_page);
        Report=(TextView)findViewById(R.id.available_page);
        amount=(TextView)findViewById(R.id.amount_page);
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),exit.class);
                startActivity(intent);
            }
        });
        amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),amount.class);
                startActivity(intent);
            }
        });
        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),report.class);
                startActivity(intent);
            }
        });
    }
}
