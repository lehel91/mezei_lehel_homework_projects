package com.mycompany.library.model;

public class Reader {
    private int reader_id;
    private String name;
    private String address;

    public Reader(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Reader(String name, int reader_id) {
        this.reader_id = reader_id;
        this.name = name;
    }
    
    public Reader(int id, String name, String address) {
        this(name, address);
        reader_id = id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
        return name + ", ID: " + reader_id + ", " + address;
    }
    
    
}
