package www.santhoshnetha99.com.virtusa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
    }
}

class CustomAdapter extends BaseAdapter {
    private Context mContext;
    database controld;
    SQLiteDatabase db;
    private ArrayList<String> _ID = new ArrayList<String>();
    private ArrayList<String> IN_TIME = new ArrayList<String>();
    private ArrayList<String> VEHICLE_TYPE = new ArrayList<String>();
    private ArrayList<String> SPACE_TAKEN = new ArrayList<String>();
    public CustomAdapter(Context  context,ArrayList<String> Id,ArrayList<String> intime, ArrayList<String> Vtype,ArrayList<String> spaces
    )
    {
        this.mContext = context;
        this._ID = Id;
        this.IN_TIME = intime;
        this.VEHICLE_TYPE = Vtype;
        this.SPACE_TAKEN=spaces;
    }
    @Override
    public int getCount() {
        return _ID.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final    viewHolder holder;
        database db =new database(mContext);
        LayoutInflater layoutInflater;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_display, null);
            holder = new viewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.tvid);
            holder.name = (TextView) convertView.findViewById(R.id.tvname);
            holder.mail = (TextView) convertView.findViewById(R.id.tvmailid);
            holder.age = (TextView) convertView.findViewById(R.id.tvage);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.id.setText(_ID.get(position));
        holder.name.setText(IN_TIME.get(position));
        holder.mail.setText(VEHICLE_TYPE.get(position));
        holder.age.setText(SPACE_TAKEN.get(position));
        return convertView;
    }
    public class viewHolder {
        TextView id;
        TextView name;
        TextView mail;
        TextView age;
    }
}
