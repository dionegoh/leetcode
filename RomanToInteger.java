import java.util.*;

class RomanToInteger {
    public int romanToInt(String s) {

        char[] charArr = s.toCharArray();
        int len = charArr.length;
        HashMap<Character, Integer> hm = new HashMap<>(); 
        int currentValue = 0;

        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        int i = 0;

        while (i < len) {
            
            char symbol = charArr[i];
            int valueToAdd;

            if (i == len - 1) {
                valueToAdd = hm.get(charArr[i]);
                currentValue += valueToAdd;
                break;
            }

            char nextSymbol = charArr[i + 1];

            if (hm.get(nextSymbol) > hm.get(symbol)) {
                valueToAdd = hm.get(nextSymbol) - hm.get(symbol);
                i++;
            } else {
                valueToAdd = hm.get(symbol);
            }

            currentValue += valueToAdd;
            i++; 
        }

        return currentValue;
    }
}