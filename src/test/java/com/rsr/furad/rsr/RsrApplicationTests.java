package com.rsr.furad.rsr;

import com.rsr.furad.util.RSAUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.Map;

@SpringBootTest
class RsrApplicationTests {

    @Test
    public void exportKeys() throws Exception {
        Map<String, Object> keyMap = RSAUtils.genKeyPair();
        //公钥
        String publicKey = RSAUtils.getPublicKey(keyMap);
        //私钥
        String privateKey = RSAUtils.getPrivateKey(keyMap);
        System.out.println("公钥：" + publicKey);
        System.out.println("私钥：" + privateKey);
    }

    @Test
    public void testDecryptEncrypt() throws Exception {
        // 公钥 可以放指定位置
        String publicKeyStr = FileUtils.readFileToString(new File("/data3/pem/publickey.pem"),"UTF-8");
        String privateKeyStr = FileUtils.readFileToString(new File("/data3/pem/privatekey.pem"),"UTF-8");
        String sign = "dasdasdasdasdasd";
        byte[] encryptSign = RSAUtils.encryptByPublicKey(sign.getBytes(),publicKeyStr);
        String base64Sign = Base64.encodeBase64String(encryptSign);
        System.out.println("加密后的sign: "+base64Sign);
        //私钥解密
        byte[] decryptStr = RSAUtils.decryptByPrivateKey(Base64.decodeBase64(base64Sign),privateKeyStr);
        System.out.println("解密后的sign: "+new String(decryptStr));
    }



}
