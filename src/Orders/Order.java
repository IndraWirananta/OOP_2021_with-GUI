package Orders;

import Items.Makanan;
import Items.Minuman;
import Persons.Customer;
import java.io.Serializable;
import java.util.*;

public class Order implements OrderInterface {

    private String status;
    private int id;
    private List<Makanan> listMakanan = new ArrayList<Makanan>();
    private List<Minuman> listMinuman = new ArrayList<Minuman>();
    private Payment payment;
    private Customer customer;
    private String driver;

//  CONSTRUCTOR
    public Order(int id, Customer customer) {

        this.id = id;
        this.customer = customer;
    }

//  SETTER
    public void addFood(Makanan food) {
        this.listMakanan.add(food);
    }

    public void addDrink(Minuman drink) {
        this.listMinuman.add(drink);
    }

    public void deleteFood(int index) {
        this.listMakanan.remove(index);
    }

    public void deleteDrink(int index) {
        this.listMinuman.remove(index);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setId(int id) {
        this.id = id;
    }

//  GETTER
    public List<Makanan> getFood() {
        return this.listMakanan;
    }

    public int getId() {
        return this.id;
    }

    public List<Minuman> getDrink() {
        return this.listMinuman;
    }

    public Double getTotalPrice() {
        Double total = 0.0;
        for (Makanan x : listMakanan) {
            total += x.getHarga();
        }
        for (Minuman y : listMinuman) {
            total += y.getHarga();
        }
        return total;
    }

    public String getStatus() {
        return this.status;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public String getDriver() {
        return this.driver;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public boolean isOrderEmpty() {
        return this.listMakanan.isEmpty() && this.listMinuman.isEmpty();
    }

//  OTHER
    public void info() {
        if (!this.listMakanan.isEmpty()) {
            System.out.println("Makanan :\n");
            for (Makanan x : this.listMakanan) {
                x.info();
                System.out.println();
            }
            System.out.println();
        }

        if (!this.listMinuman.isEmpty()) {
            System.out.println("Minuman \t:\n");
            for (Minuman x : this.listMinuman) {
                x.info();
                System.out.println();
            }
            System.out.println();
        }

    }

    @Override
    public double calculateTaxes() {
        return getTotalPrice() * TAXES;
    }

    @Override
    public double calculateDeliveryCharges() {
        return getTotalPrice() * DELIVERY_CHARGES;
    }

    @Override
    public double calculateTotal() {
        return getTotalPrice() * (1 + TAXES + DELIVERY_CHARGES);
    }

}
