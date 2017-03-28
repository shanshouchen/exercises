package com.exercises.disconf.task;

import com.baidu.disconf.client.usertools.DisconfDataGetter;
import com.exercises.disconf.SimpleStaticService;
import com.exercises.disconf.config.AutoConfig;
import com.exercises.disconf.config.CodeConfig;
import com.exercises.disconf.config.JedisConfig;
import com.exercises.disconf.service.AutoService;
import com.exercises.disconf.service.AutoService2;
import com.exercises.disconf.service.BaoBaoService;
import com.exercises.disconf.service.SimpleRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/27.
 */
@Service
public class DisconfDemoTask {
    protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfDemoTask.class);

    @Autowired
    private BaoBaoService baoBaoService;

    @Autowired
    private SimpleRedisService simpleRedisService;

    @Autowired
    private JedisConfig jedisConfig;

    @Autowired
    private AutoService autoService;

    @Autowired
    private AutoService2 autoService2;

    @Autowired
    private CodeConfig codeConfig;

    private static final String REDIS_KEY = "disconf_key";

    @Autowired
    private AutoConfig autoConfig;

    /**
     *
     */
    public int run() {

        try {

            while (true) {

                //
                // service demo
                //

                LOGGER.info("baobao--baifa: {}", baoBaoService.calcBaiFa());
                LOGGER.info("baobao--yuerbao: {}", baoBaoService.calcYuErBao());

                Thread.sleep(5000);

                LOGGER.info(MessageFormat.format("redis( {0} , {1,number,#} ) get key : {2}", jedisConfig.getHost(),
                        jedisConfig.getPort(), REDIS_KEY));

                LOGGER.info("redis( {} , {} )", jedisConfig.getHost(), jedisConfig.getPort());

                LOGGER.info("code config: {}", codeConfig.getCodeError());

                //
                // xml demo
                //

                LOGGER.info("autoservice: {}", autoService.getAuto());

                LOGGER.info("autoservice2: {}", autoService2.getAuto2());

                //
                // static config demo
                //
                LOGGER.info("static file data: {}", SimpleStaticService.getStaticFileData());

                LOGGER.info("static item data: {}", SimpleStaticService.getStaticItem());

                //
                // 动态的写法
                //
                LOGGER.info(DisconfDataGetter.getByFile("local_config/redis.properties").toString());
                LOGGER.info(DisconfDataGetter.getByFile("local_config/autoconfig.properties").toString());
                if (DisconfDataGetter.getByFile("local_config/autoconfig.properties").containsKey("auto")) {
                    LOGGER.info(DisconfDataGetter.getByFile("local_config/autoconfig.properties").get("auto").toString());
                }
                if (DisconfDataGetter.getByFileItem("local_config/autoconfig.properties", "auto") != null) {
                    LOGGER.info(DisconfDataGetter.getByFileItem("local_config/autoconfig.properties", "auto").toString());
                }
                LOGGER.info(DisconfDataGetter.getByItem("moneyInvest").toString());

                LOGGER.info("get bean @value : {}", autoConfig.getAuto());
            }

        } catch (Exception e) {

            LOGGER.error(e.toString(), e);
        }

        return 0;
    }
}
