package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    String titre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        String arrival;
        String departure;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            departure = bundle.getString("departure");
            arrival = bundle.getString("arrival");
        } else {
            departure = null;
            arrival = null;
        }

        titre = departure + " vers " + arrival;
        setTitle(titre);
    }
}
