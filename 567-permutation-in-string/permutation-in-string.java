class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        for (int i = 0; i <= s2.length() - k; i++) {
            String window = s2.substring(i, i + k);
            if (sort(window).equals(sort(s1))) {
                return true;
            }
        }
        return false;
    }
    private String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}