package com.sunny.lms.utils;

import cn.hutool.core.date.DateUtil;

import com.sunny.lms.entity.User;
import com.sunny.lms.mapper.UserMapper;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import javax.annotation.PostConstruct;
import java.util.Date;
/***
 *
 * @author SUNNY
 * @description 登录拦截类
 * @date 2023-03-09 11:07:16
 */
@Slf4j
@Component
public class TokenUtils {

    @Autowired
    private UserMapper userMapper;

    private static UserMapper staticUserMapper;

    @PostConstruct
    public void init() {
        staticUserMapper = userMapper;
    }

    /**
     * 生成token
     * @param user
     * @return jwt
     */
   // Generate a token for the given user
    public static String genToken(User user) {
        // Create a JWT token with an expiration date of 1 day from the current date
        return JWT.create().withExpiresAt(DateUtil.offsetDay(new Date(), 1)).withAudience(user.getId().toString())
                // Sign the token using the user's password as the secret
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
    /**
     * 获取token中的用户信息
     * @return
     */

public static User getUser() {
        try {
            //Get the request attributes from the RequestContextHolder
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //Get the token from the request header
            String token = request.getHeader("token");
            //Decode the token and get the audience
            String aud = JWT.decode(token).getAudience().get(0);
            //Convert the audience to an integer
            Integer userId = Integer.valueOf(aud);
            //Return the user object based on the userId
            return staticUserMapper.selectById(userId);
        } catch (Exception e) {
            log.error("解析token失败", e);
            return null;
        }
    }
}
