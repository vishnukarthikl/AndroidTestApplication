package com.example.AndroidTestApplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {

    private Button greetButton;
    private EditText nameField;
    private TextView greetResult;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SharedPreferences myPreferences = getSharedPreferences("my_preferences", 0);
        SharedPreferences.Editor editor = myPreferences.edit();
        editor.putBoolean("a boolean", true);
        editor.putInt("an int", 123);
        editor.putFloat("a float", 1.5f);
        editor.putString("a string", "my string");
        editor.commit();

        nameField = (EditText) findViewById(R.id.nameField);
        greetButton = (Button) findViewById(R.id.greetButton);
        greetResult = (TextView) findViewById(R.id.greetResult);
        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameField.getText().toString();
                greetResult.setText("Hi there " + name);
            }
        });


    }
}
