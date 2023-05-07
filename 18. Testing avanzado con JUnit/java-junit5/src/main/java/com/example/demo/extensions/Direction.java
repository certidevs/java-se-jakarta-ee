package com.example.demo.extensions;

public class Direction {
    private Long id;
    private String street;
    private String postalCode;
    private String province;
    private String country;

    public Direction() {
    }

    public Direction(Long id, String street, String postalCode, String province, String country) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public Direction(String street, String postalCode, String province, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
