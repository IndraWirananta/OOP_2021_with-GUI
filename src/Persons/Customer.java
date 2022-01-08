package Persons;

/*
todo

menu -> edit order -> delete sama edit food jadiin satu aja
menu -> new order -> implementasi del, nnti ini dipake jg di edit order
 */
import Items.Makanan;
import Items.Minuman;
import java.util.*;

public class Customer extends Person {

    private String address;

    public Customer(int id, String name, String phone, String password, String address) {
        super(id, name, phone, password);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void info() {
        System.out.println("Name \t: " + getName());
        System.out.println("Phone \t: " + getPhone());
        System.out.println("Address : " + getAddress());
    }

}
