class Solution {
    public String clearDigits(String s) {
    Stack<Character> stack=new Stack<>();

    for(int i=0;i<s.length();i++){
        if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
            if(stack.isEmpty()==false)stack.pop();
        }else{
            stack.push(s.charAt(i));
        }
    }
    String str="";
    while(stack.isEmpty()==false){
        str=stack.pop()+str;
    }

    return str;


    }
}