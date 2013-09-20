package com.example.SyncUp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created with IntelliJ IDEA.
 * User: Tony
 * Date: 9/19/13
 * Time: 3:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class WebViewerActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_viewer);
        Intent launchingIntent = getIntent();
        String content = launchingIntent.getData().toString(); // get the URL-to-show that was passed as a parameter to this Activity
        WebView viewer = (WebView) findViewById(R.id.listItemViewer); // get the view id defined in list_item_viewer.xml
        viewer.loadUrl(content);
    }
}
