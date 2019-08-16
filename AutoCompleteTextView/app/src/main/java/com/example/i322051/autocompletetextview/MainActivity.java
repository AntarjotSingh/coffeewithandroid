package com.example.i322051.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> searchArrayList = new ArrayList<String>();

        searchArrayList.add("United States");
        searchArrayList.add("France");
        searchArrayList.add("United Kingdom");
        searchArrayList.add("India");
        searchArrayList.add("Indonesia");
        searchArrayList.add("Germany");
        searchArrayList.add("Spain");

        AutoCompleteAdapter adapter = new AutoCompleteAdapter(this,
                R.layout.list_item, R.id.textView1, searchArrayList);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.searchAutoComplete);
        autoCompleteTextView.setAdapter(adapter);

    }
}
