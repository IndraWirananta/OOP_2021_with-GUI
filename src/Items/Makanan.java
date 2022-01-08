package Items;

public class Makanan extends Item {

    private int porsi;

    public Makanan(int id, String nama, int harga, int porsi) {
        super(id, nama, harga);
        this.porsi = porsi;
    }

    public void setPorsi(int porsi) {
        this.porsi = porsi;
    }

    public int getPorsi() {
        return this.porsi;
    }

    public void info() {
        System.out.println(String.format("Nama\t\t : %s ", super.getNama()));
        System.out.println(String.format("Harga\t\t : %s ", super.getHarga()));
        System.out.println(String.format("Porsi\t\t : %s ", this.porsi));
    }
}
