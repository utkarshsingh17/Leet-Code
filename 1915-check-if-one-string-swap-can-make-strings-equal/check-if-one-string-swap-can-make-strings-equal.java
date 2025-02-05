class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] charMap=new int[26];
        int count=0;
        for(int i=0;i<s1.length();i++){
            charMap[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            charMap[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(charMap[i]!=0)return false;
        }

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))count++;
        }
        if(count==2||count==0) return true;
        return false;
    }
}