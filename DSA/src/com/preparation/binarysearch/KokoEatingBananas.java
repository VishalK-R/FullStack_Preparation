package com.preparation.binarysearch;

public class KokoEatingBananas {
	/**
	 * Leetcode 875: Koko Eating Bananas
	 * 
	 * @param piles
	 * @param h
	 * @return
	 */
	public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = getMax(piles);
        while(start<end) {
        	int mid = start+(end-start)/2;
        	int totalHours = getTotalHoursRequired(piles,mid);
        	if(totalHours<=h) {
        		end = mid;
        	}else if(totalHours>h){
        		start = mid+1;
        	}
        }
        return end;
    }

	private int getTotalHoursRequired(int[] piles, int mid) {
		int totalHoursreq = 0;
		for(int pile : piles) {
			//totalHoursreq+=Math.ceil((double)pile/mid);
			totalHoursreq+=(pile+mid-1)/mid;
		}
		return totalHoursreq;
	}

	private int getMax(int[] piles) {
		int max = piles[0];
		for(int i = 1; i < piles.length; i++) {
			max = Math.max(piles[i], max);
		}
		return max;
	}
}
