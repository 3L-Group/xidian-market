package com.saturn.common.entity.po;

import com.saturn.common.entity.User;
import lombok.Data;

/**
 * @author: hly
 * @create: 2020-10-21 19:28
 **/
@Data
public class TokenPO {


    /**
     * token
     */
    private String token;

    /**
     * 用户id
     */
    private User user;

    public TokenPO(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
