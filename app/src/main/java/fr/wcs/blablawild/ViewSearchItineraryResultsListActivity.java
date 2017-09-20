package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    String titre;
    ListView ListViewResults;
    TripResultAdapter mResultsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        //récupération de l'objet via Intent
        SearchRequestModel trajet = getIntent().getExtras().getParcelable("objetrajet");

        //déclaration variable et récupération données via getter
        Date date = trajet.getDateTrip();
        String arrival = trajet.getCityArrival();
        String departure = trajet.getCityDeparture();

        //Set Title
        titre = departure + " vers " + arrival;
        setTitle(titre);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        Toast.makeText(ViewSearchItineraryResultsListActivity.this, sdf.format(date), Toast.LENGTH_SHORT).show();

        ListViewResults = (ListView) findViewById(R.id.list_view_trips);
        ArrayList<TripResultModel> results = new ArrayList<>();

        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        mResultsAdapter = new TripResultAdapter(this, results);

        ListViewResults.setAdapter(mResultsAdapter);

    }

}


