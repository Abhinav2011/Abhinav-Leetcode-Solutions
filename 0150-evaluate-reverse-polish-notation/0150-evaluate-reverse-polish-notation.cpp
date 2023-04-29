class Solution {
public:
    int performOperation(stack<string> &tokenStack,string operand) {
        int valueA = stoi(tokenStack.top());
        tokenStack.pop();
        int valueB = stoi(tokenStack.top());
        tokenStack.pop();
        if(operand == "+") {
            return valueA + valueB;
        }
        else if(operand == "-") {
            return valueB - valueA;
        }
        else if(operand == "*") {
            return valueA * valueB;
        }
        else{
            return valueB / valueA;
        }
    }

    int evalRPN(vector<string>& tokens) {
        int length = tokens.size();
        stack<string> tokenStack;

        for(int index=0;index<length;++index) {
            if(tokens[index] != "+" && tokens[index] != "-" && tokens[index] != "*" && tokens[index] != "/") {
                tokenStack.push(tokens[index]);
            }
            else {
                int valueAfterOperation = performOperation(tokenStack,tokens[index]);
                cout<<valueAfterOperation<<endl;
                tokenStack.push(to_string(valueAfterOperation));
            }
        }

        return stoi(tokenStack.top());        
    }
};
