package com.dark.model;

import java.io.Serializable;
import java.util.List;

public class AllReion implements Serializable {
    private List<String> provinces;
    private List<String> cities;
    private List<String> area;

    public AllReion() {
    }

    public List<String> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> getArea() {
        return area;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }
}
