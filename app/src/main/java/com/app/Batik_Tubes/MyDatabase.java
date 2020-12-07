package com.app.Batik_Tubes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class MyDatabase extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_burung";

    private static final String tb_burung = "tb_burung";

    private static final String tb_burung_id = "id";
    private static final String tb_burung_nama = "nama";
    private static final String tb_burung_latin = "latin";
    private static final String tb_burung_makanan = "makanan";
    private static final String tb_burung_habitat = "habitat";
    private static final String tb_burung_ciri = "ciri";

    private static final String CREATE_TABLE_BURUNG = "CREATE TABLE " + tb_burung + "("
            + tb_burung_id + " INTEGER PRIMARY KEY ,"
            + tb_burung_nama + " TEXT,"
            + tb_burung_latin + " TEXT,"
            + tb_burung_makanan + " TEXT,"
            + tb_burung_habitat + " TEXT,"
            + tb_burung_ciri + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BURUNG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateBurung (Batik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_burung_id, mdNotif.get_id());
        values.put(tb_burung_nama, mdNotif.get_nama());
        values.put(tb_burung_latin, mdNotif.get_latin());
        values.put(tb_burung_makanan, mdNotif.get_makanan());
        values.put(tb_burung_habitat, mdNotif.get_habitat());
        values.put(tb_burung_ciri, mdNotif.get_ciri());
        db.insert(tb_burung, null, values);
        db.close();
    }

    public List<Batik> ReadBurung() {
        List<Batik> judulModelList = new ArrayList<Batik>();
        String selectQuery = "SELECT  * FROM " + tb_burung;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Batik mdKontak = new Batik();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_latin(cursor.getString(2));
                mdKontak.set_makanan(cursor.getString(3));
                mdKontak.set_habitat(cursor.getString(4));
                mdKontak.set_ciri(cursor.getString(5));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateBurung (Batik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_burung_id, mdNotif.get_id());
        values.put(tb_burung_nama, mdNotif.get_nama());
        values.put(tb_burung_latin, mdNotif.get_latin());
        values.put(tb_burung_makanan, mdNotif.get_makanan());
        values.put(tb_burung_habitat, mdNotif.get_habitat());
        values.put(tb_burung_ciri, mdNotif.get_ciri());

        return db.update(tb_burung, values, tb_burung_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteBurung (Batik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_burung, tb_burung_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

