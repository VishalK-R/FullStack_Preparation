package com.preparation.binarysearch;

public class FindMinimumInRotatedSortedArray {
	/**
	 * If nums[mid] > nums[end], the rotation point (and therefore the minimum) must be to the right of mid. 
	 * The portion from start through mid belongs to the higher sorted portion, so it can be discarded.
	 * 
	 * @param nums
	 * @return min element
	 */
	public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start<end) {
        	int mid = start + (end-start)/2;
        	if (nums[mid]>nums[end]) {
        		start=mid+1;
        	}else if (nums[mid]<nums[end]) {
        		end = mid;
        	}
        }
        return nums[start];
    }
}
