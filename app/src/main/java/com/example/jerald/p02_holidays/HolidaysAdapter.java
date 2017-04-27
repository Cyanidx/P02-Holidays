package com.example.jerald.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017292 on 27/4/2017.
 */

public class HolidaysAdapter extends ArrayAdapter<Holidays> {
    private ArrayList<Holidays> holidays;
    private Context context;
    private TextView tvHolidayName;
    private ImageView ivHoliday;
    private TextView tvDate;

    public HolidaysAdapter(Context context, int resource, ArrayList<Holidays> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHolidayName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView)rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivImage);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holidays currentHoliday = holidays.get(position);
        // Set the TextView to show the food

        tvHolidayName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        // Set the image to star or nostar accordingly
        if (currentHoliday.getName() == "New Year's Day") {
            ivHoliday.setImageResource(R.drawable.newyear);
        } else if(currentHoliday.getName() == "Labour Day"){
            ivHoliday.setImageResource(R.drawable.labourday);
        } else if (currentHoliday.getName() == "Chinese New Year"){
            ivHoliday.setImageResource(R.drawable.cny);
        } else {
            ivHoliday.setImageResource(R.drawable.goodfriday);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
