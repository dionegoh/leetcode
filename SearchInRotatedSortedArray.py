class Solution:
    #modified binary search 
    def search(self, nums: List[int], target: int) -> int:
        return binary_search(nums, 0, len(nums) - 1, target)


def binary_search(nums, low, high, x):
    
    if high < low:
        return -1
    
    mid = (high + low) // 2
   

    if (nums[mid] == x):
        return mid

    if (nums[low] <= nums[mid]): #first half is sorted
        if (nums[low] <= x and nums[mid] > x): #target is in first half
            return binary_search(nums, low, mid-1, x)
        else:
            return binary_search(nums, mid+1, high, x)
    else: #second half is sorted
        if (nums[mid] < x and nums[high] >= x): #target is in second half
            return binary_search(nums, mid+1, high, x)
        else:
            return binary_search(nums, low, mid-1, x)
