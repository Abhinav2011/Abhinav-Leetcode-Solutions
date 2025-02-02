class TrieNode {
    public HashMap<Character,TrieNode> children;
    PriorityQueue<String> possibleWords; // this is a max heap
    public boolean isEnd;

    public TrieNode() {
        this.children = new HashMap<>();
        this.possibleWords = new PriorityQueue<>(Collections.reverseOrder());
        this.isEnd = false;
    }
}
class Trie {
    TrieNode root; // root of the tree
    public Trie() {
        root = new TrieNode();
    }

    //insert a word in the tree
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            //now we are in that node (add 3 possible suggestions for that node)
            if(curr.possibleWords.size() < 3) {
                curr.possibleWords.offer(word);
            }
            else {
                if(word.compareTo(curr.possibleWords.peek()) < 0) {
                    curr.possibleWords.poll();
                    curr.possibleWords.offer(word);
                }
            }
        }
        curr.isEnd = true;
    }

    //search a string starting with a prefix
    public List<String> getSuggestions(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children.get(c) == null) {
                return new ArrayList<>();
            }
            curr = curr.children.get(c);
        }
        PriorityQueue<String> suggestions = curr.possibleWords;
        List<String> list = new ArrayList<>();
        while(!suggestions.isEmpty()) {
            list.add(suggestions.poll());
        }
        Collections.reverse(list);
        return list;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for(String product : products) {
            trie.insert(product);
        }
        List<List<String>> words = new ArrayList<>();
        for(int i=0;i<searchWord.length();++i) {
            String currWord = searchWord.substring(0, i + 1);
            // System.out.println(currWord);
            List<String> list = trie.getSuggestions(currWord);
            words.add(list);
        }
        return words;
    }
}