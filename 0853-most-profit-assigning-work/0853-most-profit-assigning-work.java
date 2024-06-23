class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Pair() {

    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}


class Solution {
    public int binarySearchForWorker(List<Pair<Integer,Integer>> list, int[] maxProfit, int workerPower) {
        int low = 0;
        int high = list.size() - 1;
        int mid;
        int maxPossibleProfit = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            
            if(list.get(mid).getKey() <= workerPower) {
                maxPossibleProfit = Math.max(maxProfit[mid], maxPossibleProfit);
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        // System.out.println("For worker power -> " + workerPower + " final is -> " + maxPossibleProfit);
        return maxPossibleProfit;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        for(int i=0;i<len;++i) {
            list.add(new Pair<>(difficulty[i], profit[i]));
        }
        Collections.sort(list,(p1, p2) -> p1.getKey().compareTo(p2.getKey()));
        int[] maxProfit = new int[len];
        maxProfit[0] = list.get(0).getValue();
        for(int i=1;i<len;++i) {
            maxProfit[i] = Math.max(maxProfit[i - 1], list.get(i).getValue());
        }
        System.out.println(list);
        for(int i : maxProfit) {
            System.out.print(i + " ");
        }
        int finalProfit = 0; 
        //now binary search on this list
        for(int i=0;i<worker.length;++i) {
            //for every worker find the best suitable position
            int maxPossibleProfit = binarySearchForWorker(list, maxProfit, worker[i]);
            finalProfit += maxPossibleProfit;
        }
        return finalProfit;
    }
}