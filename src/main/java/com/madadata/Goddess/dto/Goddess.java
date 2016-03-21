package com.madadata.Goddess.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by lixinyi on 16/3/21.
 */
public class Goddess {
    @Min(0)
    @Max(20)
    private long id;
    @Length(max=20)
    private String firstName;
    @Length(max=20)
    private String lastName;
    @Length(max=3)
    private int age;
    @Email
    private String email;
    @Max(5)
    private int height;
    @Max(4)
    private int weight;
    @Min(11)
    @Max(11)
    private String mobilePhone;


    public Goddess(long id, String firstName, String lastName, int age, String email,int height, int weight, String mobilePhone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email=email;
        this.height = height;
        this.weight = weight;
        this.mobilePhone = mobilePhone;
    }
    @JsonProperty
    public long getId() {
        return id;
    }
    @JsonProperty
    public String getFirstName() {
        return firstName;
    }
    @JsonProperty
    public String getLastName() {
        return lastName;
    }
    @JsonProperty
    public int getAge() {
        return age;
    }
    @JsonProperty
    public int getHeight() {
        return height;
    }
    @JsonProperty
    public int getWeight() {
        return weight;
    }
    @JsonProperty
    public String getMobilePhone() {
        return mobilePhone;
    }
}
