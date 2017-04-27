package com.example.jerald.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class secularActivity extends AppCompatActivity {

    ListView lv;
    TextView tvSecular;
    ArrayAdapter aa;
    ArrayList<Holidays> holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secular);

        tvSecular = (TextView) findViewById(R.id.textView);

        Intent i = getIntent();
        String year = i.getStringExtra("holiday");
        int pos = i.getIntExtra("position",0);
        tvSecular.setText(year);

        if(pos == 0){
            lv = (ListView) findViewById(R.id.lvHoli);
            holidays = new ArrayList<Holidays>();
            holidays.add(new Holidays("New Year's Day", "1 Jan 2017"));
            holidays.add(new Holidays("Labour Day", "1 May 2017"));
        } else {
            lv = (ListView) findViewById(R.id.lvHoli);
            holidays = new ArrayList<Holidays>();
            holidays.add(new Holidays("Chinese New Year", "28-19 Jan 2017"));
            holidays.add(new Holidays("Good Friday", "14 April 2017"));
        }





        aa = new HolidaysAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selected = holidays.get(position);

                Toast.makeText(secularActivity.this, selected.getName()
                                + " Date: " +selected.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}
