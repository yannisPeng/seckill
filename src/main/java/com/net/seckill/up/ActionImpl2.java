package com.net.seckill.up;

import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/12
 */
@Service
public class ActionImpl2 implements Action {
    @Override
    public void payMoney(Money money) {
        System.out.println("付钱");
    }
}
