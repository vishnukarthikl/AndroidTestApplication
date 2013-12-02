package com.example.AndroidTestApplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyActivity extends Activity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.listView);
        final Map<String, Activity> demoMap = getDemoList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(demoMap.keySet()));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String demoItem = adapterView.getItemAtPosition(position).toString();
                Activity activity = demoMap.get(demoItem);
                Intent intent = new Intent(MyActivity.this, activity.getClass());
                startActivity(intent);
            }
        });
        addSharedPreferences();
    }

    private void addSharedPreferences() {
        SharedPreferences myPreferences = getSharedPreferences("my_preferences", 0);
        SharedPreferences.Editor editor = myPreferences.edit();
        editor.putBoolean("a boolean", true);
        editor.putInt("an int", 123);
        editor.putFloat("a float", 1.5f);
        editor.putString("a string", "my string");
        editor.commit();

    }

    private Map<String, Activity> getDemoList() {
        return new HashMap<String, Activity>() {{
            put("Simple Elements", new SimpleElementsActivity());
            put("Nested Views", new NestedViewsActivity());
            put("DateTime Elements", new DateTimeElementsActivity());
            put("Scroll List", new ScrollListActivity());
            put("Swipe Page", new SwipePageActivity());
            put("Drag drop page", new DragDropActivity());
        }};
    }
}
