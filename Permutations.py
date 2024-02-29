class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        return helper_func(nums) 

def helper_func(nums: List[int]):
        length = len(nums)
        if (length == 1):
            return [nums]

        result = []

        #fix each digit to be first element per loop
        for x in range(len(nums)):
            curr_digit = nums[x]
            remaining_digits = nums[0:x] + nums[x+1:length]
            all_combinations_remaining_digits = helper_func(remaining_digits)
            print(all_combinations_remaining_digits)
            print(type(all_combinations_remaining_digits))
            
            for y in range(len(all_combinations_remaining_digits)):
                result.append([curr_digit] + all_combinations_remaining_digits[y])

        return result

            



        