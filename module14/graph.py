# ~ inspired by Edd Mann ~ #
import collections

graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}




def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    for next in graph[start] - visited:
        dfs(graph, next, visited)
    return visited

def bfs(graph, start):
    b_visited, queue = set(), [start]
    while queue:
        vertex = queue.pop(0)
        if vertex not in b_visited:
            b_visited.add(vertex)
            queue.extend(graph[vertex] - b_visited)
    return b_visited

print(graph)
print(bfs(graph, 'A'))
print(dfs(graph, 'A'))


