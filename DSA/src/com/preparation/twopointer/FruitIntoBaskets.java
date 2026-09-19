package com.preparation.twopointer;

import java.util.HashMap;

public class FruitIntoBaskets {

	/**
	 * leetcode: 904. Fruit Into Baskets
	 * 
	 * Use a HashMap to store each distinct value in the current window and its latest index. Expand the right pointer as we scan the array. 
	 * If adding a new value causes the window to contain more than two distinct values, find the existing value whose latest occurrence is 
	 * Farthest to the left. Move the left pointer to one position after that occurrence. The window size is right - left + 1, 
	 * and we keep track of the maximum window size.
	 * 
	 * In the latest-index approach, the map stores where each value was most recently seen, so when a third distinct value appears, 
	 * we can identify the older latest occurrence and move left directly past it. In the frequency approach, the map only tells us 
	 * how many occurrences of each value are currently in the window; it doesn't tell us where the boundary should jump, 
	 * so we move left one element at a time, decrementing frequencies until only two distinct values remain.
	 * 
	 * @param fruits
	 * @return
	 */
	public int totalFruit(int[] fruits) {
        int totalFruit = 0;
        HashMap<Integer, Integer> distinctFruitAndRecentIndex = new HashMap<>();
        int leftPointer = 0, rightPointer = 0;
        while (rightPointer<fruits.length) {
        	
        	if (distinctFruitAndRecentIndex.size()==2&&!distinctFruitAndRecentIndex.containsKey(fruits[rightPointer])) {
    			Integer[] keys = distinctFruitAndRecentIndex.keySet().toArray(new Integer[0]);
    			int fruitToBeRemoved = distinctFruitAndRecentIndex.get(keys[0])<distinctFruitAndRecentIndex.get(keys[1])?keys[0]:keys[1];
    			leftPointer = distinctFruitAndRecentIndex.get(fruitToBeRemoved)+1;
    			distinctFruitAndRecentIndex.remove(fruitToBeRemoved);
    		}
        	
        	distinctFruitAndRecentIndex.put(fruits[rightPointer], rightPointer);
        	totalFruit = Math.max(totalFruit, rightPointer - leftPointer + 1);
        	rightPointer++;
        }
        return totalFruit;
    }

}
