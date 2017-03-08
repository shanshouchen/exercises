package com.jason.exercises.jdk.work.common;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public class Paths {
    private String path;
    private Long ref;

    public Paths(String path, Long ref) {
        this.path = path;
        this.ref = ref;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getRef() {
        return ref;
    }

    public void setRef(Long ref) {
        this.ref = ref;
    }
}
