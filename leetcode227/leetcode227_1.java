class Solution {
    public int calculate(String s) {
        if (s.length() == 0)
            return 0;

        Stack<Integer> st = new Stack<Integer>();
        char operation = '+';
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (Character.isDigit(cur)) {
                number = (number * 10) + (cur - '0');
            }

            if (cur == '+' || cur == '-' || cur == '*' || cur == '/' || i == s.length() - 1) {
                if (operation == '+') {
                    st.push(number);
                }

                else if (operation == '-') {
                    st.push(-number);
                }

                else if (operation == '*') {
                    st.push(st.pop() * number);
                }

                else if (operation == '/') {
                    st.push(st.pop() / number);
                }

                operation = cur;
                number = 0;

            }
        }

        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;

    }
}