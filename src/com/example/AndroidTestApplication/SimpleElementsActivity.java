package com.example.AndroidTestApplication;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        TextView longPressTextView = (TextView) findViewById(R.id.longPressText);
        ImageView imageView = (ImageView) findViewById(R.id.longPressImage);

        View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                resultText.setText(v.getContentDescription() + " was long pressed");
                return true;
            }
        };

        longPressTextView.setOnLongClickListener(longClickListener);
        imageView.setOnLongClickListener(longClickListener);

        ActionBar actionBar = getActionBar();
        actionBar.show();
        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.simple_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        resultText.setText(item.getTitle() + " menu item was selected");
        return true;
    }

    private void setListeners() {
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultText.setText(view.getContentDescription() + " was clicked");
            }
        };
        button.setOnClickListener(buttonClickListener);
        radioButton.setOnClickListener(buttonClickListener);
        imageButton.setOnClickListener(buttonClickListener);

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
