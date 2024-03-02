#https://leetcode.com/problems/word-search/

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        no_of_rows = len(board)
        no_of_cols = len(board[0])

        first_char = word[0]

        for row in range(no_of_rows):
            for col in range(no_of_cols):
                if board[row][col] == first_char:
                    visited = [[0] * no_of_cols for x in range(no_of_rows)]
                    if dfs(row, col, no_of_rows - 1, no_of_cols - 1, board, word, visited):
                        return True
        return False

def dfs(row, col, max_row, max_col, board, word, visited):
    # print(visited)
    # print("row: " + str(row) + ", col: " + str(col))
    if (row < 0 or col < 0 or row > max_row or col > max_col or visited[row][col] == 1):
        return False
    char = board[row][col]
    # print("hehe " + char + " " + word)
    if char == word[0]:
        visited[row][col] = 1
        # print(char)
        if len(word) == 1:
            return True
        remainingWordFound = (dfs(row, col + 1, max_row, max_col, board, word[1:], visited) or 
         dfs(row, col - 1, max_row, max_col, board, word[1:], visited) or
         dfs(row - 1, col, max_row, max_col, board, word[1:],visited) or
         dfs(row + 1, col, max_row, max_col, board, word[1:], visited))
        #backtrack
        visited[row][col] = 0
        return remainingWordFound

    return False


