class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            String str = Integer.toString(x);
            int len = str.length();
            char[] charArr = str.toCharArray();

            int left = 0;
            int right = len - 1;

            while (left < right) {
                if (charArr[left] == charArr[right]) {
                    left ++; 
                    right --;
                } else {
                    return false;
                }
            }
        }
        return true; 
    }
}