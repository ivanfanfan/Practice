# Graph
## Undirected graph

---
- Definition: A graph is a set of vertices and a collection of edges that each connect a parir of vertices.

#### Glossary
- when there is an edge connecting two vertices, we say that the vertices are **adjacent**
    to one another and that the edge is **incident** to both vertices.
- The **degree** of a vertex is the number of edges incident to it.
- A **subgraph** is a subset of a graph's edges (and associated vertices) that constitutes a graph.

--- 
- **Definition**: A path in a graph is a sequence of vertices connected by edges. A simple path is one with
 no repeated vertices. A cycle is a path with at least one edge whose first and last
 vertices are the same. A simple cycle is a cycle with no repeated edges or vertices (except the requisite repetition of 
 the first and last vertices). The length of a path or a cycle is its number of edges.
---

---
- **Definition**: A graph is **connected** if there is a path from every vertx
to every other vertex in the graph. A graph that is not connected consists of
a set of connected components, which are maximal connected subgraphs.
---

---
- **Definition**: A tree is an acyclic connected graph. A disjoint set of trees is called a forest.
A spanning tree of a connected graph is a subgraph that contains all of that graph's vertices and is
a single tree. A spanning forest of a graph is the union of spanning trees of its connected component.

---

- **Property of V-tree**
1. G has V-1 edges and no cycles.
2. G has V-1 edges and is connected.
3. G is connected, but removing any edge disconnects it.
4. G is acyclic, but adding any edge creates a cycle.
5. Exactly one simple path connects each pair of vertices in G

---






