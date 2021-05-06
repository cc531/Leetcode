class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> domain_counts = new HashMap<>();

        for (String domain : cpdomains) {
            String[] cpinfo = domain.split(" ");
            String[] frags = cpinfo[1].split("\\.");

            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";

            for (int i = frags.length - 1; i >= 0; i--) {
                // a += b ==> a = a + b
                if (i == frags.length - 1)
                    cur = frags[i];
                else
                    cur = frags[i] + "." + cur;
                domain_counts.put(cur, domain_counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String key : domain_counts.keySet()) {
            ans.add(domain_counts.get(key) + " " + key);
        }

        return ans;
    }
}

// Runtime: 39 ms, faster than 5.54% of Java online submissions for Subdomain
// Visit Count.
// Memory Usage: 49.6 MB, less than 5.65% of Java online submissions for
// Subdomain Visit Count.
// time:
// space: