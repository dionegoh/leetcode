public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] memoizeArr = new int[n];
        memoizeArr[0] = 1;
        memoizeArr[1] = 2;

        for (int i = 2; i < n; i++) {
            memoizeArr[i] = memoizeArr[i-1] + memoizeArr[i-2];
        }

        return memoizeArr[n-1];
    }
}