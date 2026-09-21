package com.preparation.binarysearch;

public class SearchInRotatedSortedArray {
	/**
	 * 
	 * Since the array has been rotated, we cannot assume either half is sorted. I compare the middle element with the right boundary 
	 * to determine whether the right half is sorted. If it is not, the left half must be sorted. I then use the sorted half 
	 * to determine whether the target can lie within that range.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	
	public int search(int[] nums, int target) {
        int indexFound = -1;
        int start = 0; 
        int end = nums.length-1;
        while(start<=end) {
        	int mid = start + (end-start)/2;
        	
        	if (nums[mid]==target) {
        		indexFound = mid;
        		break;
        	}
        	
        	if(nums[mid]<=nums[end]) {
        		if(nums[mid]<target&&target<=nums[end]) {
        			start = mid+1;
        		}else {
        			end = mid-1;
        		}
        	}else {
        		if(nums[start]<=target&&target<nums[mid]) {
        			end = mid-1;
        		}else {
        			start = mid+1;
        		}
        	}
        }
        
        
        return indexFound;
    }
}
