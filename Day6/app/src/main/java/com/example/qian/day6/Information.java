package com.example.qian.day6;

public class Information {

    public static final String TABLE_NAME = "Information";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PHONE = "phone";

    private int id;
    private String name;
    private String phone;
    private String address;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_ADDRESS + " TEXT,"
                    + COLUMN_PHONE + " TEXT)";

    public Information() {
    }

    public Information(int id, String name, String address, String phone) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}