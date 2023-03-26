class Solution {
public:
    bool usedWithinLimit(string timeUsedFirst,string timeUsedSecond){
        int time_a = stoi(timeUsedFirst.substr(0,2)) * 60 + stoi(timeUsedFirst.substr(3));
        int time_b = stoi(timeUsedSecond.substr(0,2)) * 60 + stoi(timeUsedSecond.substr(3));

        if(time_b - time_a <= 60){
            return true;
        }
        return false;
    }
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        map<string,vector<string>> workerMap;
        int length = keyName.size();
        for(int index=0;index<length;++index){
            string name = keyName[index];
            string time = keyTime[index];
            workerMap[name].push_back(time);
        }
        vector<string> alertedWorkers;
        for(auto &values : workerMap){
            string name = values.first;
            vector<string> cardUsedTime = values.second;
            sort(cardUsedTime.begin(),cardUsedTime.end());
            for(int index=0;index<cardUsedTime.size();++index){
                if(index + 2 < cardUsedTime.size()){
                    string timeUsedFirst = cardUsedTime[index];
                    string timeUsedSecond = cardUsedTime[index + 2];
                    if(usedWithinLimit(timeUsedFirst,timeUsedSecond)){
                        alertedWorkers.push_back(name);
                        break;
                    }
                }
            }
        }

        return alertedWorkers;
    }
};