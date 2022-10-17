
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
//        dao.add(hospitalLists);
//        dao.fconnect();
//        데이터 조회
        dao.findAll();
        dao.fconnect();

        //파일 저장
//        FileWrite fw = new FileWrite(datas, outputFileNmae);
//        fw.write();

    }
}