package com.spring.main;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by mint on 8/2/18.
 */

@Component
@ConfigurationProperties("test")
public class TestProperties {

    private String apple;

    private String peach;

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getPeach() {
        return peach;
    }

    public void setPeach(String peach) {
        this.peach = peach;
    }

    @Override
    public String toString() {
        return "apple:" + apple + "; peach:" + peach;
    }
}
