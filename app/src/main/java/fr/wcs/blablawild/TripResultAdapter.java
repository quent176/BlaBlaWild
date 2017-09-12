package fr.wcs.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TripResultAdapter extends BaseAdapter {

    private Context context; //context
    private ArrayList<TripResultModel> TripsModel; //data source of the list adapter

    //public constructor
    public TripResultAdapter(Context context, ArrayList<TripResultModel> TripsModel) {
      //  super(context, 0, TripsModel);
        this.context = context;
        this.TripsModel = TripsModel;

    }

    @Override
    public int getCount() {
        return TripsModel.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return TripsModel.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.trip_item, parent, false);
        }

        // get current item to be displayed
        TripResultModel currentItem = (TripResultModel) getItem(position);

        // get the TextView for item name and item description

        TextView nameDriver = (TextView)convertView.findViewById((R.id.firstNameDriver));
        TextView departureTime = (TextView)convertView.findViewById(R.id.departureTime);
        TextView price = (TextView)convertView.findViewById((R.id.viewPrice));

        nameDriver.setText(currentItem.getNameDriver());
        departureTime.setText(currentItem.getDateTransport().toString());
        price.setText(String.valueOf(currentItem.getPriceTransport()));

        // returns the view for the current row
        return convertView;
    }
}
