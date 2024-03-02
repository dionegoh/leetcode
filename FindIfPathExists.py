#https://leetcode.com/problems/find-if-path-exists-in-graph/
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        adj_list = {}
        for edge in edges:
            if edge[0] in adj_list:
                adj_list[edge[0]].append(edge[1])
            else:
                adj_list[edge[0]] = [edge[1]]   
            #adding reverse edge for each edge
            if edge[1] in adj_list:
                adj_list[edge[1]].append(edge[0])
            else:
                adj_list[edge[1]] = [edge[0]]
        
        visited = set()
        if len(edges) == 0:
            return True

        return dfs(source, destination, adj_list, visited)
        
def dfs(source, destination, adj_list, visited):
    visited.add(source)
    for neighbour in adj_list[source]:
        if neighbour == destination:
            return True
        elif neighbour not in visited:
            if dfs(neighbour, destination, adj_list, visited):
                return True
    return False
