
package com.yootom.unsplashforaac.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Unsplash API를 통하여 받아온 JSON파일을 직렬화하여 매개변수에 저장.
 * 참조 문서 (gson) : https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5
 * 직렬화 도움 툴 (jsonschema2pojo) : http://www.jsonschema2pojo.org/
 */

public class Links {

    //@SerializedName() : JSON으로 Serialize 될 때 매칭되는 이름으로 명시하는 목적으로 사용되는 field 마킹 어노테이션
    //@Expose : object중 해당 값이 null일 경우, json으로 만들 필드를 자동생략해준다.

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("download")
    @Expose
    private String download;
    @SerializedName("download_location")
    @Expose
    private String downloadLocation;


    /**
     * @param downloadLocation
     * @param download
     * @param html
     * @param self
     */
    public Links(String self, String html, String download, String downloadLocation) {
        super();
        this.self = self;
        this.html = html;
        this.download = download;
        this.downloadLocation = downloadLocation;
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

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }

}
