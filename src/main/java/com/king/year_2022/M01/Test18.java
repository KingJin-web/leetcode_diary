package com.king.year_2022.M01;

import com.king.util.MyPrint;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetcode_diary
 * @description:
 * @author: King
 * @create: 2022-01-18 11:06
 */
public class Test18 {
    private Map<String, String> map = new HashMap<>();

    public Test18() {
    }

    public Test18(Map<String, String> map) {
        this.map = map;
    }

    public static void main(String[] args) {



        //读取指定文件夹下的所有文件
        String filepath = "H:\\Downloads\\XFTV16.0\\Website\\Zz_www.zw3e.com";//给我你的目录文件夹路径
        File file = new File(filepath);
        Map<String, String> map = new HashMap<>();
//        map.put("一个已被访问超过<font color=\"red\">13,000,000</font>次的植物之家，每天超过<font color=\"red\">200,000</font>","");
//        map.put("<p>植物之家备案号： <a href=\"javascript:;\" rel=\"nofollow\" target=\"_blank\">陕ICP备09018639号-8</a>","<p>植物之家备案号： <a href=\"https://icp.chinaz.com/home/info?host=wuzhaoqi.top;\" rel=\"nofollow\" target=\"_blank\">湘ICP备2020019542号</a>");
//        map.put("植物之家备案号","花草信息网备案号");
//        map.put("static/picture/za.jpg","static/image/headerbj.jpg");
//        map.put("粤ICP备14009184号-2","湘ICP备2020019542号");
        map.put("https://icp.chinaz.com/home/info?host=wuzhaoqi.top","https://beian.miit.gov.cn/");
        map.put("https://beian.miit.gov.cn/;","https://beian.miit.gov.cn/");
        new Test18(map).refreshFileList(filepath);

//        if (!file.isDirectory()) {
//            System.out.println("请输入一个目录文件路径");
//        } else if (file.isDirectory()) {
//            try {
//                refreshFileList(filepath);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void refreshFileList(String filepath) {
        File files = new File(filepath);
        File[] filelist = files.listFiles();
        if (filelist == null)
            return;
        for (File file : filelist) {
            if (file.isDirectory()) {
                refreshFileList(file.getAbsolutePath());
            } else {
                String filename = files.getName();//读到的文件名
                String strFileName = file.getAbsolutePath().toLowerCase();
                String FileNamePath = strFileName.substring(6, strFileName.length());
                //截取文件格式
                String SufName = strFileName.substring(strFileName.lastIndexOf(".") + 1, strFileName.length());
                //排除不需要扫描的文件
//                if (SufName.equals("rar") || SufName.equals("jpg") || SufName.equals("png") || SufName.equals("jar") || SufName.equals("doc") || SufName.equals("xls") || SufName.equals("gif") || SufName.equals("wmz")) {
//                    continue;
//                }

                //或者指定扫描文件
                if (SufName.equalsIgnoreCase("html")) {
                    changeFile(file);
                }
                // MyPrint.printObs(filelist, strFileName, filename, FileNamePath);
            }
        }
    }

    private void changeFile(File file) {
        String enCode = getFileCharsetName(file.getAbsolutePath());
        System.out.println(enCode);
        String s = null;

        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedReader reader = new BufferedReader(new InputStreamReader(bis));) {

            //之所以用BufferedReader,而不是直接用BufferedInputStream读取,是因为BufferedInputStream是InputStream的间接子类,
            //InputStream的read方法读取的是一个byte,而一个中文占两个byte,所以可能会出现读到半个汉字的情况,就是乱码.
            //BufferedReader继承自Reader,该类的read方法读取的是char,所以无论如何不会出现读个半个汉字的.
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append((char) reader.read());
            }
            s = result.toString();
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> mapKey : entries) {
                if (s.contains(mapKey.getKey())) { //判断当前行是否存在想要替换掉的字符 -1表示存在
                    s = s.replace(mapKey.getKey(), mapKey.getValue());//替换为你想替换的内容
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //   System.out.println(s);

        assert s != null;
        writerFile(s, file);

    }

    private void writerFile(String s, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             // 构建FileOutputStream对象,文件不存在会自动新建
             BufferedOutputStream bos = new BufferedOutputStream(fos);) {
            bos.write(s.getBytes());
            System.out.println("文件修改成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件修改失败！");
        }
    }


    public String getFileCharsetName(String fileName) {
        String charsetName = "GBK";//或GB2312，即ANSI
        try (InputStream inputStream = new FileInputStream(fileName);) {

            byte[] head = new byte[3];
            inputStream.read(head);
            if (head[0] == -1 && head[1] == -2) //0xFFFE
                charsetName = "UTF-16";
            else if (head[0] == -2 && head[1] == -1) //0xFEFF
                charsetName = "Unicode";//包含两种编码格式：UCS2-Big-Endian和UCS2-Little-Endian
            else if (head[0] == -27 && head[1] == -101 && head[2] == -98)
                charsetName = "UTF-8"; //UTF-8(不含BOM)
            else if (head[0] == -17 && head[1] == -69 && head[2] == -65)
                charsetName = "UTF-8"; //UTF-8-BOM


        } catch (IOException e) {
            e.printStackTrace();
        }
        return charsetName;
    }
}


