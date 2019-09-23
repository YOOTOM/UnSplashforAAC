
package com.yootom.unsplashforaac.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Unsplash API를 통하여 받아온 JSON파일을 직렬화하여 매개변수에 저장.
 * 참조 문서 (gson) : https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5
 * 직렬화 도움 툴 (jsonschema2pojo) : http://www.jsonschema2pojo.org/
 */

public class Urls {

    //@SerializedName() : JSON으로 Serialize 될 때 매칭되는 이름으로 명시하는 목적으로 사용되는 field 마킹 어노테이션
    //@Expose : object중 해당 값이 null일 경우, json으로 만들 필드를 자동생략해준다.

    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("full")
    @Expose
    private String full;
    @SerializedName("regular")
    @Expose
    private String regular;
    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    /**
     *
     * @param raw
     * @param regular
     * @param full
     * @param thumb
     * @param small
     */
    public Urls(String raw, String full, String regular, String small, String thumb) {
        super();
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
        this.thumb = thumb;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

}
