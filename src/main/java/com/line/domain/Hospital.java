package com.line.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
    private String subdivision;


    public Hospital(String id, String address, String category, Integer emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        String[] splited = this.address.split(" ");
        this.district = String.format("%s %s",splited[0],splited[1]);
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = null;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

}