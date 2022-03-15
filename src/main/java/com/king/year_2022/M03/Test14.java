package com.king.year_2022.M03;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @program: leetcode_diary
 * @description: 599. 两个列表的最小索引总和
 * @author: King
 * @create: 2022-03-14 23:37
 */
public class Test14 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        return IntStream.range(0, list1.length + list2.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> i < list1.length ? list1[i] : list2[i - list1.length]))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 2)
                .collect(Collectors.groupingBy(entry -> entry.getValue().get(0) + entry.getValue().get(1), TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .values()
                .iterator()
                .next()
                .toArray(new String[0]);
    }

    public static void main(String[] args) {

    }
}
