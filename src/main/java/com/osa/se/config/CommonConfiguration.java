package com.osa.se.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

/**
 * Created by tarinidash on 3/2/17.
 */
@Configuration
@Slf4j
public class CommonConfiguration {

    @Profile("default")
    @Bean(name = "h2Webserver", initMethod = "start", destroyMethod = "stop")
    public Server h2Webserver() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
    }

    @Profile("default")
    @Bean(name = "h2Tcpserver", initMethod = "start", destroyMethod = "stop")
    @DependsOn("h2Webserver")
    public Server h2Tcpserver() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9082");
    }

}
