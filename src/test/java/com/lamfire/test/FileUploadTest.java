package com.lamfire.test;

import com.lamfire.utils.HttpClient;

import java.io.File;
import java.io.IOException;

public class FileUploadTest {

    public static void main(String[] args) throws Exception {
        HttpClient http = new HttpClient();
        http.setContentType(HttpClient.ContentType.multipart_form_data);
        http.setMethod("POST");
        http.open("http://127.0.0.1:8080/filecenter/file/upload");

        File file = new File("//Users/lamfire/Downloads/1.JPG");
        http.sendMultipartFile("file", file);
        http.sendMultipartFinish();


        String content = http.readAsString();
        System.out.println(content);
        System.out.println(http.getResponseCode() + " : " +http.getResponseMessage());
        System.out.println(content.length());
        http.close();
    }
}
