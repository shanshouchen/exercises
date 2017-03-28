package com.exercises.disconf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/27.
 */
@Service
public class AutoConfig {
    @Value("${auto}")
    private String auto;

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }
}
