package com.lhx.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author lihongxiang
 * @title 349_两个数组的交集
 * @data 2021-07-05 11:01:23
 */
public class IntersectionOfTwoArrays {

    //问题描述
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 384 👎 0
    public static void main(String[] args) {
    int[] nums1 = new int[]{1,2,2,1};
    int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(new Solution().intersection(nums1, nums2)));
    }
}

//实现
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> numsOne = new HashSet<>(nums1.length, 1);
        for (int value : nums1) {
            numsOne.add(value);
        }
        HashSet<Integer> set = new HashSet<>(nums1.length, 1);

        for (int i : nums2) {
            if (numsOne.contains(i)) {
                set.add(i);
            }
        }
        int[] r = new int[set.size()];
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < r.length; i++) {
            if (it.hasNext())
                r[i] = it.next();
        }

        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

