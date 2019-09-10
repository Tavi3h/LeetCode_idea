package pers.tavish.solution.medium;

/*

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

for more information: https://leetcode.com/problems/rectangle-area/description/
 */

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A,E), right = Math.max(Math.min(C,G), left);
        int bottom = Math.max(B,F), top = Math.max(Math.min(D,H), bottom);
        return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
    }
}
