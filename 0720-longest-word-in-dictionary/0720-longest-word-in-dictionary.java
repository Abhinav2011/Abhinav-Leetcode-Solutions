class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words,Collections.reverseOrder());
        String longestWordBuilt = "";
        HashSet<String> wordSet = new HashSet<>();

        for(String word : words) {
            wordSet.add(word);
        }

        for(int index = 0;index < words.length;++index) {
            String currentWord = words[index];
            boolean allExists = true;
            for(int currIndex = 0;currIndex < currentWord.length();++currIndex) {
                String wordSubstring = currentWord.substring(0,currIndex + 1);
                if(!wordSet.contains(wordSubstring)) {
                    allExists = false;
                    break;
                }
            }
            if(allExists) {
                if(longestWordBuilt.length() <= currentWord.length()) {
                    longestWordBuilt = currentWord;
                }
            }
        }

        return longestWordBuilt;
    }

}

// a ap app