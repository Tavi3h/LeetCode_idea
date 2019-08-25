package pers.tavish.solution.hard;

/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.

for more information: https://leetcode.com/problems/candy/description/
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] left2right = new int[ratings.length], right2left = new int[ratings.length];
        int res = 0;
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        // left -> right
        for (int i = 0; i < left2right.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                left2right[i + 1] = left2right[i] + 1;
            }
        }

        // right -> left
        for (int i = right2left.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right2left[i - 1] = right2left[i] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(left2right[i], right2left[i]);
        }
        return res;
    }

    @Test
    public void testCase() {
        int[] nums = {1, 0, 2, 2, 3, 1, 2, 3, 2, 1, 0, 1};
        Assert.assertEquals(23, candy(nums));
    }
}
