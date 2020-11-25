package ru.croc.java2020.lesson07.json.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"address"})
public class CustomCompany {
    @JsonProperty("id")
    private long customId;
    @JsonProperty("name")
    private String customName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> websites = new ArrayList<>();
    //@JsonIgnore
    private CustomAddress address;

    public long getCustomId() {
        return customId;
    }

    public void setCustomId(long customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public List<String> getWebsites() {
        return websites;
    }

    public void setWebsites(List<String> websites) {
        this.websites = websites;
    }

    public CustomAddress getAddress() {
        return address;
    }

    public void setAddress(CustomAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomCompany{" +
                "customId=" + customId +
                ", customName='" + customName + '\'' +
                ", websites=" + websites +
                ", address=" + address +
                '}';
    }
}

class CustomAddress {
    private String street;
    private String city;

    public CustomAddress() {
    }

    public CustomAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CustomAddress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
