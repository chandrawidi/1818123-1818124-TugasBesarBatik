package com.app.Batik_Tubes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Elatin, Emakanan, Ehabitat, Eciri;
    private Integer Gambar = 1;
    private String Snama, Slatin, Smakanan, Shabitat, Sciri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Elatin = (EditText) findViewById(R.id.create_latin);
        Emakanan = (EditText) findViewById(R.id.create_makanan);
        Ehabitat = (EditText) findViewById(R.id.create_habitat);
        Eciri = (EditText) findViewById(R.id.create_ciri);


        Button btnCreate = (Button) findViewById(R.id.btn_tambah);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snama = String.valueOf(Enama.getText());
                Slatin = String.valueOf(Elatin.getText());
                Smakanan = String.valueOf(Emakanan.getText());
                Shabitat = String.valueOf(Ehabitat.getText());
                Sciri = String.valueOf(Eciri.getText());




                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(CreateActivity.this, "Silahkan isi nama", Toast.LENGTH_SHORT).show();
                } else if (Slatin.equals("")){
                    Elatin.requestFocus();
                    Toast.makeText(CreateActivity.this, "Silahkan isi nama latin", Toast.LENGTH_SHORT).show();
                }else if (Smakanan.equals("")){
                    Emakanan.requestFocus();
                    Toast.makeText(CreateActivity.this, "Silahkan isi makanan", Toast.LENGTH_SHORT).show();
                } else if (Shabitat.equals("")){
                    Ehabitat.requestFocus();
                    Toast.makeText(CreateActivity.this, "Silahkan isi habitat", Toast.LENGTH_SHORT).show();
                } else if (Sciri.equals("")){
                    Eciri.requestFocus();
                    Toast.makeText(CreateActivity.this, "Silahkan isi ciri", Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Elatin.setText("");
                    Emakanan.setText("");
                    Ehabitat.setText("");
                    Eciri.setText("");
                    Toast.makeText(CreateActivity.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateBurung(new Batik(null, Snama, Slatin, Smakanan, Shabitat, Sciri));

                    finish();
                }

            }
        });
    }


}

