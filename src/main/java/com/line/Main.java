
package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFileName = "D:\\backendSchool\\git\\read-line-parser\\FSeoulHospitalLocationInfo.csv";
        String outputFileNmae = "./hospitalDatas.sql";
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        List<Hospital> hospitalLists = hospitalLineReader.readLines(inputFileName);

        List<String> datas = new ArrayList<>();
        datas.add("INSERT INTO `likeLion-db`.`seoul_hospital` (`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) VALUES\n");
        for (Hospital h : hospitalLists) {
            String s = String.format(" (%s,%s,%s,%s,%d,%s,%s),\n",
                    h.getId(),h.getAddress(),h.getDistrict(), h.getCategory(), h.getEmergencyRoom(), h.getName(), h.getSubdivision());
            datas.add(s);
        }
        datas.add(";");
        FileWrite fw = new FileWrite(datas, outputFileNmae);
        fw.write();

    }
}