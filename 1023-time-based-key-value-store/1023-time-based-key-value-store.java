 class Node {
        public int timestamp;
        public String value;

        public Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
}
 class TimeMap {
        HashMap<String, List<Node>> map;
        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            List<Node> list = map.get(key);
            list.add(new Node(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<Node> list = map.getOrDefault(key, new ArrayList<>());
            if(list.isEmpty()) {
                return "";
            }
            int left = 0, right = list.size() - 1;
            int mid,ans = -1;
            while(left <= right) {
                mid = (left + right) / 2;
                
                if(timestamp < list.get(mid).timestamp) {
                    right = mid - 1;
                }
                else {
                    ans = mid;
                    left = mid + 1;
                }
            }
            if(ans == -1) {
                return "";
            }
            return list.get(ans).value;
        }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */