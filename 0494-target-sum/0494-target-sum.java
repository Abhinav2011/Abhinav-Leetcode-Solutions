class Node {
    public int index;
    public int sum;

    public Node(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }

    // Override equals method to define custom equality based on name and age
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return index == node.index && Objects.equals(sum, node.sum);
    }

    // Override hashCode method to generate hash based on name and age
    @Override
    public int hashCode() {
        return Objects.hash(index, sum);
    }

}

class Solution {
   public int helper(int index, int currentSum, int[] nums, int target, HashMap<Node,Integer> cache) {
        if(index >= nums.length && currentSum == target) {
            return 1;
        }
        if(index >= nums.length) {
            return 0;
        }
        Node n = new Node(index, currentSum);
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        //two choices
        int val = helper(index + 1, currentSum + nums[index], nums, target, cache) +
                helper(index + 1,currentSum - nums[index], nums, target, cache);
        cache.put(n, val);
        return cache.get(n);
    }
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Node, Integer> cache = new HashMap<>();
        return helper(0, 0, nums, target, cache);
    }
}
