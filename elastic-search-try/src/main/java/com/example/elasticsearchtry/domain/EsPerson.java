package com.example.elasticsearchtry.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Document(indexName = "ps", type = "person",shards = 1,replicas = 0)
public class EsPerson {
    private int id ;

    private int personId;
    private String username;
    private String phone;
    private String country;
    private String city;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
