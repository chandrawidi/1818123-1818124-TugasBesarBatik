package com.app.Batik_Tubes;

public class Batik {
    private String _id, _nama, _latin,_makanan, _habitat, _ciri;

    public Batik(String id, String nama, String latin, String makanan, String habitat, String ciri) {
        this._id = id;
        this._nama = nama;
        this._latin = latin;
        this._makanan = makanan;
        this._habitat = habitat;
        this._ciri = ciri;
    }
    public Batik() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_latin() {
        return _latin;
    }

    public void set_latin(String _latin) {
        this._latin = _latin;
    }
    public String get_makanan() {
        return _makanan;
    }

    public void set_makanan(String _makanan) {
        this._makanan = _makanan;
    }
    public String get_habitat() {
        return _habitat;
    }

    public void set_habitat(String _habitat) {
        this._habitat = _habitat;
    }
    public String get_ciri() {
        return _ciri;
    }

    public void set_ciri(String _ciri) {
        this._ciri = _ciri;
    }
}

