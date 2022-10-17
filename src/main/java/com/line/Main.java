
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
        for (Hospital h : hospitalLists) {
//            insert 쿼리
            dao.add(h.getId(),h.getAddress(),h.getDistrict(), h.getCategory(), h.getEmergencyRoom(), h.getName(), h.getSubdivision());
        }
//        connect 끝
        dao.fconnect();
    }

    public void getSqlSelectQuery() throws SQLException {
        HospitalDAO dao = new HospitalDAO();
        dao.findAll();
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
        HospitalDAO dao = new HospitalDAO();
//        데이터 삽입
//        for (Hospital h : hospitalLists) {
//            dao.add(h.getId(),h.getAddress(),h.getDistrict(), h.getCategory(), h.getEmergencyRoom(), h.getName(), h.getSubdivision());
//        }
//        데이터 조회
        dao.findAll();
        dao.fconnect();

        //파일 저장
//        FileWrite fw = new FileWrite(datas, outputFileNmae);
//        fw.write();

    }
}