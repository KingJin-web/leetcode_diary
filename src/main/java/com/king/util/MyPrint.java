package com.king.util;

import java.lang.reflect.*;
import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: King
 * @create: 2021-09-04 11:26
 */
public class MyPrint {

    /**
     * ���ܴ�ӡ
     *
     * @param o
     */
    public static void printObs(Object... o) {
        System.out.println(o[0].getClass().getSimpleName());
        print(o);
    }


    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(List... os) {
        for (Object o : os) {
            print(o);
        }
    }


    public static void printf(Object o) {
        System.out.print(o);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    //���һ������
    public static void print() {
        printf('\n');
    }

    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     * //�Լ���װ�����������ֱ�Ӵ�ӡ���飬list��Iterator��
     *
     * @param o
     */
    public static void print(Object o) {

        if (o == null) {
            print("null");
            return;
        }
//        System.out.println(o.getClass().getSimpleName());
        if (o.getClass().getSimpleName().contains("[][]")) {
            System.out.println(Arrays.deepToString((Object[]) o));
        } else if (isArray(o)) {
            List<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                if (isArray(value)) {
                    print(value);
                } else {
                    coll.add(value);
                }
            }

            if (!coll.isEmpty()) {
                print(toString(coll.toArray()));
            }

        } else if (o instanceof List) {
            List list = (List) o;
            print("=========list-start=========");
            if (list.size() <= 0) {
                print("null");
                return;
            }
            if (!isArray(list.get(0))) {
                if (list.get(0) instanceof Number || list.get(0) instanceof String) {
                    print(toString(list.toArray()));
                } else {
                    list.forEach(MyPrint::println);
                }
            } else {
                for (Object o1 : list) {
                    int length = Array.getLength(o1);
                    List<Object> coll = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        Object value = Array.get(o1, i);
                        coll.add(value);
                    }
                    print(toString(coll.toArray()));
                }
            }
            print("=========list-end=========");
        } else if (o instanceof Iterator) {
            Iterator<?> iterator = ((Iterator<?>) o);

            List<Object> list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            print(list.toArray());
        } else {
            System.out.println(o);
        }

    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void printIsLn(Object o) {
        print(o, true);
        print();
    }

