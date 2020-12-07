package com.app.Batik_Tubes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Batik> ListBurung = new ArrayList<Batik>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListBurung);
        mListView = (ListView) findViewById(R.id.list_burung);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListBurung.clear();

        List<Batik> contacts = db.ReadBurung();
        for (Batik cn : contacts) {
            Batik judulModel = new Batik();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_latin(cn.get_latin());
            judulModel.set_makanan(cn.get_makanan());
            judulModel.set_habitat(cn.get_habitat());
            judulModel.set_ciri(cn.get_ciri());
            ListBurung.add(judulModel);

            if ((ListBurung.isEmpty()))
                Toast.makeText(ReadActivity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
        BottomNavigationView bottomNav = findViewById(R.id.menu_burung);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            Fragment selectetdFragment = null;

            switch (menuItem.getItemId()){
//                case R.id.menu_list_fauna:
//                    Intent b = new Intent(DataFauna.this, DataFauna.class);
//                    startActivity(b);
//                    break;
                case R.id.menu_add_burung:
                    Intent a = new Intent(ReadActivity.this, CreateActivity.class);
                    startActivity(a);
                    break;
//                case R.id.menu_about:
//                    Intent c = new Intent(DataFauna.this, About.class);
//                    startActivity(c);
//                    break;
            }
            return true;
        }
    };

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.menu_about){
            startActivity(new Intent(this, AboutActivity.class));
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Batik obj_itemDetails = (Batik) o;

        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Slatin = obj_itemDetails.get_latin();
        String Smakanan = obj_itemDetails.get_makanan();
        String Shabitat = obj_itemDetails.get_habitat();
        String Sciri = obj_itemDetails.get_ciri();

        Intent goUpdel = new Intent(ReadActivity.this, UpdelActivty.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ilatin", Slatin);
        goUpdel.putExtra("Imakanan", Smakanan);
        goUpdel.putExtra("Ihabitat", Shabitat);
        goUpdel.putExtra("Iciri", Sciri);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListBurung.clear();
        mListView.setAdapter(adapter_off);

        List<Batik> contacts = db.ReadBurung();
        for (Batik cn : contacts) {
            Batik judulModel = new Batik();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_latin(cn.get_latin());
            judulModel.set_makanan(cn.get_makanan());
            judulModel.set_habitat(cn.get_habitat());
            judulModel.set_ciri(cn.get_ciri());
            ListBurung.add(judulModel);

            if ((ListBurung.isEmpty()))
                Toast.makeText(ReadActivity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

