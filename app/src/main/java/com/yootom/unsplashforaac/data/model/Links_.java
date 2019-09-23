
package com.yootom.unsplashforaac.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Unsplash API를 통하여 받아온 JSON파일을 직렬화하여 매개변수에 저장.
 * 참조 문서 (gson) : https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5
 * 직렬화 도움 툴 (jsonschema2pojo) : http://www.jsonschema2pojo.org/
 */


public class Links_ {

    //@SerializedName() : JSON으로 Serialize 될 때 매칭되는 이름으로 명시하는 목적으로 사용되는 field 마킹 어노테이션
    //@Expose : object중 해당 값이 null일 경우, json으로 만들 필드를 자동생략해준다.

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("photos")
    @Expose
    private String photos;
    @SerializedName("likes")
    @Expose
    private String likes;
    @SerializedName("portfolio")
    @Expose
    private String portfolio;
    @SerializedName("following")
    @Expose
    private String following;
    @SerializedName("followers")
    @Expose
    private String followers;


    /**
     * @param photos
     * @param followers
     * @param following
     * @param portfolio
     * @param likes
     * @param html
     * @param self
     */

    public Links_(String self, String html, String photos, String likes, String portfolio, String following, String followers) {
        super();
        this.self = self;
        this.html = html;
        this.photos = photos;
        this.likes = likes;
        this.portfolio = portfolio;
        this.following = following;
        this.followers = followers;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

}
