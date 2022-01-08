package Items;

public class Minuman extends Item {

    private int volume;

    public Minuman(int id, String nama, int harga, int volume) {
        super(id, nama, harga);
        this.volume = volume;

    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return this.volume;
    }

    @Override
    public void info() {

        System.out.println(String.format("Nama\t\t : %s ", super.getNama()));
        System.out.println(String.format("Harga\t\t : %s ", super.getHarga()));
        System.out.println(String.format("Volume\t\t : %s ", this.volume));
    }
}
