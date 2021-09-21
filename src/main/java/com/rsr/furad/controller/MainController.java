package com.rsr.furad.controller;


import com.rsr.furad.util.Getkey;
import com.rsr.furad.util.JsonMsg;
import com.rsr.furad.util.RSAUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @author 13375
 */
@Controller
public class MainController {

    @Autowired
    private Getkey getKey;


    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/toLogin")
    @ResponseBody
    public JsonMsg toLogin(HttpServletRequest req, HttpServletResponse resp, Integer index) {
        String userName = req.getParameter("account");
        String userPwd = req.getParameter("pswd");

        try {
            userPwd = new String(RSAUtils.decryptByPrivateKey(Base64.decodeBase64(userPwd), getKey.getPrivateKey(index)));
            System.err.println(userPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonMsg jm = new JsonMsg();
        return jm;

    }


    @PostMapping("/getPublicKey")
    @ResponseBody
    public JsonMsg getPublicKey() {
        JsonMsg jm = new JsonMsg();
        Random rd = new Random();
        Integer index = rd.nextInt(5) + 1;
        String key = getKey.getPublicKey(index);
        if (null == key) {
            jm.setSuccess(false);
        } else {
            jm.setSuccess(true);
            jm.getMap().put("key", key);
            jm.getMap().put("index", index);
        }
        return jm;
    }

}
