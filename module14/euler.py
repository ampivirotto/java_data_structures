#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      ampiv
#
# Created:     11/12/2019
# Copyright:   (c) ampiv 2019
# Licence:     <your licence>
#-------------------------------------------------------------------------------
import networkx as nx
import matplotlib.pyplot as plt


def readFile(filename, g):
    with open(filename) as f:
        for line in f:
            temp = list(line.strip("\n"))
            #print(temp)
            prev = 0
            for item in temp:
                node = int(item)
                #print(f"node {node}")
                if not prev == 0:
                    g.add_edge(prev, node)
                    #print(f"prev {prev}")
                prev = node
    return g

def findStart(dg):
    posNodes = dg.nodes()
    start = 0
    for x in posNodes:
        if dg.in_degree(x) == 0:
            start = x
    return start

def findSecurity(dg):
    print(findStart(dg))

def main():
    filename = "p079_keylog.txt"
    DG=nx.DiGraph()
    dg = readFile(filename, DG)

    findSecurity(dg)

    #plt.subplot(121)
    #nx.draw(dg, with_labels=True, font_weight='bold')
    #plt.show()

if __name__ == '__main__':
    main()
