package com.king.year_2022.M01;

import cn.hutool.http.Header;
import com.king.util.Helper;
import com.king.util.MyPrint;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: leetcode_diary
 * @description: 71. 简化路径
 * @author: King
 * @create: 2022-01-06 22:36
 */
public class Test6 {

    //执行用时： 3 ms , 在所有 Java 提交中击败了 92.76% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 44.08% 的用户
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
    //给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
    //在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；
    // 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
    // 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
    //
    //请注意，返回的 规范路径 必须遵循下述格式：
    //
    //始终以斜杠 '/' 开头。
    //两个目录名之间必须只有一个斜杠 '/' 。
    //最后一个目录名（如果存在）不能 以 '/' 结尾。
    //此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
    //返回简化后得到的 规范路径 。

    public static void main(String[] args) {
        //输入：path = "/home//foo/"
        //输出："/home/foo"
        //解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
        Test6 test6 = Helper.getYoursObj(Test6.class);

        MyPrint.print(test6.simplifyPath("/home//foo/"));
        MyPrint.print(test6.simplifyPath("/a/./b/../../c/"));
    }
}


