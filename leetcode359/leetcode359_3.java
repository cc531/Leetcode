class Logger {
    private Queue<List<String>> queue;
    private HashSet<String> messages;

    /** Initialize your data structure here. */
    public Logger() {
        queue = new LinkedList<>();
        messages = new HashSet<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    // msg = 1, 2, 5, 10, 19, 23, 51, 59, 61 only 59 and 61 are the same msg
    // q : {1(msg), 1(timestamp)}, {2, 2} {5, 5} {10, 10} messages = {1, 2, 5, 10}
    // only contain less than 10 msg
    // q : {10, 10} {19, 19} messages = {10, 19}
    // q: {19, 19} {23, 23} messages = {19, 23}
    // int[] a = new int[2];
    // a[1];
    // List<Integer> b = new ArrayList<>();
    // b.add(0); b.add(1);
    // b.get(1) == 1;
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && timestamp - Integer.parseInt(queue.peek().get(1)) >= 10) {
            List<String> msginfo = queue.poll();
            String msg = msginfo.get(0);
            messages.remove(msg);
        }

        if (messages.contains(message))
            return false;

        List<String> cur = new ArrayList<>();
        cur.add(message);
        cur.add(String.valueOf(timestamp));
        queue.add(cur);
        messages.add(message);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

// https://leetcode.com/problems/logger-rate-limiter/discuss/391558/Review-of-four-different-solutions%3A-HashMap-Two-Sets-Queue-with-Set-Radix-buckets-(Java-centric)
// https://leetcode.com/problems/logger-rate-limiter/discuss/349733/Simple-Java-solution-using-Queue-and-Set-for-slow-learners-like-myself
// Runtime: 32 ms, faster than 8.00% of Java online submissions for Logger Rate
// Limiter.
// Memory Usage: 47.1 MB, less than 35.16% of Java online submissions for Logger
// Rate Limiter.
// time complexity: O(1)
// space complexity: O(m) where m is the maximum number of unique message that
// will be received in a 10 second period.