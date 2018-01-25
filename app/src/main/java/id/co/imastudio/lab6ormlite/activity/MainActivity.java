package id.co.imastudio.lab6ormlite.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import id.co.imastudio.lab6ormlite.AnggotaAdapter;
import id.co.imastudio.lab6ormlite.DbHelper;
import id.co.imastudio.lab6ormlite.ModelAnggota;
import id.co.imastudio.lab6ormlite.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    List<ModelAnggota> listData = new ArrayList<>();
    DbHelper dbHelper;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, TambahAnggotaActivity.class));
            }
        });

        recycler = findViewById(R.id.recyclerView);
        // 1 dataset
//        ModelAnggota anggota1 = new ModelAnggota(1, "Slamet", "Slipi");
//
//        for (int i = 0; i < 10; i++) {
//            listData.add(anggota1);
//
//        }
//
//        ModelAnggota anggota2 = new ModelAnggota();
//        anggota2.setAlamat("Palmerah");
//        anggota2.setId(2);
//        anggota2.setNama("Bambang");
//        listData.add(anggota2);


        dbHelper = new DbHelper(this);
        listData = dbHelper.ambilData();

        // 2 adapter
        recycler.setAdapter(new AnggotaAdapter(MainActivity.this, listData));
        // 3 layout manager
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        listData = dbHelper.ambilData();
        recycler.setAdapter(new AnggotaAdapter(MainActivity.this, listData));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
