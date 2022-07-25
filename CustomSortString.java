import java.util.*;

class CustomSortString {
    public String customSortString(String order, String s) {
        
        //convert order to char arr
        char[] charArr_order = order.toCharArray();
                
        char[] s_array = s.toCharArray();
        
        customCharacter[] result = new customCharacter[s_array.length];
        
        StringBuilder sb = new StringBuilder();
        
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for (int i = 0; i < charArr_order.length; i++) {
            hm.put(charArr_order[i], i);
            System.out.println(charArr_order[i]);
        }
        
        for (int i = 0; i < s_array.length; i++) {
            
            if (hm.get(s_array[i]) == null) {
                hm.put(s_array[i], hm.size());
            }
            
            result[i] = new customCharacter(s_array[i], hm);
        }
        
        Arrays.sort(result);
        
        for (int i = 0; i < s_array.length; i++) {
            customCharacter toBeAdded = result[i];
            sb.append(toBeAdded.ch);
        }
        
        return sb.toString();
        
    }
    
    class customCharacter implements Comparable<customCharacter> {
        
        public Character ch;
        
        public HashMap<Character, Integer> hm;
        
        public customCharacter(Character ch, HashMap<Character, Integer> hm) {
            this.ch = ch;
            this.hm = hm;
        }
        
        @Override 
        public int compareTo(customCharacter cc) {
            
            int currRank = hm.get(ch);
            
            int otherRank = hm.get(cc.ch);
            
            if (currRank > otherRank) {
                return 1;
            } else if (currRank < otherRank) {
                return -1;
            } else {
                return 0;
            }
        }
    }
        
}