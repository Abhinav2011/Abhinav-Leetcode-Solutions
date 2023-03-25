class Coordinates{
public:
    int x,y;
    Coordinates(int x,int y){
        this->x = x;
        this->y = y;
    }
};

class Solution {
public:
    const int dx[4] = {0,1,0,-1};
    const int dy[4] = {-1,0,1,0};
    bool isSafe(int x,int y,int row,int col){
        return (x >= 0 && x < row && y >= 0 && y < col);
    }
    int orangesRotting(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        
        queue<Coordinates> q;
        int freshOranges = 0;
        for(int i=0;i<row;++i){
            for(int j=0;j<col;++j){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                else if(grid[i][j] == 2){
                    Coordinates currCoordinates(i,j);
                    q.push(currCoordinates);
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
        int minutes = 0;
        while(!q.empty() && freshOranges > 0){
            int size = q.size();
            minutes++;
            while(size--){
                Coordinates current = q.front();
                q.pop();
                
                for(int direction=0;direction<4;++direction){
                    int new_x = current.x + dx[direction];
                    int new_y = current.y + dy[direction];
                    
                    if(isSafe(new_x,new_y,row,col) && grid[new_x][new_y] == 1){
                        grid[new_x][new_y] = 2;
                        freshOranges--;
                        Coordinates newCurrent(new_x,new_y);
                        q.push(newCurrent);
                    }
                }
            }
        }
        
        if(freshOranges == 0){
            return minutes;
        }
        return -1;
        
    }
};