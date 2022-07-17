import java.util.HashMap;

class TwoSum {
    
    // Hashmap implementation, time complexity = O(n)
    
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        
        
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            int desiredInt = target - nums[i];
            if (hm.containsKey(desiredInt) && hm.get(desiredInt) != i) {
                result[0] = i;
                result[1] = hm.get(desiredInt);
                return result;
            }
        }
        return result;
    }
    
    
    
    
    // Brute force implementation, time complexity = O(n^2) 
    
    public int[] twoSumBruteForce(int[] nums, int target) {
        
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                int sum = nums[i] + nums[j]; 
                if (sum == target) {
                    result[0] = i;
                    result[1] = j; 
                    return result;  
                } else {
                    continue;
                }
            }
        }
        return result; 
    }
}

