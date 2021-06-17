class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        if (n == 0) {
            return 0;
        }

        Integer[] start = new Integer[n];
        Integer[] end = new Integer[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;

        while (startPointer < n) {
            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }
            usedRooms += 1;
            startPointer += 1;
        }
        return usedRooms;

    }
}