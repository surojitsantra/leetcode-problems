class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        numsFreq = Counter(nums)
        maxCount = numsFreq.get(1, 0)
        if maxCount %2 == 0:
            maxCount -= 1

        numsFreq.pop(1, None)
        
        for num in numsFreq:
            streak = 0
            while numsFreq.get(num, 0) > 1:
                streak += 2
                num *= num
            
            if num in numsFreq:
                streak += 1
            else:
                streak -= 1

            maxCount = max(maxCount, streak)

        return maxCount
        