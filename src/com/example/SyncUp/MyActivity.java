package com.example.SyncUp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    private TextView textViewContactInfo;
    private TextView textViewLocation;
    private Button btnGetLocation;
    private Button btnGetContactInfo;
    private View.OnClickListener btnGetLocationClickListener;
    private View.OnClickListener btnGetContactInfoClickListener;
    private int btnGetLocationClickCounter;
    private int btnGetContactInfoClickCounter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        InitializeApp();
    }

    private void InitializeApp() {
        // initialize text views
        textViewContactInfo = (TextView) findViewById(R.id.textViewContactInfo);
        textViewLocation = (TextView) findViewById(R.id.textViewLocation);

        // initialize button, define listener, attach listener to button
        btnGetContactInfo = (Button) findViewById(R.id.btnGetContactInfo);
        btnGetContactInfoClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                BtnGetContactInfoOnClick();
            }
        };
        btnGetContactInfo.setOnClickListener(btnGetContactInfoClickListener);

        // initialize button, define listener, attach listener to button
        btnGetLocation = (Button) findViewById(R.id.btnGetLocation);
        btnGetLocationClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                BtnGetLocationOnClick();
            }
        };
        btnGetLocation.setOnClickListener(btnGetLocationClickListener);
    }

    private void BtnGetContactInfoOnClick() {
        btnGetContactInfoClickCounter++;
        textViewContactInfo.setText(String.format("You clicked this %d times", btnGetContactInfoClickCounter));
    }

    private void BtnGetLocationOnClick() {
        btnGetLocationClickCounter++;
        textViewLocation.setText(String.format("You clicked this %d times", btnGetLocationClickCounter));
    }
}