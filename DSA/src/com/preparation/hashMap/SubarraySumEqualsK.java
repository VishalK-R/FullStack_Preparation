package com.preparation.hashMap;

import java.util.HashMap;

public class SubarraySumEqualsK {
	/**560. Subarray Sum Equals K
	 * 
	 * For each position, I maintain a running prefix sum.
	 * If a subarray has sum k, then:
	 * currentPrefixSum - previousPrefixSum = k
	 * Therefore, the previous prefix sum we need is: currentPrefixSum - k
	 * I use a HashMap to store each previously seen prefix sum and its frequency. At each position, 
	 * I look up `currentPrefixSum - k` in the map and add its frequency to the result, 
	 * because each occurrence represents a different valid subarray ending at the current position.
	 * Then I add the current prefix sum to the map so it can be used by future positions.
	 * I initialize the map with prefix sum `0` having frequency `1` so that subarrays starting at index `0` are handled naturally.
	 * This gives us `O(n)` average time and `O(n)` auxiliary space.
	 * 
	 * @param nums
	 * @param k
	 * @return subArraysPossible
	 */
	public int subarraySum(int[] nums, int k) {
        int subArraysPossible = 0;
        HashMap<Integer, Integer> prefixSumAndFrequency = new HashMap<>();
        prefixSumAndFrequency.put(0, 1);
        int curPrefixSum = 0;
        for (int num:nums) {
        	curPrefixSum+=num;
        	
        	if(prefixSumAndFrequency.containsKey(curPrefixSum-k)) {
        		subArraysPossible+=prefixSumAndFrequency.get(curPrefixSum-k);
        	}
        	
        	prefixSumAndFrequency.put(curPrefixSum, prefixSumAndFrequency.getOrDefault(curPrefixSum, 0)+1);
        	
//        	if(prefixSumAndFrequency.containsKey(curPrefixSum)) {
//        		int frq = prefixSumAndFrequency.get(curPrefixSum)+1;
//        		prefixSumAndFrequency.put(curPrefixSum, frq);
//        	}else {
//        		prefixSumAndFrequency.put(curPrefixSum, 1);
//        	}
        }
        return subArraysPossible;
    }
}
