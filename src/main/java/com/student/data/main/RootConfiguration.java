package com.student.data.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import redis.clients.jedis.JedisShardInfo;

/**
 * @author amoldhekane
 * @since 13/12/15 10:57 AM
 * @version 1.1
 */

@Configuration
@ComponentScan(basePackages = {"com.student.data"})
@ServletComponentScan(basePackages = "com.student.data")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 172800)
@EnableJpaRepositories("com.student.data")
@EntityScan(basePackages = "com.student.data")
@EnableTransactionManagement
public class RootConfiguration {

    private static final Logger log = LoggerFactory.getLogger(RootConfiguration.class);

    @Value("${httpsession.redis.endpoint}")
    private String redisEndpoint;

    @Value("${httpsession.redis.port}")
    private Integer redisPort;

//    @Bean
//    @ConfigurationProperties(prefix = "myDataSource",ignoreUnknownFields=false)
//    public ComboPooledDataSource c3p0PooledDataSource()
//    {
//        return new ComboPooledDataSource();
//    }

    @Bean
    public JedisConnectionFactory connectionFactory() {

        log.info("Redis end point:{}  port:{}",redisEndpoint,redisPort);

        JedisShardInfo  info = new JedisShardInfo(redisEndpoint,redisPort);

        return new JedisConnectionFactory(info);
    }

    @Bean
    public  ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
