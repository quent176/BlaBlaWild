package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {

    EditText editTextDeparture;
    EditText editTextArrival;
    EditText editTextDate;
    Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editTextDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        editTextArrival = (EditText) findViewById(R.id.editTextSearchDestination);
        editTextDate = (EditText) findViewById(R.id.editTextSearchDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextDeparture.getText().toString().trim().length() == 0 || editTextArrival.getText().toString().trim().length() == 0) {
                    Toast.makeText(SearchItineraryActivity.this, "Veuillez renseigner un lieu de départ et d'arrivée", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                        Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                        String departureCity = editTextDeparture.getText().toString();
                        String arrivalCity = editTextArrival.getText().toString();
                        intent.putExtra("departure", departureCity );
                        intent.putExtra("arrival", arrivalCity );
                        startActivity(intent);
                    }
                }

        });

    }
}