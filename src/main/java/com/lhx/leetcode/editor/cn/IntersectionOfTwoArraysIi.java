package com.lhx.leetcode.editor.cn;

import java.util.*;

/**
 * @author lihongxiang
 * @title 350_两个数组的交集 II
 * @data 2021-07-05 13:42:13
 */
public class IntersectionOfTwoArraysIi {

//问题描述
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 512 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            Map<Integer, Integer> map = new HashMap<>(nums1.length, 1);
            for (int value : nums1) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            int[] intersection = new int[nums1.length];
            int index = 0;
            for (int i : nums2) {
                int count = map.getOrDefault(i, 0);
                if (count > 0) {
                    intersection[index++] = i;
                    count--;
                    if (count > 0) {
                        map.put(i, count);
                    } else {
                        map.remove(i);
                    }
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysIi().new Solution().intersect(nums1, nums2)));
    }
}