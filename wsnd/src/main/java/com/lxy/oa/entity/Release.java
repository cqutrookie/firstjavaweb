package com.lxy.oa.entity;

import java.util.Date;

public class Release {


    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    private String title;
    private String gameid;

    private Date releasetime;
    private Long userid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getReleasetime1() {
        return releasetime1;
    }

    public void setReleasetime1(String releasetime1) {
        this.releasetime1 = releasetime1;
    }

    private String releasetime1;
    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public long getReleaseid() {
        return releaseid;
    }

    public void setReleaseid(long releaseid) {
        this.releaseid = releaseid;
    }


    private long releaseid;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private String content;
    private String photo;
}
