class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charset = new HashSet<>();

        int ml=0;
        int l = 0;

        for(int r=0;r<s.length();r++){
            while(charset.contains(s.charAt(r))){
                charset.remove(s.charAt(l));
                l++;
            }
            charset.add(s.charAt(r));
            ml=Math.max(ml,r-l+1);
        }
        return ml;
    }
}