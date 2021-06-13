class Solution {

    List<Integer> arrL;

    public Solution(int[] w) {

        arrL = new ArrayList<Integer>();
        arrL.add(0);

        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            arrL.add(sum);
        }

    }

    public int pickIndex() {
        int ans = 0;
        Random r = new Random();

        int target = r.nextInt(arrL.get(arrL.size() - 1));

        int left = 0, right = arrL.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arrL.get(mid) == target) {
                return mid;
            } else if (arrL.get(mid) < target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return ans;

    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */