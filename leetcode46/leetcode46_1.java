class Solution {

    public void backtrack(int n, List<List<Integer>> ans, List<Integer> arrL, int first) {
        if (first == n) {
            ans.add(new ArrayList<Integer>(arrL));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(arrL, first, i);
            backtrack(n, ans, arrL, first + 1);
            Collections.swap(arrL, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arrL = new ArrayList<>();

        for (int num : nums) {
            arrL.add(num);
        }

        backtrack(nums.length, ans, arrL, 0);
        return ans;
    }
}