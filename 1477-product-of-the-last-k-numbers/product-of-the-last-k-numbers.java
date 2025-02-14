class ProductOfNumbers {
    private Map<Integer,Integer> map;
    private int index;
    
    public ProductOfNumbers() {
        map=new HashMap<>();
    }
    
    public void add(int num) {
    if(num==0){
        map=new HashMap<>();
        index=0;
    }
    else if(map.isEmpty()){
       map.put(index,num);
       index++;
    }
    else{
        map.put(index,map.get(index-1)*num);
        index++;
    }
       
        
    }
    
    public int getProduct(int k) {
        if(k>map.size())return 0;
        if(map.size()==k)return map.get(map.size()-1);
        return map.get(map.size()-1)/map.get(map.size()-(k+1));
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */