package com.imooc.mvcdemo.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * User: jennie
 * Date: 2016/6/6
 * Time: 10:40
 */
public class FileRequest {

    private MultipartFile file;

    private String name;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
