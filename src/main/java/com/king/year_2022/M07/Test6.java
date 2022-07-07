package com.king.year_2022.M07;

import com.king.util.MyPrint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

/**
 * @author: King
 * @project: leetcode_diary
 * @date: 2022年07月06日 23:00
 * @description: 736. Lisp 语法解析
 */
public class Test6 {

    Map<String, Deque<Integer>> scope = new HashMap<String, Deque<Integer>>();

    int start = 0;

    public int evaluate(String expression) {
        return innerEvaluate(expression);
    }

    public int innerEvaluate(String expression) {
        if (expression.charAt(start) != '(') { // 非表达式，可能为：整数或变量
            if (Character.isLowerCase(expression.charAt(start))) {
                String var = parseVar(expression); // 变量
                return scope.get(var).peek();
            } else { // 整数
                return parseInt(expression);
            }
        }
        int ret;
        start++; // 移除左括号
        if (expression.charAt(start) == 'l') { // "let" 表达式
            start += 4; // 移除 "let "
            List<String> vars = new ArrayList<String>();
            while (true) {
                if (!Character.isLowerCase(expression.charAt(start))) {
                    ret = innerEvaluate(expression); // let 表达式的最后一个 expr 表达式的值
                    break;
                }
                String var = parseVar(expression);
                if (expression.charAt(start) == ')') {
                    ret = scope.get(var).peek(); // let 表达式的最后一个 expr 表达式的值
                    break;
                }
                vars.add(var);
                start++; // 移除空格
                int e = innerEvaluate(expression);
                scope.putIfAbsent(var, new ArrayDeque<Integer>());
                scope.get(var).push(e);
                start++; // 移除空格
            }
            for (String var : vars) {
                scope.get(var).pop(); // 清除当前作用域的变量
            }
        } else if (expression.charAt(start) == 'a') { // "add" 表达式
            start += 4; // 移除 "add "
            int e1 = innerEvaluate(expression);
            start++; // 移除空格
            int e2 = innerEvaluate(expression);
            ret = e1 + e2;
        } else { // "mult" 表达式
            start += 5; // 移除 "mult "
            int e1 = innerEvaluate(expression);
            start++; // 移除空格
            int e2 = innerEvaluate(expression);
            ret = e1 * e2;
        }
        start++; // 移除右括号
        return ret;
    }

    public int parseInt(String expression) { // 解析整数
        int n = expression.length();
        int ret = 0, sign = 1;
        if (expression.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        while (start < n && Character.isDigit(expression.charAt(start))) {
            ret = ret * 10 + (expression.charAt(start) - '0');
            start++;
        }
        return sign * ret;
    }

    public String parseVar(String expression) { // 解析变量
        int n = expression.length();
        StringBuffer ret = new StringBuffer();
        while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
            ret.append(expression.charAt(start));
            start++;
        }
        return ret.toString();
    }


//    public static void main(String[] args) {
//        Test6 test6 = new Test6();
//        MyPrint.print(test6.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
//
//
//
//    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String ur1 = "jdbc:mysql://127.0.0.1:3306/mooc?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
        String username = "root";
        String password = "aaaa";
        Connection conn = DriverManager.getConnection(ur1, username, password);
        System.out.println(conn);
        Statement stmt = conn.createStatement();
        String sql = "select * from user";
        stmt.execute(sql);
        while (stmt.getResultSet().next()) {
            System.out.println(stmt.getResultSet().getString("name"));
        }
        //打印结果集
        stmt.close();
//        String sql = "update ss set adress = \"兴国\" where id = 1";
//        Statement stmt = conn.createStatement();
//        int count = stmt.executeUpdate(sql);
//        System.out.println(count);
//        stmt.close();
        conn.close();
    }


}