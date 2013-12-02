package com.example.AndroidTestApplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScrollListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.listView);
        List<String> dummyList = getDummyList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dummyList);
        listView.setAdapter(adapter);

    }


    private ArrayList<String> getDummyList() {
        return new ArrayList<String>(){{
         add("All Passion Spent");
         add("A Time to Kill");
         add("Blood's a Rover");
         add("Humpty Dumpty");
         add("Clouds of Witness");
         add("The Cricket on the Hearth");
         add("Eyeless in Gaza");
         add("A Farewell to Arms");
         add("Fear and Trembling");
         add("Gone with the Wind");
         add("Great Work of Time");
         add("The Green Bay Tree");
         add("The House of Mirth");
         add("In Death Ground");
         add("In a Dry Season");
         add("Lilies of the Field");
         add("Look to Windward");
         add("The Moon by Night");
         add("No Highway");
         add("The Painted Veil");
         add("Postern of Fate");
         add("The Skull Beneath the Skin");
         add("The Sun Also Rises");
         add("The Torment of Others");
         add("Time of our Darkness");
         add("Vanity Fair");
         add("The Wealth of Nations");
         add("The Widening Gyre");
         add("The Wives of Bath");
        }};
    }
}
