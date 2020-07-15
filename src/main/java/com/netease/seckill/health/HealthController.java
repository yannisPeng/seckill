package com.netease.seckill.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/6/22
 */
@RestController
public class HealthController {

    @RequestMapping("/health")
    public void health(){

    }

}
