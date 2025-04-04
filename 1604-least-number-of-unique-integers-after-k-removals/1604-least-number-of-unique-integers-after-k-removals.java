class Node {
        public int count;
        public int value;

        public Node(int count, int value) {
            this.count = count;
            this.value = value;
        }
}

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((Node a, Node b) -> {
            return Integer.compare(a.count, b.count);
        });
        for(Map.Entry<Integer,Integer> it : map.entrySet()) {
            minHeap.offer(new Node(it.getValue(), it.getKey()));
        }
        while(!minHeap.isEmpty() && k-- > 0) {
            Node curr = minHeap.poll();
            if(curr.count > 1) {
                curr.count = curr.count - 1;
                minHeap.offer(curr);
            }
        }
        return minHeap.size();
    }
}