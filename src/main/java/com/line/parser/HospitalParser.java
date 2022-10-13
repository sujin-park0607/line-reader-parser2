package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{

    @Override
    public Hospital parse(String str) {
        str = str.replaceAll("\"","");
        String[] splitted = str.split(",");
        String[] districtList = splitted[1].split(" ");

        String district = districtList[0] + " "+ districtList[1];
        String address = splitted[1].replace("\'","\\'");
        int emergencyRoom = Integer.parseInt(splitted[6].replace("\"",""));

        return new Hospital(splitted[0], address, district, splitted[2], emergencyRoom, splitted[10], null);
    }
}