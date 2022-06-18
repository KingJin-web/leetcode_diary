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

        //��ȡָ���ļ����µ������ļ�

        String filepath = "F:\\A";
        //�������Ŀ¼�ļ���·��
        //"H:\\Downloads\\XFTV16.0\\Website\\Zz_www.zw3e.com";
        File file = new File(filepath);
        Map<String, String> map = new HashMap<>();
        map.put("Ҫ�޸ĵ�����1", "�޸ĵ�����1");
        map.put("Ҫ�޸ĵ�����2;", "Ҫ�޸ĵ�����1");
        new Test18(map).refreshFileList(file);

//        if (!file.isDirectory()) {
//            System.out.println("������һ��Ŀ¼�ļ�·��");
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
            System.out.println("��·��������");
            return;
        }
        File[] fileList = filepath.listFiles();
        if (fileList == null || fileList.length < 1) {
            System.out.println("���ļ���");
            return;
        }
        for (File file : fileList) {
            if (file.isDirectory()) {
                //������ļ��еݹ�ɨ��
                refreshFileList(file);
            } else {
                String filename = file.getName();//�������ļ���
                String strFileName = file.getAbsolutePath();//�ļ�·��
                //��ȡ�ļ���ʽ
                String SufName = filename.substring(filename.lastIndexOf(".") + 1);
                //�ų�����Ҫɨ����ļ�
//                if (SufName.equals("rar") || SufName.equals("jpg") || SufName.equals("png") || SufName.equals("jar") || SufName.equals("doc") || SufName.equals("xls") || SufName.equals("gif") || SufName.equals("wmz")) {
//                    continue;
//                }
                //����ָ��ɨ���ļ�
                if (SufName.equalsIgnoreCase("html") || SufName.equalsIgnoreCase("java")) {
                    changeFile(file);
                }
            }
        }
    }

    /**
     * �޸��ļ�
     *
     * @param file
     */
    private void changeFile(File file) {
        String s = null;
        try (FileInputStream fis = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis));) {

            //֮������BufferedReader,������ֱ����BufferedInputStream��ȡ,����ΪBufferedInputStream��InputStream�ļ������,
            //InputStream��read������ȡ����һ��byte,��һ������ռ����byte,���Կ��ܻ���ֶ���������ֵ����,��������.
            //BufferedReader�̳���Reader,�����read������ȡ����char,����������β�����ֶ���������ֵ�.
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append((char) reader.read());
            }
            s = result.toString();
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> mapKey : entries) {
                if (s.contains(mapKey.getKey())) { //�жϵ�ǰ���Ƿ������Ҫ�滻�����ַ�
                    s = s.replace(mapKey.getKey(), mapKey.getValue());//�滻Ϊ�����滻������
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        writerFile(s, file);

    }

    /**
     * д���ļ�
     * @param s
     * @param file
     */
    public void writerFile(String s, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(s.getBytes());
            System.out.println("�ļ��޸ĳɹ���");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("�ļ��޸�ʧ�ܣ�");
        }
    }

}
//
//
//    public String getFileCharsetName(File file) {
//        String charsetName = "GBK";//��GB2312����ANSI
//        try (InputStream inputStream = new FileInputStream(file)) {
//            byte[] head = new byte[3];
//            inputStream.read(head);
//            if (head[0] == -1 && head[1] == -2) //0xFFFE
//                charsetName = "UTF-16";
//            else if (head[0] == -2 && head[1] == -1) //0xFEFF
//                charsetName = "Unicode";//�������ֱ����ʽ��UCS2-Big-Endian��UCS2-Little-Endian
//            else if (head[0] == -27 && head[1] == -101 && head[2] == -98)
//                charsetName = "UTF-8"; //UTF-8(����BOM)
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
//     * �ж��ļ��ı����ʽ
//     *
//     * @param file :file
//     * @return �ļ������ʽ
//     * @throws Exception
//     */
//    public static String codeString(File file) {
//
//        if (!file.exists()) {
//            System.out.println("�ļ�������..." + file.getAbsolutePath());
//            return null;
//        }
//        String code = null;
//        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));) {
//            int p = (bin.read() << 8) + bin.read();
//
//            //���е� 0xefbb��0xfffe��0xfeff��0x5c75��Щ��������ļ���ǰ�������ֽڵ�16������
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
