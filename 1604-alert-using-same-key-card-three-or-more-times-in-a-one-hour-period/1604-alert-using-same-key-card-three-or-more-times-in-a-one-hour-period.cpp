class Solution {
public:
    string getOneHour(string start){
        string startAfterOneHour;
        int hour_a = start[0] - '0';
        int hour_b = start[1] - '0';
        if(hour_a == 0 && hour_b == 9){
            startAfterOneHour += ('1');
            startAfterOneHour += ('0');
        }
        else if(hour_a == 0){
            hour_b++;
            startAfterOneHour += '0';
            startAfterOneHour += to_string(hour_b);
        }
        else if(hour_a == 2 && hour_b == 3){
           startAfterOneHour += ('0' + '0');
        }
        else if(hour_a == 2){
            hour_b++;
            startAfterOneHour += '2';
            startAfterOneHour += to_string(hour_b);
        }
        else if(hour_a == 1 && hour_b == 0){
            startAfterOneHour += ('1');
            startAfterOneHour += ('1');
        }
        else if(hour_a == 1 && hour_b == 9){
            startAfterOneHour += ('2');
            startAfterOneHour += ('0');
        }
        else if(hour_a == 1){
            hour_b++;
            startAfterOneHour += '1';
            startAfterOneHour += to_string(hour_b);
        }
        string remaining  = start.substr(2,start.length());
        startAfterOneHour += remaining;
        // cout<<startAfterOneHour<<endl;
        return startAfterOneHour;
    }
    bool sendAlert(string name,vector<string>& timeUsed){
        if(timeUsed.size() == 1 || timeUsed.size() == 2){
            return false;
        }
        
        int length = timeUsed.size();
        for(int index=0;index<length;++index){
            string start = timeUsed[index];
            string end = getOneHour(start); 
            // cout<<start<<" "<<end<<" -> ";
            int timesCardUsed = 1;
            for(int current=index+1;current<length;++current){
                string currentTime = timeUsed[current];
                // cout<<currentTime<<endl;
                if(currentTime >= start && currentTime <= end){                
                    timesCardUsed++;
                }
                else{
                    break;
                }
                if(timesCardUsed >= 3){
                    return true;
                }
            }     
            cout<<endl;
        }
        return false;
    }
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        map<string,vector<string> > employeeCardUsedData;
        
        int length = keyName.size();
        for(int index=0;index<length;++index){
            employeeCardUsedData[keyName[index]].push_back(keyTime[index]);
        }
        vector<string> alertedEmployees;
        for(auto &employeeData : employeeCardUsedData){
            string employeeName = employeeData.first;
            vector<string> timeUsed = employeeData.second;
            sort(timeUsed.begin(),timeUsed.end());
            // for(auto &it : timeUsed){
            //     cout<<it<<" ";
            // }
            // cout<<endl;
            if(sendAlert(employeeName,timeUsed)){
                alertedEmployees.push_back(employeeName);   
            }
        }
        return alertedEmployees;
    }
};

