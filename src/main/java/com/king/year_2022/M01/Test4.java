package com.king.year_2022.M01;

import com.king.util.LeetcodeUtil;
import com.king.util.MyPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode_diary
 * @description: 1389. 按既定顺序创建目标数组
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-target-array-in-the-given-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: King
 * @create: 2022-01-04 02:36
 */
public class Test4 {
    //给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
    //
    //目标数组 target 最初为空。
    //按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
    //重复上一步，直到在 nums 和 index 中都没有要读取的元素。
    //请你返回目标数组。
    //
    //题目保证数字插入位置总是存在。

    //输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
    //输出：[0,4,1,3,2]
    //解释：
    //nums       index     target
    //0            0        [0]
    //1            1        [0,1]
    //2            2        [0,1,2]
    //3            2        [0,1,3,2]
    //4            1        [0,4,1,3,2]
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < nums.length;++i){
            list.add(index[i],nums[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        MyPrint.print(test4.createTargetArray(LeetcodeUtil.stringToIntegerArray("[0,1,2,3,4]"),
                LeetcodeUtil.stringToIntegerArray("[0,1,2,2,1]")));
    }
}
