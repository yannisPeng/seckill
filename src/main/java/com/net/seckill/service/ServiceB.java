package com.net.seckill.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceB {

    private ServiceA serviceA;

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
