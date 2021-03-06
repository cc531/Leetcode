class TimeMap {
    Map<String, ArrayList<ArrayList<String>>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, ArrayList<ArrayList<String>>>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.get(key) == null) {
            map.put(key, new ArrayList<ArrayList<String>>());
        }

        map.get(key).add(new ArrayList<String>(List.of(value, String.valueOf(timestamp))));
    }
    // map.get(key)
    // inputs = ["get"]
    // inputs = [key]

    public String get(String key, int timestamp) {
        // String ans = "";
        // int t;
        // for (ArrayList<String> arrL : map.get(key))
        // {
        // if (Integer.valueOf(arrL.get(1)) <= timestamp)
        // {
        // t = Integer.valueOf(arrL.get(1));
        // ans = arrL.get(0);
        // }
        // else
        // {
        // break;
        // }
        // }

        // return ans;

        String ans = "";
        ArrayList<ArrayList<String>> arrL = map.get(key);

        // binary search
        int left = 0, right = arrL.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int t = Integer.valueOf(arrL.get(mid).get(1));
            if (t == timestamp) {
                return arrL.get(mid).get(0);
            } else if (t < timestamp) {
                ans = arrL.get(mid).get(0);
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */