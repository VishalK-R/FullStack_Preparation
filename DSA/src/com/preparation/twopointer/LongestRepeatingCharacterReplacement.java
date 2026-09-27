package com.preparation.twopointer;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int maxLength = 0;
		int left = 0;
		int right = 0;
		int [] freqAr = new int[26];
		int maxFreq = 0;
		while(right<s.length()) {
			char curCh = s.charAt(right);
			int windowLength = right-left+1;
			freqAr[curCh-'A']++;
			maxFreq = findMaxFreq(freqAr);
 			if(isValidBoundary(maxFreq, windowLength, k)) {
				maxLength = Math.max(maxLength, windowLength);
				right++;
			}else {
				freqAr[curCh-'A']--;
				freqAr[s.charAt(left)-'A']--;
				left++;
			}
		}
		return maxLength;
	}

	private static int findMaxFreq(int[] freqAr) {
		int max = 0;
		for(int freq: freqAr) {
			max = Math.max(max, freq);
		}
		return max;
	}

	private static boolean isValidBoundary(int maxFreq, int windowLength, int target) {
		return windowLength-maxFreq<=target;
	}
	
	/**
	 * We can avoid recalculating maxFreq after removing left
	 * Instead of maintaining the exact current maximum frequency, 
	 * we can maintain the highest frequency we've ever seen while expanding right.
	 * 
	 * We allow maxFreq to become stale because it represents the highest frequency 
	 * observed while expanding the window. It can be greater than the actual maximum 
	 * frequency of the current window, but this does not cause us to overestimate the 
	 * final answer. It allows us to avoid repeatedly scanning the frequency array when 
	 * left moves.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacementConsideringStaleFrequency(String s, int k) {
		int maxLength = 0;
		int left = 0;
		int right = 0;
		int [] freqAr = new int[26];
		int maxFreq = 0;
		while(right<s.length()) {
			char curCh = s.charAt(right);
			int windowLength = right-left+1;
			freqAr[curCh-'A']++;
			maxFreq = Math.max(maxFreq, freqAr[curCh-'A']);
 			if(!isValidBoundary(maxFreq, windowLength, k)) {
 				freqAr[s.charAt(left)-'A']--;
 				left++;
			}
 			//as left could be moved at this point
 			windowLength = right-left+1;
			maxLength = Math.max(maxLength, windowLength);
			right++;
		}
		return maxLength;
	}
	
}
