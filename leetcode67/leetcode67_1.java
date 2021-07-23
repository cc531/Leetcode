class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int carry = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            // check from the last char is because it will have carry num if
            // the sum over ten
            int cur = a.charAt(a.length() - 1 - i) - '0';

            if (i < b.length()) {
                cur += b.charAt(b.length() - 1 - i) - '0';
            }

            cur += carry;
            ans.append(String.valueOf(cur % 2));
            carry = cur / 2;
        }

        if (carry == 1) {
            ans.append(1);
        }

        return ans.reverse().toString();

    }
}