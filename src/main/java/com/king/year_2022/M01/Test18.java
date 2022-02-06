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
        //给我你的目录文件夹路径
        String filepath = "F:\\A";
        File file = new File(filepath);
        Map<String, String> map = new HashMap<>();
        map.put("要修改的内容1", "修改的内容1");
        map.put("要修改的内容2;", "要修改的内容1");
        new Test18(map).refreshFileList(file);

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

    public void refreshFileList(String filepath) {
        refreshFileList(new File(filepath));
    }

    public void refreshFileList(File filepath) {
        if (!filepath.exists()) {
            System.out.println("此路径不存在");
            return;
        }
        File[] fileList = filepath.listFiles();
        if (fileList == null || fileList.length < 1) {
            System.out.println("空文件夹");
            return;
        }
        for (File file : fileList) {
            if (file.isDirectory()) {
                //如果是文件夹递归扫描
                refreshFileList(file);
            } else {
                String filename = file.getName();//读到的文件名
                String strFileName = file.getAbsolutePath();//文件路径
                //截取文件格式
                String SufName = filename.substring(filename.lastIndexOf(".") + 1);
                //排除不需要扫描的文件
//                if (SufName.equals("rar") || SufName.equals("jpg") || SufName.equals("png") || SufName.equals("jar") || SufName.equals("doc") || SufName.equals("xls") || SufName.equals("gif") || SufName.equals("wmz")) {
//                    continue;
//                }
                //或者指定扫描文件
                if (SufName.equalsIgnoreCase("html") || SufName.equalsIgnoreCase("java")) {
                    changeFile(file);
                }
            }
        }
    }

    /**
     * 修改文件
     *
     * @param file
     */
    private void changeFile(File file) {
        String s = null;
        try (FileInputStream fis = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis));) {

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
                if (s.contains(mapKey.getKey())) { //判断当前行是否存在想要替换掉的字符
                    s = s.replace(mapKey.getKey(), mapKey.getValue());//替换为你想替换的内容
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        writerFile(s, file);

    }

    /**
     * 写入文件
     * @param s
     * @param file
     */
    public void writerFile(String s, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(s.getBytes());
            System.out.println("文件修改成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件修改失败！");
        }
    }

}
//
//
//    public String getFileCharsetName(File file) {
//        String charsetName = "GBK";//或GB2312，即ANSI
//        try (InputStream inputStream = new FileInputStream(file)) {
//            byte[] head = new byte[3];
//            inputStream.read(head);
//            if (head[0] == -1 && head[1] == -2) //0xFFFE
//                charsetName = "UTF-16";
//            else if (head[0] == -2 && head[1] == -1) //0xFEFF
//                charsetName = "Unicode";//包含两种编码格式：UCS2-Big-Endian和UCS2-Little-Endian
//            else if (head[0] == -27 && head[1] == -101 && head[2] == -98)
//                charsetName = "UTF-8"; //UTF-8(不含BOM)
//            else if (head[0] == -17 && head[1] == -69 && head[2] == -65)
//                charsetName = "UTF-8"; //UTF-8-BOM
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return charsetName;
//    }
//
//    /**
//     * 判断文件的编码格式
//     *
//     * @param file :file
//     * @return 文件编码格式
//     * @throws Exception
//     */
//    public static String codeString(File file) {
//
//        if (!file.exists()) {
//            System.out.println("文件不存在..." + file.getAbsolutePath());
//            return null;
//        }
//        String code = null;
//        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));) {
//            int p = (bin.read() << 8) + bin.read();
//
//            //其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
//            switch (p) {
//                case 0xefbb:
//                    code = "UTF-8";
//                    break;
//                case 0xfffe:
//                    code = "Unicode";
//                    break;
//                case 0xfeff:
//                    code = "UTF-16BE";
//                    break;
//                case 0x5c75:
//                    code = "ANSI|ASCII";
//                    break;
//                default:
//                    code = "GBK";
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return code;
//    }
