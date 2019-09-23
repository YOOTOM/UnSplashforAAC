
package com.yootom.unsplashforaac.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Unsplash API를 통하여 받아온 JSON파일을 직렬화하여 매개변수에 저장.
 * 참조 문서 (gson) : https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5
 * 직렬화 도움 툴 (jsonschema2pojo) : http://www.jsonschema2pojo.org/
 */

public class ProfileImage {

    //@SerializedName() : JSON으로 Serialize 될 때 매칭되는 이름으로 명시하는 목적으로 사용되는 field 마킹 어노테이션
    //@Expose : object중 해당 값이 null일 경우, json으로 만들 필드를 자동생략해준다.

    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("large")
    @Expose
    private String large;

    /**
     * @param small
     * @param large
     * @param medium
     */
    public ProfileImage(String small, String medium, String large) {
        super();
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

}
