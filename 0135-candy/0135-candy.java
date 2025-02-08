class Node {
    public int value;
    public int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;

        if(len == 1) {
            return 1;
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((Node a, Node b) -> {
            if(a.value != b.value) {
                return Integer.compare(a.value, b.value);
            }
            return Integer.compare(a.index, b.index);
        });

        for(int i=0;i<len;++i) {
            minHeap.offer(new Node(ratings[i], i));
        }

        int[] candies = new int[len];
        Arrays.fill(candies, -1);

        while(!minHeap.isEmpty()) {
            int value = minHeap.peek().value;
            int index = minHeap.peek().index;
            minHeap.poll();

            if(index == 0) {
                if(candies[index + 1] == -1) {
                    candies[index] = 1;
                }
                else {
                    if(ratings[index] == ratings[index + 1]) {
                        candies[index] = 1;
                    }
                    else {
                        candies[index] = 1 + candies[index + 1];
                    }

                }
            }
            else if(index == len - 1) {
                if(candies[index - 1] == -1) {
                    candies[index] = 1;
                }
                else {
                    if(ratings[index] == ratings[index - 1]) {
                        candies[index] = 1;
                    }
                    else {
                        candies[index] = 1 + candies[index - 1];
                    }

                }
            }
            else {
                if(candies[index + 1] == -1 && candies[index - 1] == -1) {
                    candies[index] = 1;
                }
                else {
                    if(ratings[index - 1] == ratings[index] && ratings[index + 1] == ratings[index]) {
                        candies[index] = 1;
                    }
                    else if(ratings[index - 1] == ratings[index]) {
                        if(candies[index + 1] == -1) {
                            candies[index] = 1;
                        }
                        else {
                            candies[index] = 1 + candies[index + 1];
                        }
                    }
                    else if(ratings[index + 1] == ratings[index]) {
                        if(candies[index - 1] == -1) {
                            candies[index] = 1;
                        }
                        else {
                            candies[index] = 1 + candies[index - 1];
                        }
                    }
                    else {
                        candies[index] = 1 + Math.max(candies[index + 1], candies[index - 1]);
                    }
                    
                }
            }
        }
        int minSum = Arrays.stream(candies).sum();
        return minSum;
    }
}