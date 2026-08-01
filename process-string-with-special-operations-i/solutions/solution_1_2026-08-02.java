class Solution {
    public String processStr(String s) {
        return answer(s);
    }
    public String answer(String s ){
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x=='#'){
                ans.append(ans);
            }
            else if(x=='%'){
                ans.reverse();
            }
            else if(x=='*'){
                if(ans.length()>0){
                    ans.deleteCharAt(ans.length()-1);
                }
            }else{
                ans.append(x);
            }
        }
        return ans.toString();
    }
}