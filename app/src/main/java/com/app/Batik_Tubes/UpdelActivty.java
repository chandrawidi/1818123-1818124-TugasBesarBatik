package com.app.Batik_Tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UpdelActivty extends AppCompatActivity {
    private MyDatabase db;
    private TextView Enama, Elatin, Emakanan, Ehabitat, Eciri;
    private String Sid, Snama, Slatin, Smakanan, Shabitat, Sciri;
    private String SEid, SEnama, SElatin, SEmakanan, SEhabitat, SEciri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel);
        db = new MyDatabase(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Slatin = i.getStringExtra("Ilatin");
        Smakanan = i.getStringExtra("Imakanan");
        Shabitat = i.getStringExtra("Ihabitat");
        Sciri = i.getStringExtra("Iciri");

        Enama = (TextView) findViewById(R.id.nama);
        Elatin = (TextView) findViewById(R.id.isi_latin);
        Emakanan = (TextView) findViewById(R.id.isi_makanan);
        Ehabitat = (TextView) findViewById(R.id.isi_habitat);
        Eciri = (TextView) findViewById(R.id.isi_ciri);

        Enama.setText(Snama);
        Elatin.setText(Slatin);
        Emakanan.setText(Smakanan);
        Ehabitat.setText(Shabitat);
        Eciri.setText(Sciri);

        ImageView btn_del = (ImageView) findViewById(R.id.btn_delete);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBurung(new Batik(Sid, Snama, Slatin, Smakanan, Shabitat, Sciri));
                Toast.makeText(UpdelActivty.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        SEid = Sid;
        SEnama = String.valueOf(Enama.getText());
        SElatin = String.valueOf(Elatin.getText());
        SEmakanan = String.valueOf(Emakanan.getText());
        SEhabitat = String.valueOf(Ehabitat.getText());
        SEciri = String.valueOf(Eciri.getText());
    }

    public void update (View view){
        String Sid = SEid;
        String Snama = SEnama;
        String Slatin = SElatin;
        String Smakanan = SEmakanan;
        String Shabitat = SEhabitat;
        String Sciri = SEciri;
        Intent goUpdel = new Intent(UpdelActivty.this, UpdateActivity.class);
        goUpdel.putExtra("Iidfauna2", Sid);
        goUpdel.putExtra("Inamafauna2", Snama);
        goUpdel.putExtra("Ikerajaanfauna2", Slatin);
        goUpdel.putExtra("Ifamilifauna2", Smakanan);
        goUpdel.putExtra("Ikelasfauna2", Shabitat);
        goUpdel.putExtra("Ikarakteristikfauna2", Sciri);
        startActivity(goUpdel);
        finish();
    }
}

