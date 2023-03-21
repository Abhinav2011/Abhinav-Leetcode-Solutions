class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int,vector<int>> adjList;
        int length = prerequisites.size();
        
        for(int i=0;i<length;++i){
            int vertex_a = prerequisites[i][0];
            int vertex_b = prerequisites[i][1];
            adjList[vertex_b].push_back(vertex_a);
        }
        
        vector<int> indegree(numCourses);
        for(int course=0;course<numCourses;++course){
            for(int index=0;index<adjList[course].size();++index){
                // cout<<adjList[course][index];
                indegree[adjList[course][index]]++;
            }
        }
        
        queue<int> coursesQueue;
        vector<int> coursesOrder;
        for(int course=0;course<numCourses;++course){
            if(indegree[course] == 0){
                coursesQueue.push(course);
                coursesOrder.push_back(course);
            }
        }
        
        while(!coursesQueue.empty()){
            int currSize = coursesQueue.size();
            while(currSize > 0){
                int currentCourse = coursesQueue.front();
                coursesQueue.pop();
                for(int index=0;index<adjList[currentCourse].size();++index){
                    int neighbourCourse = adjList[currentCourse][index];
                    indegree[neighbourCourse]--;
                    if(indegree[neighbourCourse] == 0){
                        coursesQueue.push(neighbourCourse);
                        coursesOrder.push_back(neighbourCourse);
                    }
                }
                currSize--;
            }
        }
        
        for(int course=0;course<numCourses;++course){
            if(indegree[course] > 0){
                return {};
            }
        }
        
        return coursesOrder;
    }
};