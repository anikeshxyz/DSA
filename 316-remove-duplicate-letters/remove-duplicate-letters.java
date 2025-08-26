class Solution {
    public String removeDuplicateLetters(String s) {
      int[] freq = new int[26];
        boolean[] visited = new boolean[26];

            for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        Stack<Character> Stack = new Stack<> ();
       for(char ch : s.toCharArray()){
            int idx = ch-'a';
            freq[idx]--;
            if(visited[idx])continue;

            while(!Stack.isEmpty() && Stack.peek()> ch&& freq[Stack.peek() -'a'] > 0){
                visited[Stack.pop() - 'a']=false;
            }
            Stack.push(ch);
            visited[idx] = true;
        }    
        StringBuilder sb = new StringBuilder();
        for(char ch : Stack){
            sb.append(ch);
        }
        return sb.toString();
        
    }

}