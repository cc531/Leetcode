class TimeMap {
    // foo: {{"bar", "1"} {'bar2', '4'}}
    Map<String, ArrayList<ArrayList<String>>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, ArrayList<ArrayList<String>>>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.get(key) == null) {
            map.put(key, new ArrayList<ArrayList<String>>());
        }

        ArrayList<String> arrL = new ArrayList<>();
        arrL.add(value);
        arrL.add(String.valueOf(timestamp));
        map.get(key).add(arrL);
    }

    public String get(String key, int timestamp) {
        String ansStr = "";

        // binary search
        int left = 0, right = ans.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int t = Integer.valueOf(ans.get(mid).get(1));
            if (t == timestamp) {
                return ans.get(mid).get(0);
            } else if (t < timestamp) {
                ansStr = ans.get(mid).get(0);
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return ansStr;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */