class Logger {
    HashMap<String, Integer> old_cache;
    HashMap<String, Integer> new_cache;
    int time_new;

    /** Initialize your data structure here. */
    public Logger() {
        this.old_cache = new HashMap<>();
        this.new_cache = new HashMap<>();
        time_new = 0;
        // integer = 4bytes = 32bits, range : -2^31 ~ ( 2^31 -1)
        // -2, -1, 0, 1 = 4 = 2^2 = -2^1 ~ (2^1 - 1)
        // -1 --> represent 0
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */

    // msg = 1, 2, 5, 10, 19, 23, 51, 59, 61 only 59 and 61 are the same msg
    // old_cache = {} new_cache = {1, 2, 5, 10} time_new = 1
    // old_cache = {1, 2, 5, 10} new_cache = {19, 23} time_new = 19
    // old_cache = {} new_cache = {51, 59} time_new = 51
    // old_cache = {51, 59} new_cache = {} time_new = 61
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp - time_new >= 20) {
            old_cache.clear();
            new_cache.clear();
            time_new = timestamp;
        } else if (timestamp - time_new >= 10) {
            // swap
            HashMap<String, Integer> tmp = old_cache;
            old_cache = new_cache;
            new_cache = tmp;

            new_cache.clear();
            time_new = timestamp;
        }
        // < 10
        if (new_cache.containsKey(message))
            return false;

        // timestamp - time_new >= 10 < 20
        if (old_cache.containsKey(message)) {
            int last = old_cache.get(message);
            if (timestamp - last < 10)
                return false;
        }

        new_cache.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

// https://leetcode.com/problems/logger-rate-limiter/discuss/391558/Review-of-four-different-solutions%3A-HashMap-Two-Sets-Queue-with-Set-Radix-buckets-(Java-centric)
// https://leetcode.com/problems/logger-rate-limiter/discuss/365306/Simple-Two-HashMap-Solution-with-O(1)-time-and-little-memory
// Runtime: 27 ms, faster than 38.65% of Java online submissions for Logger Rate
// Limiter.
// Memory Usage: 49.2 MB, less than 5.67% of Java online submissions for Logger
// Rate Limiter.
// time complexity: O(1)
// space complexity: O(m) where m is the maximum number of unique message that
// will be received in a 20 second period.