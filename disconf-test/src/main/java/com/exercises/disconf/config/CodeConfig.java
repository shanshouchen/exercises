package com.exercises.disconf.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Service;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/27.
 */
@Service
@DisconfFile(filename = "code.properties", targetDirPath = "disconf")
public class CodeConfig {
    private String codeError = "";

    private boolean routerRateLimitEnable;

    @DisconfFileItem(name = "syserror.paramtype", associateField = "codeError")
    public String getCodeError() {
        return codeError;
    }

    @DisconfFileItem(name = "proxy.routerRateEnable", associateField = "routerRateLimitEnable")
    public boolean isRouterRateLimitEnable() {
        return routerRateLimitEnable;
    }

    public void setRouterRateLimitEnable(boolean routerRateLimitEnable) {
        this.routerRateLimitEnable = routerRateLimitEnable;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }
}
