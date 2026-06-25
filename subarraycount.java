import java.util.*;


class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int answer = 0;
        int prefixSum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] countArray = new int[2 * n + 1];
        int base = n;
        countArray[base] = 1;
        
        int countBelow = 0; 
        
        for (int i = 0; i < n; i++) {
            int val = (nums[i] == target) ? 1 : -1;
            
            if (val == 1) {
                countBelow += countArray[prefixSum + base];
            } else {
                countBelow -= countArray[prefixSum - 1 + base];
            }
            
            prefixSum += val;
            answer += countBelow;
            countArray[prefixSum + base]++;
        }
        
        return answer;
    }
}