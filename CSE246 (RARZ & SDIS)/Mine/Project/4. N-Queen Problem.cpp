#include<bits/stdc++.h>
using namespace std;

// Function to check if placing a queen at a given position is safe
bool isSafe(int row, int col,  vector<string>& board) {
    for (int i = 0; i < row; i++) {
         // Check the column
        if (board[i][col] == '1') {
            return false;
        }

        // Check diagonals
        if (col - (row - i) >= 0 && board[i][col - (row - i)] == '1') {
            return false;
        }
        if (col + (row - i) < board.size() && board[i][col + (row - i)] == '1') {
            return false;
        }
    }
    return true;
}

// Recursive function to solve the N-Queens problem using backtracking
void solve(int row, vector<string>& board, vector<vector<string>>& ans) {
    // If all queens are placed without being threaten, add the current arrangement to the result
    if (row == board.size()) {
        ans.push_back(board);
        return;
    }

    // Try placing a queen in each column of the current row
    for (int col = 0; col < board.size(); col++) {
        if (isSafe(row, col, board)) {
            // Place the queen and move on to the next row
            board[row][col] = '1';
            solve(row + 1, board, ans);

            //undo the placement for backtracking
            board[row][col] = '0';
        }
    }
}

// Function to solve the N-Queens problem and return all possible arrangements
vector<vector<string>> solveNQueens(int n) {
    vector<vector<string>> ans;
    // Initialize an empty chessboard
    vector<string> board(n, string(n, '0'));

    // Start solving from the first row
    solve(0, board, ans);
    return ans;
}

int main() {
    int n ;
    cin>>n; // Set the size of the chessboard and the number of queens
    vector<vector<string>> ans = solveNQueens(n);

    // Print the result
    for (int i = 0; i < ans.size(); i++) {
        cout << "Arrangement " << i + 1 << "\n";
        for (int j = 0; j < ans[i].size(); j++) {
            cout << ans[i][j] << endl;
        }
        cout << endl;
    }

    return 0;
}
