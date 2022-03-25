package com.example.servlet.entity;

public class CarEntity implements Comparable<CarEntity>{

    private Long id;

    private String number;

    private String mark;

    private String model;

    private Long year;

    private String owner;

    private String address;

    public CarEntity(Long id, String number, String mark, String model, long year, String owner, String address) {
        this.id = id;
        this.number = number;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.address = address;
    }

    public CarEntity(String number, String mark, String model, long year, String owner, String address) {
        this(null, number, mark, model, year, owner, address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", owner='" + owner + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(CarEntity o) {
        if (getYear() == null || o.getYear() == null) {
            return 0;
        }

        return getYear().compareTo(o.getYear());
    }
}
