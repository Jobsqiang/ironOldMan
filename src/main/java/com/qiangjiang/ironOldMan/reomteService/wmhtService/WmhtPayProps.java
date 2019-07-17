package com.qiangjiang.ironOldMan.reomteService.wmhtService;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pay.props.wmht")
public class WmhtPayProps {
    private String scanAddress;
    private String notifyAddress;
    private int expireTime;
    private String appId;
    private String mchId;
    private String mchKey;
}
