class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> graph = new HashMap<>();
        HashSet<String> recipe = new HashSet<>(Arrays.asList(recipes));
        HashSet<String> supply = new HashSet<>(Arrays.asList(supplies));
        HashSet<String> canBeMade = new HashSet<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        for(int i=0;i<recipes.length;++i) {
            String currRecipe = recipes[i];
            List<String> ing = ingredients.get(i);
            boolean ok = true;
            for(String k : ing) {
                if(!supply.contains(k)) {
                    ok = false;
                }
                if(recipe.contains(k)) {
                    graph.computeIfAbsent(k, (key) -> new ArrayList<>()).add(currRecipe);
                    indegree.put(currRecipe, indegree.getOrDefault(currRecipe, 0) + 1);
                }
            }
            if(ok) {
                canBeMade.add(currRecipe);
            }
        }
        for(String s : recipes) {
            if(!graph.containsKey(s)) {
                graph.put(s, new ArrayList<>());
            }
            if(!indegree.containsKey(s)) {
                indegree.put(s, 0);
            }
        }
        // System.out.println(canBeMade);
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        System.out.println(indegree);
        System.out.println(graph);
        for(Map.Entry<String,Integer> it : indegree.entrySet()) {
            if(it.getValue() == 0) {
                q.offer(it.getKey());
            }
        }
        System.out.println(q);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String curr = q.poll();
                //check if this can be made
                if(canBeMade.contains(curr)) {
                    res.add(curr);
                }
                else {
                    continue;
                }
                List<String> nei = graph.getOrDefault(curr, new ArrayList<>());
                for(String s : nei) {
                    indegree.put(s, indegree.get(s) - 1);
                    if(indegree.get(s) == 0) {
                        indegree.remove(s);
                        q.offer(s);
                        canBeMade.add(s);
                    }
                }
            }
        }
        return res;
    }
}