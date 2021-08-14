class Solution {
    // Time: O(nlogn)
    // Space: O(n)
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap();

        for (int val : arr) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for (int key : freqMap.keySet()) {
            minHeap.add(freqMap.get(key));
        }

        while (k > 0) {
            // cur is the remove count for next number
            int cur = minHeap.peek();

            if (cur > k)
                break;
            k -= cur;
            minHeap.poll();
        }
        return minHeap.size();
    }
}

// time : n + nlog(n) = nlog(n)
// space : O(n)