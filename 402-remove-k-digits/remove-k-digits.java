class Solution {
    public String removeKdigits(String num, int k) {
         if (k == num.length()) return "0"; // remove all digits

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            // Maintain increasing order
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        // If still need to remove digits → remove from end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') {
            i++;
        }

        String result = (i == stack.length()) ? "0" : stack.substring(i);
        return result;
    }
}