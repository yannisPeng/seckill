package com.netease.seckill.service.impl;

import com.netease.seckill.service.TestInterface;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/14
 */
@Service
public class Test2 implements TestInterface {

    @Override
    public String doThings() {
        return "test2";
    }

}
