package com.exercises.disconf.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by shanshouchen@weibangong.com on 2017/3/27.
 */
@Service
@DisconfFile(filename = "coefficients.properties")
public class Coefficients {

    public static final String key = "discountRate";

    @Value(value = "2.0d")
    private Double discount;

    private double baiFaCoe;

    private double yuErBaoCoe;

    /**
     * 阿里余额宝的系数, 分布式文件配置
     *
     * @return
     */
    @DisconfFileItem(name = "coe.baiFaCoe")
    public double getBaiFaCoe() {
        return baiFaCoe;
    }

    public void setBaiFaCoe(double baiFaCoe) {
        this.baiFaCoe = baiFaCoe;
    }

    /**
     * 百发的系数, 分布式文件配置
     *
     * @return
     */
    @DisconfFileItem(name = "coe.yuErBaoCoe")
    public double getYuErBaoCoe() {
        return yuErBaoCoe;
    }

    public void setYuErBaoCoe(double yuErBaoCoe) {
        this.yuErBaoCoe = yuErBaoCoe;
    }

    /**
     * 折扣率，分布式配置
     *
     * @return
     */
    @DisconfItem(key = key)
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }


}