    //    print(MyPrint.class);
    public static void print(Class<?> c) {
        println(c);
        if (c.isArray()) {
            println("isArray");
        }
        if (c.isInterface()) {
            println("isInterface");
        }


        try {
            // ���ݴ�������ȫ��������Class����,ע�������ȫ��

            // �õ���·��
            System.out.println("package " + c.getPackage().getName() + ";\n");
            // �õ������η�
            System.out.print(Modifier.toString(c.getModifiers()));
            //�õ�����
            System.out.print(" class " + c.getSimpleName());
            //�õ�������
            System.out.print(" extends " + c.getSuperclass().getSimpleName());
            //�õ���ʵ�ֵĽӿ�����
            Class[] inters = c.getInterfaces();
            if (inters.length > 0) {
                System.out.print(" implements ");
                for (int i = 0; i < inters.length; i++) {
                    System.out.print(inters[i].getSimpleName());
                    if (i < inters.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(" {");
            // ��ȡ������
            printField(c);
            // ��ȡ�๹����
            printConstructor(c);
            // ��ȡ�෽��
            printMethods(c);
            System.out.println(" }");

        } catch (Exception e) {
            e.printStackTrace();
        }


//        Field[] fields = c.getFields();
//        print(fields.length);
//        Method[] methods1 = c.getMethods();
//        print(methods1, 1);
//        print();
//        Method[] methods2 = c.getDeclaredMethods();
//        print(methods2, 1);
    }


    /**
     * https://www.cnblogs.com/fjdingsd/p/5272242.html
     *
     * @param o
     */
    public static void print(Object o, boolean b) {

        if (isArray(o)) {
            List<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                if (isArray(value)) {
                    print(value, true);
                } else {
                    coll.add(value);
                }
            }
            if (!coll.isEmpty()) {
                print(coll, true);
            }
        } else if (getType(o).contains("List")) {
            List list = (List) o;
            print("[", false);
            for (Object object : list) {
                print(object, false);
            }
            print("]", false);
        } else {
            if (b) {
                System.out.println(o);
            } else {
                System.out.print(o);
            }
        }

    }
//    public static void print(int[]... s) {
//        print(Arrays.deepToString(s));
//    }

    public static void print(Object o, int n) {
        if (isArray(o)) {
            Collection<Object> coll = new ArrayList<>();
            int length = Array.getLength(o);
            for (int i = 0; i < length; i++) {
                Object value = Array.get(o, i);
                coll.add(value);
            }
            print(toString(coll.toArray(), n));
        } else {
            print("�ⲻ������ !");
            print(o);
        }
    }

    public static void print(Object[] o, int l) {
        if (o.length <= 0) {
            print("null");
            return;
        }
        if (o.length == 1) {
            print(o[0]);
            return;
        }
        for (int i = 1; i < o.length; ++i) {
            System.out.print(o[i - 1] + ", ");
            if (i % l == 0) {
                print();
            }
        }
        System.out.println(o[o.length - 1]);

    }

    public static String toString(Object[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public static void printA(int[][] a) {
        print(Arrays.deepToString(a));
    }

    public static void println(int... objects) {
        print(objects);
    }

    public static void print(Object[]... o) {
        print(Arrays.deepToString(o));
    }


    public static void print(String[]... s) {
        print(Arrays.deepToString(s));
    }

    public static void print(char[]... chars) {
        print(Arrays.deepToString(chars));
    }

//    public static void print(List<List<Integer>> o) {
//        o.forEach(MyPrint::print);
//    }

    public static void printList(List list) {


        for (Object o : list) {
            if (o instanceof List) {
                printList((List) o);
            } else {
                System.out.print(o + " ");
            }
        }
        System.out.println();
    }

    /**
     * �����Ƿ�Ϊ�������
     *����
     * @param obj ����
     * @return �Ƿ�Ϊ����������Ϊ{@code null} ���ؿ�ָ��
     */
//    public static boolean isType(Object obj,Class type) {
//        if (null == obj) {
//            throw new NullPointerException("Object is null");
//        }
//        return obj instanceof type;
//    }

    /**
     * �����Ƿ�Ϊ�������
     *
     * @param obj ����
     * @return �Ƿ�Ϊ����������Ϊ{@code null} ���ؿ�ָ��
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            //throw new NullPointerException("Object check for isArray is null");
            print("null");
        }
//        ���� �������
        return obj.getClass().isArray();
    }


    /**
     * �����ҳ
     *
     * @param o ����
     * @param l ÿҳ������
     * @return
     */
    private static String toString(Object[] o, int l) {
        if (o == null)
            return "null";
        int iMax = o.length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append("[ ");
        for (int i = 1; i < o.length; ++i) {

            b.append(String.format("%-5s ", o[i - 1]));
            if (i % l == 0) {
                b.append("]\n[ ");
            }

        }
        b.append(o[iMax]).append(" ]\n");

        return b.toString();
    }

    /**
     * ��ȡ������������
     *
     * @param o
     * @return
     */
    public static String getType(Object o) {
        return o.getClass().getSimpleName();
    }

    public static void printError(String message) {
        System.err.println(message);
    }

    public static void printf(int... nums) {
        print(nums);
    }

//    public static void main(String[] args) {
//        Class c = null;
//        try {
//            // ���ݴ�������ȫ��������Class����,ע�������ȫ��
//            c = Class.forName("test.Person");
//            // �õ���·��
//            System.out.println("package " + c.getPackage().getName() + ";\n");
//            // �õ������η�
//            System.out.print(Modifier.toString(c.getModifiers()));
//            //�õ�����
//            System.out.print(" class " + c.getSimpleName());
//            //�õ�������
//            System.out.print(" extends " + c.getSuperclass().getSimpleName());
//            //�õ���ʵ�ֵĽӿ�����
//            Class[] inters = c.getInterfaces();
//            if (inters.length > 0) {
//                System.out.print(" implements ");
//                for (int i = 0; i < inters.length; i++) {
//                    System.out.print(inters[i].getSimpleName());
//                    if (i < inters.length - 1) {
//                        System.out.print(", ");
//                    }
//                }
//            }
//            System.out.println(" {");
//            // ��ȡ������
//            printField(c);
//            // ��ȡ�๹����
//            printConstructor(c);
//            // ��ȡ�෽��
//            printMethods(c);
//            System.out.println(" }");
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    private static void printConstructor(Class c) {
        Constructor[] cs = c.getConstructors();
        for (int i = 0; i < cs.length; i++) {
            System.out.println();
            System.out.print("\t");
            // �õ�������ʽ���캯�����η���ʹ��Modifier���н���
            System.out.print(Modifier.toString(cs[i].getModifiers()) + " ");
            // �õ�������
            System.out.print(cs[i].getName() + "(");
            // �õ�������������
            Class[] paras = cs[i].getParameterTypes();
            for (int j = 0; j < paras.length; j++) {
                System.out.print(paras[j].getSimpleName() + " arg" + j);
                if (j < paras.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");
            System.out.println(" {");
            System.out.println("\t\t\\\\������");
            System.out.println("\t}");
        }
    }

    private static void printField(Class c) {
        // �õ���������
        Field[] fs = c.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            System.out.print("\t");
            // �õ�������ʽ�������η���ʹ��Modifier���н���
            System.out.print(Modifier.toString(fs[i].getModifiers()) + " ");
            // �õ���������
            System.out.print(fs[i].getType().getSimpleName() + " ");
            // �õ�������
            System.out.println(fs[i].getName() + ";");
        }
    }

    public static void printMethods(Class c) {
        // �õ���������
        Method[] md = c.getMethods();
        for (int i = 0; i < md.length; i++) {
            System.out.println();
            System.out.print("\t");
            // �õ�������ʽ�������η���ʹ��Modifier���н���
            System.out.print(Modifier.toString(md[i].getModifiers()) + " ");
            // �õ�������������
            System.out.print(md[i].getGenericReturnType() + " ");
            // �õ�������
            System.out.print(md[i].getName() + "(");
            // �õ�������������
            Class[] paras = md[i].getParameterTypes();
            for (int j = 0; j < paras.length; j++) {
                System.out.print(paras[j].getSimpleName() + " arg" + j);
                if (j < paras.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");
            // �õ��׳����쳣������
            Class[] exceps = md[i].getExceptionTypes();
            if (exceps.length > 0) {
                System.out.print(" throws ");
                for (int k = 0; k < exceps.length; k++) {
                    System.out.print(exceps[k].getSimpleName());
                    if (k < exceps.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(" {");
            System.out.println("\t\t\\\\������");
            System.out.println("\t}");
        }
    }
}
