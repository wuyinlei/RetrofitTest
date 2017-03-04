package com.mingchu.retrofittest.bean;

import java.io.Serializable;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class BannerBean implements Serializable {


    /**
     * id : 3
     * icon : http://image.xinliji.me/o_1b2vq5v23moam2b1kmf113smbdi.png
     * pic : http://image.xinliji.me/o_1b2vq62nu1gqbp125g1slo1fgqn.png
     * title : 咨询师免费入驻
     * subtitle : 咨询师免费入驻
     * type : webview
     * url : http://console.xinliji.me/consultant/applyViaMobile?id=1&token=
     * target :
     * className :
     */

    private String id;
    private String icon;
    private String pic;
    private String title;
    private String subtitle;
    private String type;
    private String url;
    private String target;
    private String className;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "id='" + id + '\'' +
                ", icon='" + icon + '\'' +
                ", pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", target='" + target + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
