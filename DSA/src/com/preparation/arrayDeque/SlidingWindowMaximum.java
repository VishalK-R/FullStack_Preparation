package com.preparation.arrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxWindowArray = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int pointer = 0;
        while(pointer<maxWindowArray.length) {
        	int curNum = nums[pointer];
        	while(dq.peekLast()!=null) {
        		if(dq.peekLast()<=curNum) {
        			dq.removeLast();
        		}else {
        			break;
        		}
        	}
        	dq.addLast(curNum);
        	if((pointer-k)>=0&&nums[pointer-k]==dq.peekFirst()) {
        		dq.removeFirst();
        	}
        	
        	if(pointer-k-1>=0) {
        		maxWindowArray[pointer-k-1]=dq.peekLast();
        	}
        	pointer++;
        }
        return maxWindowArray;
    }
}
