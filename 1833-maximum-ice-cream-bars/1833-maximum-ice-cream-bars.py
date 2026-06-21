class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        costs.sort()

        bars = 0
        
        for x in costs:
            if x <= coins:
                coins -= x
                bars += 1
            else:
                break

        return bars
        