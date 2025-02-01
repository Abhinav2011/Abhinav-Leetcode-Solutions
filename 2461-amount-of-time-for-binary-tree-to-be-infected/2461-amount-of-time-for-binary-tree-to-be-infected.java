/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void createGraph(TreeNode root, TreeNode parent, HashMap<Integer, List<Integer>> graph) {
        if(root == null) {
            return;
        }

        if(parent != null) {
            graph.computeIfAbsent(root.val, (key) -> new ArrayList<>()).add(parent.val);
        }
        if(root.left != null) {
            graph.computeIfAbsent(root.val, (key) -> new ArrayList<>()).add(root.left.val);
        }
        if(root.right != null) {
            graph.computeIfAbsent(root.val, (key) -> new ArrayList<>()).add(root.right.val);
        }

        createGraph(root.left, root, graph);
        createGraph(root.right, root, graph);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        createGraph(root, null, graph);
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        q.offer(start);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size -- > 0) {
                int currNode = q.poll();
                List<Integer> adjNodes = graph.getOrDefault(currNode, new ArrayList<>());
                for(Integer adjNode : adjNodes) {
                    if(visited.contains(adjNode)){
                        continue;
                    }
                    visited.add(adjNode);
                    q.offer(adjNode);
                }
            }
            time++;
        }
        return time - 1;
    }
}