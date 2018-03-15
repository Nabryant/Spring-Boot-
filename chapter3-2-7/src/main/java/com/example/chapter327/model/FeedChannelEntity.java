package com.example.chapter327.model;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/13
 * Function:
 */
public class FeedChannelEntity {
    private Long id;

    private String name;

    private String fullName;

    private Byte type;

    private String imageUrl;

    private Byte idx;

    private Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Byte getIdx() {
        return idx;
    }

    public void setIdx(Byte idx) {
        this.idx = idx;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}