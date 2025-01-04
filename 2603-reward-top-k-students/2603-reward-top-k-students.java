class Solution {
    class StudentScore {
        public int student_id;
        public int score;

        public StudentScore(int a, int b) {
            this.student_id = a;
            this.score = b;
        }

    }
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
                                     String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> neg = new HashSet<>(Arrays.asList(negative_feedback));
        TreeMap<Integer,Integer> studentScoreMap = new TreeMap<>();

        for(int i=0;i<report.length;++i) {
            String[] word = report[i].split(" ");
            System.out.println(Arrays.toString(word));
            int score = 0;
            for(String s : word) {
                if(pos.contains(s)) {
                    score += 3;
                }
                else if(neg.contains(s)) {
                    score -= 1;
                }
            }
            studentScoreMap.put(student_id[i], score);
        }

        PriorityQueue<StudentScore> minHeap = new PriorityQueue<>((StudentScore a, StudentScore b) -> {
            int scoreComparison = Integer.compare(a.score, b.score);
            if (scoreComparison != 0) {
                return scoreComparison; // Compare scores
            } else {
                return Integer.compare(b.student_id, a.student_id); // Compare student_ids if scores are equal
            }
        });
        for(Map.Entry<Integer, Integer> it : studentScoreMap.entrySet()) {
            int id = it.getKey();
            int score = it.getValue();
            System.out.println("student id - " + id + " and score - " + score);
            if(minHeap.size() == k && minHeap.peek().score < score) {
                minHeap.poll();
                minHeap.offer(new StudentScore(id, score));
            }
            else if(minHeap.size() != k) {
                minHeap.offer(new StudentScore(id, score));
            }
        }

        List<Integer> finalIds = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            int student = minHeap.poll().student_id;
            System.out.println(student);
            finalIds.add(student);
        }
        Collections.reverse(finalIds);
        return finalIds;
    }
}