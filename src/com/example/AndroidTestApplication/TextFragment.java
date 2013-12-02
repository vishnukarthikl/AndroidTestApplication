package com.example.AndroidTestApplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
    private final int position;

    public TextFragment(int position) {
        this.position = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String text;
        switch (position) {
            case 0: text = "first tab";
                break;
            case 1: text = "second tab";
                break;
            case 2: text = "third tab";
                break;
            default: text = "";
        }

        View view = inflater.inflate(R.layout.fragment_selection, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(text);
        return view;

    }
}
