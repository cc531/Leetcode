class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        List<String> route = new ArrayList<>();

        for (List<String> ticket : tickets) {
            // if (targets.get(ticket.get(0)) == null)
            // targets.put(ticket.get(0), new PriorityQueue<String>);
            // PriorityQueue<String> pq = targets.get(ticket.get(0));
            // pq.add(ticket.get(1));
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        }
        visit(targets, route, "JFK");
        return route;
    }

    // JFK - > SJC
    // SJC - > JFK
    // JFK - > SFO
    // JFK - > SFO - > JFK - > S?? correct
    // JFK - > SFO wrong

    void visit(Map<String, PriorityQueue<String>> targets, List<String> route, String airport) {
        // route.add(airport); wrong answer
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets, route, targets.get(airport).poll());
        route.add(0, airport);
    }
}

// Runtime: 5 ms, faster than 76.49% of Java online submissions for Reconstruct
// Itinerary.
// Memory Usage: 39.2 MB, less than 94.18% of Java online submissions for
// Reconstruct Itinerary.
// time Complexity: O(n)
// space complexity: O(n)
// https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B