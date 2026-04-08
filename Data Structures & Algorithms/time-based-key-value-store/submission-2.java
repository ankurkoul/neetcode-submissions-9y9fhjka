class TimeMap {
    //map with sorted list of timestamp and value
    record MyPair(Integer timestamp, String value) {};

    private Map<String,List<MyPair>> map;

    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x-> new ArrayList<>()).add(new MyPair(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        List<MyPair> list=map.get(key);
        int l=0, r=list.size()-1;
        String res="";
        while(l<=r){
            int m= l+(r-l)/2;
            if(list.get(m).timestamp()==timestamp){
                return list.get(m).value();
            }
            if(list.get(m).timestamp()>=timestamp){
                r=m-1;
            }else{
                res=list.get(m).value();
                l=m+1;
            }
        }
        return res;
        
    }
}
