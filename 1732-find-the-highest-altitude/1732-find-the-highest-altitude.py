class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        maxAlt = 0
        curAlt = 0

        for alt in gain:
            curAlt += alt
            maxAlt = max(maxAlt, curAlt)

        return maxAlt
        