package pers.tavish.solution.easy;

/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"

for more information: https://leetcode.com/problems/excel-sheet-column-title/description/
 */

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String s = "";
        while (n != 0) {
            int temp = (n - 1) % 26;
            s = (char) ('A' + temp) + s;
            n = (n - 1) / 26;
        }
        return s;
    }

    @Test
    public void testCase() {
        Assert.assertEquals("BZ", convertToTitle(78));
        Assert.assertEquals("EN", convertToTitle(144));
        Assert.assertEquals("EDU", convertToTitle(3505));
        Assert.assertEquals("Z", convertToTitle(26));
        Assert.assertEquals("C", convertToTitle(3));
        Assert.assertEquals("ZZ", convertToTitle(702));
        Assert.assertEquals("AZ", convertToTitle(52));
    }
}
