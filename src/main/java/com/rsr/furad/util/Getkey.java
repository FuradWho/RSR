package com.rsr.furad.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 13375
 */
@Component
public class Getkey {

    private static Map<Integer, String> publicMap;
    private static Map<Integer, String> privateMap;

    @Value("${public.key1}")
    private String publicKey1;
    @Value("${public.key2}")
    private String publicKey2;
    @Value("${public.key3}")
    private String publicKey3;
    @Value("${public.key4}")
    private String publicKey4;
    @Value("${public.key5}")
    private String publicKey5;

    @Value("${private.key1}")
    private String privateKey1;
    @Value("${private.key2}")
    private String privateKey2;
    @Value("${private.key3}")
    private String privateKey3;
    @Value("${private.key4}")
    private String privateKey4;
    @Value("${private.key5}")
    private String privateKey5;

    /**
     * 通过编号获取公钥
     *
     * @param i
     * @return
     */
    public String getPublicKey(Integer i) {
        if (publicMap == null) {
            initPublic();
        }
        return publicMap.get(i);
    }

    /**
     * 通过编号获取私钥
     *
     * @param i
     * @return
     */
    public String getPrivateKey(Integer i) {
        if (privateMap == null) {
            initPrivate();
        }
        return privateMap.get(i);
    }

    /**
     * 初始化公钥
     */
    private void initPublic() {
        publicMap = new HashMap<>();
        publicMap.put(1, publicKey1);
        publicMap.put(2, publicKey2);
        publicMap.put(3, publicKey3);
        publicMap.put(4, publicKey4);
        publicMap.put(5, publicKey5);
    }

    /**
     * 初始化私钥
     */
    private void initPrivate() {
        privateMap = new HashMap<>();
        privateMap.put(1, privateKey1);
        privateMap.put(2, privateKey2);
        privateMap.put(3, privateKey3);
        privateMap.put(4, privateKey4);
        privateMap.put(5, privateKey5);
    }

}
