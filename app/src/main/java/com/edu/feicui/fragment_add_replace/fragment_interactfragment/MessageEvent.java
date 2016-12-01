package com.edu.feicui.fragment_add_replace.fragment_interactfragment;

/**
 * Created by Administrator on 2016/11/28.
 */
public class MessageEvent {
    private String name;
    private String path;

    public MessageEvent() {
    }

    public MessageEvent(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
