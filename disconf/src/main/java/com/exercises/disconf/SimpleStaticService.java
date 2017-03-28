package com.exercises.disconf;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import com.exercises.disconf.config.StaticConfig;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/27.
 */
public class SimpleStaticService {
    private static int staticItem = 56;

    /**
     * @return
     */
    public static int getStaticFileData() {

        return StaticConfig.getStaticVar();
    }

    @DisconfItem(key = "staticItem")
    public static int getStaticItem() {
        return staticItem;
    }

    public static void setStaticItem(int staticItem) {
        SimpleStaticService.staticItem = staticItem;
    }
}
