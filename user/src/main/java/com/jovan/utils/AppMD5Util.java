package com.jovan.utils;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class AppMD5Util {

    public  String getMD5(String source){
        MessageDigest md5;
        StringBuilder sb=new StringBuilder();
        byte[] buf=source.getBytes();
        try{
            md5=MessageDigest.getInstance("MD5");
            md5.update(buf);
            byte[] data=md5.digest();
            for(byte b:data){
                sb.append(Integer.toHexString(b&0xff));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

   /* public static void main(String[] args)  {
        AppMD5Util appMD5Util = new AppMD5Util();
        String pwd =getMD5("123");
        System.out.println(pwd);
    }*/
}
