package com.imooc.mvcdemo.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * User: jennie
 * Date: 2016/6/6
 * Time: 15:19
 */
public class HandleForm {
    private String songName;
    private String artistName;
    private String gendre;
    private String description;
    private CommonsMultipartFile file;


    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file            = file;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGendre() {
        return gendre;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

}
