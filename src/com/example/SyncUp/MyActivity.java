package com.example.SyncUp;

import android.app.Activity;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    public void onOption1Clicked(MenuItem menuItem) {
        showToast("Clicked Option 1");
    }

    public void onOption2Clicked(MenuItem menuItem) {
        showToast("Clicked Option 2");
    }

    public void onOption3Clicked(MenuItem menuItem) {
        showToast("Clicked Option 3");
    }

    public void onExitClicked(MenuItem menuItem) {
        finish();
    }

    private void showToast(CharSequence message) {
        Toast t = Toast.makeText(this, message, Toast.LENGTH_LONG);
        t.show();
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