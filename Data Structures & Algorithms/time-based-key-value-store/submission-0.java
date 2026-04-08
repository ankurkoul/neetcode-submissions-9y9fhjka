class TimeMap {
    // k-v store
    // k-> [{v, time}]
    // foo-> [bow,1][][]
    // we need to return value sorted by timestamp hence
    // timestamp pattern? inc or dec or any?
    // eg: geneally time map ? 
    private Map<String, List<Pair<Integer,String>>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,x-> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> list= map.getOrDefault(key , new ArrayList<>());
        int l=0, r= list.size()-1;
        String res="";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(list.get(mid).getKey()==timestamp){
                return list.get(mid).getValue();
            }else if(list.get(mid).getKey()<timestamp){
                res=list.get(mid).getValue();
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}
