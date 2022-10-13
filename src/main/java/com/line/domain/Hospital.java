package com.line.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private Integer emergencyRoom;
    private String name;
    private String subdivision;

    private void setSubdivision(){
        String[] inputCheck = new String[]{"내과", "외과", "소아", "피부", "성형",
                "정형외과", "척추", "교정", "산부인과", "관절", "봉합", "화상", "골절", "영유아", "안과",
                "가정의학과", "비뇨기과", "치과"};
        for (String s : inputCheck) {
            if(this.name.contains(s)){
                this.subdivision=s;
            }
        }
    }
    public Hospital(String id, String address, String category, Integer emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        String[] splited = this.address.split(" ");
        this.district = String.format("%s %s",splited[0],splited[1]);
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.setSubdivision();
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