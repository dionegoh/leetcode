/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets. 
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap; 
import java.util.List;

class ThreeSum {    //two-pointer solution
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
    
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } 
            
            int left_ptr = i + 1;
            int right_ptr = nums.length - 1;
            
            while (right_ptr > left_ptr) {
                
                int sum = nums[i] + nums[left_ptr] + nums[right_ptr]; 
            
                if (sum > 0) {
                    right_ptr -= 1;
                } else if (sum < 0) {
                    left_ptr += 1;
                } else {
                    ArrayList<Integer> ls = new ArrayList<Integer>();
                    ls.add(nums[i]);
                    ls.add(nums[left_ptr]);
                    ls.add(nums[right_ptr]);
                    results.add(ls);
                    
                    left_ptr += 1;
                    
                    while ((nums[left_ptr] == nums[left_ptr - 1]) && right_ptr > left_ptr) {
                    left_ptr += 1;    
                    }
                }
            }
            
        }
        
        return results;
        
    }
}
 

class ThreeSumV2 {    //double loop + hashmap solution
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<List<Integer>> hm_results = new HashSet<>();

        
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            for (int j = i + 1; j < nums.length; j++) {
                
                int target = - nums[i] - nums[j];
             
                if (hm.containsKey(target) && hm.get(target) > i && hm.get(target) > j) {
                    List<Integer> ls = new ArrayList<Integer>();
                    
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(target);
                    
                    Collections.sort(ls);
                    
                    if (hm_results.contains(ls)) {
                        continue;
                    } else {
                        result.add(ls);
                        hm_results.add(ls);
                    }
                } 
            }
        }
        return result;
    }
}
 