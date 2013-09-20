package com.example.SyncUp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

// Show a list of items that are stored in a resources file. When a link is clicked, show the web page in a Web View layout.
public class MyListActivity extends ListActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.site_names, R.layout.list)); // bind this list to the two arrays in the resource files

        final String[] links = getResources().getStringArray(R.array.site_links); // the string array of URLs from the strings.xml resource file

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // where position is the position of the item clicked
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String content = links[position];
                Intent showContent = new Intent(getApplicationContext(), WebViewerActivity.class);
                showContent.setData(Uri.parse(content)); // send the URL-to-show as a parameter
                startActivity(showContent);
            }
        });
    }
}