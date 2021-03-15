package com.net.seckill.up;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/12
 */
@Service
public class Test {

    @Autowired
    private Map<String, Action> actionList;

    @PostConstruct
    public void init(){
        System.out.println();
    }

    public static void main(String[] args) {

    }

}
