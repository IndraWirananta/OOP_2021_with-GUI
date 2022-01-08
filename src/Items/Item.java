package Items;

import java.io.Serializable;

abstract public class Item implements Serializable {

    private String nama;
    private int harga;
    private int id;

    public Item(int id, String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        this.id = id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama() {
        return this.nama;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getId() {
        return this.id;
    }

    public abstract void info();
}
