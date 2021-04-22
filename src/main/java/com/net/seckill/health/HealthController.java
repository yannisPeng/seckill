package com.net.seckill.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/6/22
 */
@RestController
public class HealthController {

    @RequestMapping("/health")
    public void health() throws SQLException {
        try {
            throw new SQLException();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

}
