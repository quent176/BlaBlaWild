package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity {

    //déclaration variables
    EditText editTextDeparture;
    EditText editTextArrival;
    EditText editTextDate;
    Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        //Link entre layout et java
        editTextDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        editTextArrival = (EditText) findViewById(R.id.editTextSearchDestination);
        editTextDate = (EditText) findViewById(R.id.editTextSearchDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);

        //Ajout du datepicker pour la date
        editTextDate.setFocusable(false);

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {

                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editTextDate.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SearchItineraryActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        //Au clic bouton, afficher toast ou intent vers ViewSearchItinerary
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextDeparture.getText().toString().trim().length() == 0 || editTextArrival.getText().toString().trim().length() == 0) {
                    Toast.makeText(SearchItineraryActivity.this, R.string.toast1, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                        SearchRequestModel trajet = new SearchRequestModel(editTextDeparture.getText().toString(), editTextArrival.getText().toString(), myCalendar.getTime());
                        Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                        intent.putExtra("objetrajet", trajet);
                        startActivity(intent);
                    }
                }

        });

    }

}