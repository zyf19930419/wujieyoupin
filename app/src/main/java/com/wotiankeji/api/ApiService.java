package com.wotiankeji.api;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/7/19 14:35
 * 功能描述：
 */
public interface ApiService {
    //     String OFFICIAL_WEB = "http://api.wujiemall.com/"; // 正式服务器
    //     String OFFICIAL_WEB = "http://fztest.wujiemall.com/"; // 测试库 打包发送
    //     String OFFICIAL_WEB = "http://dev.wujiemall.com/"; // 测试库 打包发送

    String OFFICIAL_WEB = "http://test.wujiemall.com/"; // 技术内部测试，不需要打包
    String BASE_URL = OFFICIAL_WEB + "index.php/Api/";
}
