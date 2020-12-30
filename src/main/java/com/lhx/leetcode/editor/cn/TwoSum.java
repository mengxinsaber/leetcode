package com.lhx.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihongxiang
 * @title 1_两数之和
 * @data 2020-12-30 10:12:04
 */
public class TwoSum {

//问题描述
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9919 👎 0


    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int l = nums.length;
            int i = 0;
            int n;
            Map<Integer, Integer> map = new HashMap<>(l);
            for (; i < l; i++) {
                n = target - nums[i];
                if (map.containsKey(n)) {
                    return new int[]{map.get(n), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}