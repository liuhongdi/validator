package com.validator.demo.constant;

import java.util.Arrays;
import java.util.List;

/**
 * @desc:  常量
 * @author: liuhongdi
 * @date: 2020-07-01 11:15
*/
public class Constants {
    //APP_SECRET
    public static final String APP_SECRET = "30c722c6acc64306a88dd93a814c9f0a";
    public static final String APP_API_VERSION = "1.0";
    public static final String APP_VERSION_LIST = "1.0,2.0,3.0";

    //访问接口app的列表
    /*
    public static enum APP_ID {
        WAP,WEB,IOS,ANDROID,WXXCX,BDXCX
    }
    */
    //wxxcx:微信小程序
    //bdxcx:百度小程序
    public final static List APP_ID_LIST = Arrays.asList("WAP","WEB","IOS","ANDROID","WXXCX","BDXCX");

    public final static List IOS_VERSION_LIST = Arrays.asList("1.1","2.2");
    public final static List ANDROID_VERSION_LIST = Arrays.asList("1.0","2.0");
    public final static List WXXCX_VERSION_LIST = Arrays.asList("1.0","2.0");
    public final static List BDXCX_VERSION_LIST = Arrays.asList("1.0","2.0");
}
