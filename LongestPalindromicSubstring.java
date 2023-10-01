import java.lang.*;

class Solution {
    int maxLen = 0;
    int start_index = 0;
    int end_index = 0;

    public void expand(int i, int j, char[] charArr) {
        while (i >=0 && j < charArr.length && charArr[i] == charArr[j]) {
            i--;
            j++;
        }
        i++;
        j--;
        if (maxLen < (j - i + 1)) {
            maxLen = j - i + 1;
            start_index = i;
            end_index = j;
        }        
    }

    public String longestPalindrome(String s) {
        
        String result = "";
        char[] charArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            expand(i, i, charArr);
            expand(i, i+1, charArr);
        }
        return s.substring(start_index, end_index + 1);
    }
}