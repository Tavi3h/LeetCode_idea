package pers.tavish.solution.medium;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

fot more information: https://leetcode.com/problems/zigzag-conversion/description/
 */

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0
                || s.length() <= numRows || numRows <= 1) return s;
        int N = s.length();
        char[] zigZag = new char[N];
        int count = 0;
        int interval = (2 * numRows) - 2;
        for (int i = 0; i < numRows; i++) {
            int step = (interval - (2 * i));
            for (int j = i; j < N; j += interval) {
                zigZag[count++] = s.charAt(j);
                if (step > 0 && step < interval && (j + step < N)) {
                    zigZag[count++] = s.charAt(j + step);
                }
            }
        }
        return new String(zigZag);
    }
}
