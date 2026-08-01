class Solution {
    public boolean backspaceCompare(String s, String t) {
        return make(s).equals(make(t));
    }
    public static String make(String s){
        Stack<Character> stack=new Stack<>();
        for(char Char:s.toCharArray()){
            if(Char=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(Char);
            }
        }
        StringBuilder ans= new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}