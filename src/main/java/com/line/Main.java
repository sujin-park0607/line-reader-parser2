
package com.line;

import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * sql 쿼리 만드는 메소드드
     * */
    public List<String> getSqlInsertQuery(List<Hospital> hospitalLists){
        List<String> datas = new ArrayList<>();
        datas.add("INSERT INTO `likeLion-db`.`seoul_hospital` (`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) VALUES\n");

        int i = 0;
        for (Hospital h : hospitalLists) {
            String s;
            if(i == hospitalLists.size()-1){
                s = String.format(" (\"%s\",\"%s\",\"%s\",\"%s\",\"%d\",\"%s\",\"%s\")\n",
                        h.getId(),h.getAddress(),h.getDistrict(), h.getCategory(), h.getEmergencyRoom(), h.getName(), h.getSubdivision());
                System.out.println(s);
            }else{
                s = String.format(" (\"%s\",\"%s\",\"%s\",\"%s\",\"%d\",\"%s\",\"%s\"),\n",
                        h.getId(),h.getAddress(),h.getDistrict(), h.getCategory(), h.getEmergencyRoom(), h.getName(), h.getSubdivision());
            }
            datas.add(s);
            i++;
        }
        datas.add(";");
        return datas;
    }

    public static void main(String[] args) throws IOException {
        //input, output 파일경로
        String inputFileName = "D:\\backendSchool\\git\\read-line-parser\\FSeoulHospitalLocationInfo.csv";
        String outputFileNmae = "./hospitalDatas.sql";

        //parser
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        List<Hospital> hospitalLists = hospitalLineReader.readLines(inputFileName);

        //sql쿼리 작성
        Main main = new Main();
        List<String> datas = main.getSqlInsertQuery(hospitalLists);

        //파일 저장
        FileWrite fw = new FileWrite(datas, outputFileNmae);
        fw.write();

    }
}