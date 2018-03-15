package com.example.chapter327.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/12
 * Function:
 */
public class FeedEntity {
    private Long id;

    private Long authorId;

    private Long liveroomId;

    private Long smallVideoId;

    private Long contentId;

    private Byte type;

    private Byte status;

    private String title;

    private String imagePath;

    private Integer viewCount;

    private Timestamp createTime;

    private Date updateTime;

    private Byte review;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getLiveroomId() {
        return liveroomId;
    }

    public void setLiveroomId(Long liveroomId) {
        this.liveroomId = liveroomId;
    }

    public Long getSmallVideoId() {
        return smallVideoId;
    }

    public void setSmallVideoId(Long smallVideoId) {
        this.smallVideoId = smallVideoId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getReview() {
        return review;
    }

    public void setReview(Byte review) {
        this.review = review;
    }
}