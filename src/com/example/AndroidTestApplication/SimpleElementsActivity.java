package com.example.AndroidTestApplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

public class SimpleElementsActivity extends Activity {

    private TextView resultText;
    private EditText editText;
    private Button button;
    private RadioButton radioButton;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_ui);
        resultText = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        setListeners();
    }

    private void setListeners() {
        View.OnClickListener buttonClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText.setText(view.getContentDescription() + " was clicked");
            }
        };
        button.setOnClickListener(buttonClickListner);
        radioButton.setOnClickListener(buttonClickListner);
        imageButton.setOnClickListener(buttonClickListner);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                resultText.setText(charSequence + " was entered");
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
