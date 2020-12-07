package com.app.Batik_Tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private MyDatabase db;
    private TextView Enama, Elatin, Emakanan, Ehabitat, Eciri;
    private String Sid, Snama, Slatin, Smakanan, Shabitat, Sciri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid2");
        Snama = i.getStringExtra("Inama2");
        Slatin = i.getStringExtra("Ilatin2");
        Smakanan = i.getStringExtra("Imakanan2");
        Shabitat = i.getStringExtra("Ihabitat2");
        Sciri = i.getStringExtra("Iciri2");

        Enama = (TextView) findViewById(R.id.update_nama);
        Elatin = (TextView) findViewById(R.id.update_latin);
        Emakanan = (TextView) findViewById(R.id.update_makanan);
        Ehabitat = (TextView) findViewById(R.id.update_habitat);
        Eciri = (TextView) findViewById(R.id.update_ciri);

        Enama.setText(Snama);
        Elatin.setText(Slatin);
        Emakanan.setText(Smakanan);
        Ehabitat.setText(Shabitat);
        Eciri.setText(Sciri);

        Button btnUpdate = (Button) findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snama = String.valueOf(Enama.getText());
                Slatin = String.valueOf(Elatin.getText());
                Smakanan = String.valueOf(Emakanan.getText());
                Shabitat = String.valueOf(Ehabitat.getText());
                Sciri = String.valueOf(Eciri.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(UpdateActivity.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Slatin.equals("")){
                    Elatin.requestFocus();
                    Toast.makeText(UpdateActivity.this, "Silahkan isi nama latin", Toast.LENGTH_SHORT).show();
                } else if (Smakanan.equals("")){
                    Emakanan.requestFocus();
                    Toast.makeText(UpdateActivity.this, "Silahkan isi makanan", Toast.LENGTH_SHORT).show();
                } else if (Shabitat.equals("")){
                    Ehabitat.requestFocus();
                    Toast.makeText(UpdateActivity.this, "Silahkan isi habitat", Toast.LENGTH_SHORT).show();
                } else if (Sciri.equals("")) {
                    Eciri.requestFocus();
                    Toast.makeText(UpdateActivity.this, "Silahkan isi ciri-ciri", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBurung(new Batik(Sid, Snama, Slatin, Smakanan, Shabitat, Sciri));
                    Toast.makeText(UpdateActivity.this, "Data telah diupdate",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }
}
