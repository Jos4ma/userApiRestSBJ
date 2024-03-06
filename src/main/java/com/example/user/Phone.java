package com.example.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Phone {
    private String number;
    private String citycode;
    private String countrycode;
  
    // Constructor
  
    // Getter y setter para 'number'
    public String getNumber() {
        return number;
    }
  
    public void setNumber(String number) {
        this.number = number;
    }
  
    // Getter y setter para 'citycode'
    public String getCitycode() {
        return citycode;
    }
  
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
  
    // Getter y setter para 'countrycode'
    public String getCountrycode() {
        return countrycode;
    }
  
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
  }
