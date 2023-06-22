class Solution {
        public boolean check(HashMap<Character,Integer> mapS, HashMap<Character,Integer> mapT) {
        for(Map.Entry<Character, Integer> it : mapT.entrySet()) {
            char c = it.getKey();
            int value = it.getValue();
            if(!mapS.containsKey(c)) {
                return false;
            }
            if(mapS.get(c) < value) {
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        // HashMap<Character,Integer> mapT = new HashMap<>();
        // HashMap<Character,Integer> mapS = new HashMap<>();
        // for(int index=0;index<t.length();++index) {
        //     char c = t.charAt(index);
        //     mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        // }
        // int left = 0, right = 0, minWindowLength = Integer.MAX_VALUE;
        // int startIndex = 0;
        // while(right < s.length()) {
        //     char c = s.charAt(right);
        //     mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        //     if(check(mapS, mapT)) {
        //         while(check(mapS, mapT)) {
        //             int currDistance = right - left + 1;
        //             if(minWindowLength > currDistance) {
        //                 minWindowLength = currDistance;
        //                 startIndex = left;
        //             }
        //             mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);
        //             left++;
        //         }
        //     }
        //     right++;
        // }
        // System.out.println(startIndex + " " + minWindowLength);
        // if(minWindowLength == Integer.MAX_VALUE) {
        //     return "";
        // }
        // return s.substring(startIndex, minWindowLength + startIndex);
        HashMap<Character,Integer> mapT = new HashMap<>();
        for(int index=0;index<t.length();++index) {
            char c = t.charAt(index);
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, minWindowLength = Integer.MAX_VALUE;
        int startIndex = 0, matched = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(mapT.containsKey(c)) {
                mapT.put(c, mapT.get(c) - 1);
                if(mapT.get(c) == 0) {
                    matched++;
                }
            }
            while(matched == mapT.size()) {
                int currDistance = right - left + 1;
                if(minWindowLength > currDistance) {
                    minWindowLength = currDistance;
                    startIndex = left;
                }
                char deletedChar = s.charAt(left++);
                if(mapT.containsKey(deletedChar)) {
                    if(mapT.get(deletedChar) == 0) {
                        matched--;
                    }
                    mapT.put(deletedChar, mapT.get(deletedChar) + 1);
                }
            }
            right++;
        }
        if(minWindowLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIndex, minWindowLength + startIndex);
    }
}