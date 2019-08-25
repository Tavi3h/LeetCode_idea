package pers.tavish.solution.easy;

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
Input: 121
Output: true

Example 2:
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

    Coud you solve it without converting the integer to a string?

for more information: https://leetcode.com/problems/palindrome-number/description/
 */

public class PalindromeNumber {

    // convert to string
/*
    public boolean isPalindrome(int x) {
        return x < 0 ? false : (x + "").equals(new StringBuilder(x + "").reverse().toString());
    }
*/

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else if (x == Integer.MAX_VALUE) {
            return false;
        } else {
            int res = 0, origin = x, size = sizeOfInt(x);
            while (x != 0) {
                int m = x % 10;
                x /= 10;
                res += m * Math.pow(10, --size);
            }
            return res == origin;
        }
    }

    private int sizeOfInt(int x) {
        int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
        for (int i = 0;; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }
}
