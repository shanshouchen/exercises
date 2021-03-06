package com.exercises.disconf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/27.
 */
public class AutoService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(AutoService.class);

    private String auto;

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
        LOGGER.info("i' m here: setting auto");
    }
}
