class Solution {

    static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            int cur = map.get(c);
            int next = 0;
            if (i + 1 < s.length()) {
                next = map.get(s.charAt(i + 1));
            }

            if (cur < next) {
                sum += (next - cur);
                i += 2;
            } else {
                sum += cur;
                i++;
            }
        }
        return sum;
    }
}