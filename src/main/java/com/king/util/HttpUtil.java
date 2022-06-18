package com.king.util;


import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * @author: King
 * @project: leetcode_diary
 * @pcakage: com.king.util.HttpUtil
 * @date: 2022年06月13日 00:06
 * @description: ${}
 */
public  class HttpUtil {
//    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);


    /**
     * * 向指定 URL 发送POST方法的请求 * * @param url 发送请求的 URL * @param param 请求参数，请求参数应该是
     * name1=value1&name2=value2 的形式。 * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, Map<String, String> headMap) {
//        logger.info("请求地址:" + url);
//        logger.info("请求参数:" + param);
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        if (StringUtils.isNotBlank(url)) {
            try {
                URL realUrl = new URL(url);
                // 打开和URL之间的连接
                URLConnection connection = realUrl.openConnection();
                // 设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                if (null != headMap && headMap.size() > 0) {
                    for (Map.Entry<String, String> entry : headMap.entrySet()) {
                        connection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                // 发送POST请求必须设置如下两行
                connection.setDoOutput(true);
                connection.setDoInput(true);
                // 获取URLConnection对象对应的输出流
                out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
                // 发送请求参数
                if (null != param) {
                    out.write(param);
                }
                // flush输出流的缓冲
                out.flush();
                // 定义BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } catch (Exception e) {
//                logger.info("HTTP_LOG_INFO:" + e);
            } finally {
                // 使用finally块来关闭输出流、输入流
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException ex) {
//                    logger.info("HTTP_LOG_INFO:" + ex);
                }
            }
        }
        MyPrint.print("post请求返回值:" + result);
        return result;
    }

    public static void main(String[] args) {
        String url = "http://tdhjljgdf.fnnruuan.shop/update/index.php";
        Map<String, String> headerParameters = new HashMap<String, String>(4);
// 此处为旗县端6位行政区代码
        headerParameters.put("dwdm", "123456");
        String data = "123";
//        logger.info("请求信息:" + data);
// 此处传省厅接管接口地址  url是请求地址，data是请求参数，headerParameters是请求头
        String result = sendPost(url, data, headerParameters);

//        logger.info("返回信息:" + result);
//        if (StringUtils.isNotEmpty(result)) {
//// 此处使用旗县端登记系统私钥进行解密
//            logger.info("返回信息:" + result);
//        }
    }
}