
package com.yootom.unsplashforaac.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
 * Unsplash API를 통하여 받아온 JSON파일을 직렬화하여 매개변수에 저장.
 * 참조 문서 (gson) : https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5
 * 직렬화 도움 툴 (jsonschema2pojo) : http://www.jsonschema2pojo.org/
 */

public class UnSplash {

    //@SerializedName() : JSON으로 Serialize 될 때 매칭되는 이름으로 명시하는 목적으로 사용되는 field 마킹 어노테이션
    //@Expose : object중 해당 값이 null일 경우, json으로 만들 필드를 자동생략해준다.

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("width")
    @Expose
    private Long width;
    @SerializedName("height")
    @Expose
    private Long height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("alt_description")
    @Expose
    private String altDescription;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("likes")
    @Expose
    private Long likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("current_user_collections")
    @Expose
    private List<Object> currentUserCollections = null;
    @SerializedName("user")
    @Expose
    private User user;

    /**
     *
     * @param currentUserCollections
     * @param urls
     * @param width
     * @param altDescription
     * @param links
     * @param id
     * @param updatedAt
     * @param height
     * @param color
     * @param createdAt
     * @param description
     * @param likes
     * @param categories
     * @param likedByUser
     * @param user
     */
    public UnSplash(String id, String createdAt, String updatedAt, Long width, Long height, String color, Object description, String altDescription, Urls urls, Links links, List<Object> categories, Long likes, Boolean likedByUser, List<Object> currentUserCollections, User user) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.description = description;
        this.altDescription = altDescription;
        this.urls = urls;
        this.links = links;
        this.categories = categories;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.currentUserCollections = currentUserCollections;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
