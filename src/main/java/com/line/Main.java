
package com.line;

import com.line.dao.HospitalDAO;
import com.line.domain.Hospital;
import com.line.parser.HospitalParser;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * sql 쿼리 만드는 메소드드
     * */
    public void getSqlInsertQuery(List<Hospital> hospitalLists) throws SQLException {
        HospitalDAO dao = new HospitalDAO();
        dao.connect();

        for (Hospital h : hospitalLists) {
            dao.add(h.getId(),h.getAddress(),h.getDistrict(), h.getCategory(), h.getEmergencyRoom(), h.getName(), h.getSubdivision());
        }
        dao.fconnect();
    }

    public static void main(String[] args) throws IOException, SQLException {
        //input, output 파일경로
        String inputFileName = "D:\\backendSchool\\git\\read-line-parser\\FSeoulHospitalLocationInfo.csv";
        String outputFileNmae = "./hospitalDatas.sql";

        //parser
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        List<Hospital> hospitalLists = hospitalLineReader.readLines(inputFileName);

        //sql쿼리 작성
        Main main = new Main();
        main.getSqlInsertQuery(hospitalLists);

        //파일 저장
//        FileWrite fw = new FileWrite(datas, outputFileNmae);
//        fw.write();

    }
}