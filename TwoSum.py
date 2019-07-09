class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans=[]
        d={}
        for i in range(len(nums)):
            if (target - nums[i]) not in d:
                d[nums[i]] = i
            else:
                temp = target - nums[i]
                ans.append(d[temp])
                ans.append(i)
                return ans
