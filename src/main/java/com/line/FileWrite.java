package com.line;

import java.io.*;
import java.util.List;

public class FileWrite {
    List<String> strs;
    String filename;

    public FileWrite(List<String> strs, String filename){
        this.strs = strs;
        this.filename = filename;
    }


    public void write() throws IOException {
        File file = new File(filename);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()),"UTF8"));
        for (String str : strs) {
            writer.write(str);
        }
        writer.close();

    }
}