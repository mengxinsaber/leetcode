package com.lhx.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihongxiang
 * @title 888_公平的糖果棒交换
 * @data 2021-07-07 11:38:49
 */
public class FairCandySwap {

    //问题描述
//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。 
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 哈希表 二分查找 排序 
// 👍 173 👎 0
    public static void main(String[] args) {
        int[] alice = {1, 1};
        int[] bob = {2, 2};
        System.out.println(Arrays.toString(new FairCandySwap().new Solution().fairCandySwap(alice, bob)));
    }

    //实现
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
            int aliceCount = 0, bobCount = 0;
            Map<Integer, Integer> aliceMap = new HashMap<>(aliceSizes.length, 1);
            for (int i = 0; i < aliceSizes.length; i++) {
                aliceMap.putIfAbsent(aliceSizes[i], i);
                aliceCount = aliceCount + aliceSizes[i];
            }
            Map<Integer, Integer> bobMap = new HashMap<>(bobSizes.length, 1);
            for (int i = 0; i < bobSizes.length; i++) {
                bobMap.putIfAbsent(bobSizes[i], i);
                bobCount = bobCount + bobSizes[i];
            }
            boolean flag = aliceCount > bobCount;
            int num = (flag ? aliceCount - bobCount : bobCount - aliceCount) / 2,
                    i = 0, aliceNum = 0, bobNum = 0;
            while (i <= 100000) {
                if (flag) {
                    aliceNum = num + i;
                    bobNum = i;
                } else {
                    bobNum = num + i;
                    aliceNum = i;
                }
                if (aliceMap.containsKey(aliceNum) && bobMap.containsKey(bobNum)) {
                    return new int[]{aliceNum, bobNum};
                }
                i++;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}