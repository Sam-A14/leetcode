class Solution {
    int i=0;
    public List<String> braceExpansionII(String expression) {
    Set<String> set=parse(expression);
    List<String>ans=new ArrayList<>(set);
    Collections.sort(ans);
    return ans;
    }
    private Set<String>parse(String s){
        Set<String>result = new HashSet<>();
        Set<String> current =new HashSet<>();
        current.add("");
        while(i<s.length() && s.charAt(i)!='}'){
            char ch=s.charAt(i);
            if(ch==','){
                result.addAll(current);
                current=new HashSet<>();
                current.add("");
                i++;
            }else{
                Set<String>part;
                if(ch=='{'){
                    i++;
                    part=parse(s);
                    i++;
                }
                else{
                    part=new HashSet<>();
                    part.add(String.valueOf(ch));
                    i++;
                }
                Set<String>next =new HashSet<>();
                for(String a:current){
                    for(String b:part){
                        next.add(a+b);
                    }
                }
                current=next;
            }
        }
        result.addAll(current);
        return result;
    }
}