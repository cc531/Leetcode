class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        // {3, [-1, -3, 5]}
        // {i-k, [i-2, i-1, i]}
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0)
            return new int[0];
        if (k == 1)
            return nums;

        // init deque and output
        this.nums = nums;

        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[deq.getFirst()];

        // build output
        // i = 3
        // i - k + 1 = 3 - 3 + 1 = 1
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // {3, [-1, -3, 5]}
            // {i-k, [i-k+1,..., i-1, i]}
            output[i - k + 1] = nums[deq.getFirst()];
        }

        return output;
    }
}