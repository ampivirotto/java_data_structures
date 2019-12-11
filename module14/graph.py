# ~ inspired by Edd Mann ~ #
import collections

import networkx as nx
import matplotlib.pyplot as plt

def bfs(graph, start):
    ## create empty list to add the nodes visited to
    visited = []

    ## create queue with the start node in it
    queue = [start]

    ## if the queue still has stuff in it
    while not len(queue) == 0:

        ## figure out which vertex is in the front of the list and remove it
        nodeFrontQueue = queue.pop(0)

        ## if it has not been visited yet
        if nodeFrontQueue not in visited:
            ## add it to the visited list
            visited.append(nodeFrontQueue)
            ## add all its neighbors to queue in numerical order
            queue.extend(sorted(nx.all_neighbors(graph, nodeFrontQueue)))

    ## return list of nodes in visited order
    return visited

def dfs(graph, start):
    ## create empty list for visited nodes
    visited = []

    ## make stack for the next to visit
    stack = [start]

    ##
    while not len(stack) == 0:
        vertex = stack.pop()
        if vertex not in visited:
            visited.append(vertex)
            stack.extend(reversed(sorted(nx.all_neighbors(graph, vertex))))
    return visited

G = nx.Graph()
G.add_nodes_from([1, 2, 3, 4, 5, 6, 7])
G.add_edges_from([(1, 2), (2, 3), (1, 5), (1,4), (2, 6), (2, 7)])

bfslist = bfs(G, 1)
print(bfslist)

print(dfs(G, 1))


plt.subplot(121)
nx.draw(G, with_labels=True, font_weight='bold')
plt.show()

