package com.example.carolynhemmings.mycustomlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String[] artTitles = new String[] {
                "The Starry Night",
                "American Gothic",
                "Mona Lisa",
                "The Night Watch",
                "The Kiss",
                "The Birth of Venus",
                "The Art of Painting",
                "Nighthawks",
                "David",
                "The Night"
        };

        final String[] artDates = new String[] {
                "1889",
                "1930",
                "1517",
                "1642",
                "1908",
                "1486",
                "1666",
                "1942",
                "1504",
                "1919"
        };

        final String[] artist = new String[] {
                "Vincent van Gogh",
                "Grant Wood",
                "Leonardo da Vinci",
                "Rembrandt",
                "Gustav Klimt",
                "Sandro Botticelli",
                "Johannes Vermeer",
                "Edward Hopper",
                "Michelangelo",
                "Max Beckman"
        };

        ArrayList<HashMap<String, String>> artistList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            HashMap<String, String> data = new HashMap<>();
            data.put("title", artTitles[i]);
            data.put("dates", artDates[i]);
            data.put("artist", artist[i]);

            artistList.add(data);
        }

        listView = (ListView) findViewById(R.id.list);

        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), artistList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPosition = position + 1;

                String itemClicked = listView.getItemAtPosition(myPosition).toString();

                Toast.makeText(getApplicationContext(), "Artwork Number Clicked: " + itemClicked, Toast.LENGTH_LONG).show();
;            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
