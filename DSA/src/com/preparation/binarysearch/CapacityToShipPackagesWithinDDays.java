package com.preparation.binarysearch;

public class CapacityToShipPackagesWithinDDays {
	
	public int shipWithinDays(int[] weights, int days) {
		int[] highestAndTotalWeight = returnHighestAndTotalWeight(weights);
		int start = highestAndTotalWeight[0];
		int end = highestAndTotalWeight[1];
		
		while(start<end) {
			int mid = start + (end-start)/2;
			int daysRequired = returnDays(weights, mid);
			if(daysRequired<=days) {
				end=mid;
			}else {
				start = mid+1;
			}
		}
		return end;
    }
	
	public int[] returnHighestAndTotalWeight(int[] weights) {
		int highestWeight = weights[0];
		int totalWeight = weights[0];
		for(int i = 1; i < weights.length; i++) {
			highestWeight=Math.max(highestWeight, weights[i]);
			totalWeight+=weights[i];
		}
		return new int[]{highestWeight, totalWeight};
	}
	
	public int returnDays(int [] weights, int maxWeightPossible) {
		int daysRequired = 1;
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum+=weights[i];
			if(sum>maxWeightPossible) {
				sum = weights[i];
				daysRequired++;
			}
		}
		return daysRequired;
	}
}
