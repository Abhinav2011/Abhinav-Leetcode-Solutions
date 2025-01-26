class Pair {
    public String key;
    public int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
class TimeMap {
    
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, (k) -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Pair> allValues = map.get(key);
        int left = 0, right = allValues.size() - 1;
        int mid, ans = -1;

        while(left <= right) {
            mid = left + (right - left) / 2;

            if(allValues.get(mid).value <= timestamp) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if(ans == -1) {
            return "";
        }

        return allValues.get(ans).key;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */