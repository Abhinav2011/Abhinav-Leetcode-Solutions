class Solution {
private:
    const int dx[4] = {0, 1, 0, -1};
    const int dy[4] = {1, 0, -1, 0};
public:
    bool isValid(int row,int col,int i,int j){
        return (i >= 0 && i < row && j >= 0 && j < col);
    }
    bool dfs(int i,int j,int row,int col,int index,vector<vector<char>>& board,string word){
        
        if(index == word.length()){
            return true;
        }
        if(!isValid(row,col,i,j) || word[index] != board[i][j] || board[i][j] == '#'){
            return false;
        }
        board[i][j] = '#';
        for(int k=0;k<4;++k){
            int new_i = i + dx[k];
            int new_j = j + dy[k];
            
            if(dfs(new_i,new_j,row,col,index + 1,board,word)){
                return true;
            }
        }
        board[i][j] = word[index];
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        int row = board.size();
        int col = board[0].size();
        
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                if(board[i][j] == word[0]){
                    if(dfs(i,j,row,col,0,board,word)){
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }
};