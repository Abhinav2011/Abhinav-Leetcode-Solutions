class Solution {
    List<List<Integer>> solutionSet = new ArrayList<>();
    HashSet<List<Integer>> set = new HashSet<>();
    public void helper(int index,int[] candidates, int target, List<Integer> list) {
        if(target == 0) {
            solutionSet.add(new ArrayList<>(list));
            return;
        }
        if(index >= candidates.length || target < 0) {
            return;
        }
        list.add(candidates[index]);
        helper(index + 1,candidates, target - candidates[index], list);
        list.remove(list.size() - 1);
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        helper(index + 1,candidates,target,list);
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0,candidates,target,new ArrayList<>());
        return solutionSet;
    }
}

// 1 2 2 5 