package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{
    private String replaceAllQuot(String str){
        return str.replaceAll("\"","");
    }
    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");
        String[] districtList = splitted[1].split(" ");

        String district = districtList[0] + " "+ districtList[1];
        String address = splitted[1].replace("\'","\\'");
        int emergencyRoom = Integer.parseInt(splitted[6].replace("\"",""));
        return new Hospital(replaceAllQuot(splitted[0]), replaceAllQuot(address),
                            replaceAllQuot(district), replaceAllQuot(splitted[2]),
                            emergencyRoom, replaceAllQuot(splitted[10]), null);
    }
}