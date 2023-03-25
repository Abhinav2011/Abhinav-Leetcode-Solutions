class Node{
public:
    string variable;
    double value;
    Node(string variable,double value){
        this->variable = variable;
        this->value = value;
    }
};
class Solution {
public:
    double dfs(string source,string destination,map<string,vector<Node> > &graph,unordered_set<string> visitedNodes){

        if(visitedNodes.find(source) != visitedNodes.end() || graph.find(source) == graph.end()){
            return -1.0;
        }

        if(source == destination){
            return 1.0;
        }
        visitedNodes.insert(source);
        vector<Node> neighbourNodes = graph[source];
        for(int index=0;index<neighbourNodes.size();++index){
            string nei = neighbourNodes[index].variable;
            double value = neighbourNodes[index].value;

            double pathValue = dfs(nei,destination,graph,visitedNodes);

            if(pathValue != -1.0){
                return (double)(value * pathValue);
            }
        }

        return -1.0;
    }
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        map<string,vector<Node> > graph;
        int length = equations.size();
        //build the graph
        for(int index=0;index<length;++index){
            string node1 = equations[index][0];
            string node2 = equations[index][1];
            cout<<node1<<" "<<node2<<endl;
            graph[node1].push_back(Node(node2,values[index]));
            graph[node2].push_back(Node(node1,(double)1 / values[index]));
        }

        vector<double> queryResults;

        for(int index=0;index<queries.size();++index){
            string source = queries[index][0];
            string destination = queries[index][1];
            unordered_set<string> visitedNodes;
            double currQueryResult = dfs(source,destination,graph,visitedNodes);
            queryResults.push_back(currQueryResult);

        }

        return queryResults;
        // for(auto &node : graph){
        //     cout<<node.first<<" -> ";
        //     vector<Node> temp = node.second;
        //     for(int i=0;i<temp.size();++i){
        //         cout<<temp[i].variable<<" "<<temp[i].value;
        //     }
        //     cout<<endl;
        // }

    }
};