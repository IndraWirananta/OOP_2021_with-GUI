package Persons;

import java.io.Serializable;

abstract public class Person implements Serializable {

    private String name;
    private String phone;
    private String password;
    private int id;

    public Person(int id, String name, String phone, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean auth(String pass) {
        return this.password.equals(pass);
    }

}
