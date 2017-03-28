package com.exercises.disconf.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import org.springframework.stereotype.Service;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/27.
 */
@Service
@DisconfFile(filename = "empty.properties")
public class EmptyConf {
}
