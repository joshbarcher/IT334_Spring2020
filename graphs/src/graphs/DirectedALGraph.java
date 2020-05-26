package graphs;

import java.util.*;

public class DirectedALGraph<V> implements IGraph<V>
{
    private Map<V, Node> lists;
    private int edgeSize = 0;

    public DirectedALGraph()
    {
        lists = new HashMap<>();
    }

    @Override
    public boolean addVertex(V vertex)
    {
        //no duplicates
        if (lists.containsKey(vertex))
        {
            return false;
        }

        lists.put(vertex, null);
        return true;
    }

    @Override
    public void addVertices(V... vertices)
    {
        for(V vertex : vertices)
        {
            addVertex(vertex);
        }
    }

    @Override
    public boolean addEdge(V source, V dest, double weight)
    {
        //preconditions (defensive programming)
        if (!edgeVertsExist(source, dest)) //some vertices are missing
        {
            return false;
        }
        else if (source.equals(dest)) //no self loops!
        {
            return false;
        }
        else if (hasEdge(source, dest))
        {
            return false;
        }

        Node head = lists.get(source);
        if (head == null)
        {
            lists.put(source, new Node(dest, weight));
        }
        else
        {
            lists.put(source, new Node(dest, head, weight));
        }
        edgeSize++;
        return true;
    }

    @Override
    public void addEdges(Edge<V>... edges)
    {
        for (Edge<V> edge : edges)
        {
            addEdge(edge.getSource(), edge.getDestination(),
                    edge.getWeight());
        }
    }

    @Override
    public boolean hasVertex(V vertex)
    {
        return lists.containsKey(vertex);
    }

    private boolean edgeVertsExist(V source, V dest)
    {
        if (!hasVertex(source) || !hasVertex(dest)) //some vertices are missing
        {
            return false;
        }

        return true;
    }

    @Override
    public boolean hasEdge(V source, V dest)
    {
        if (!edgeVertsExist(source, dest))
        {
            return false;
        }

        //search for the dest vertex in the adjacency list
        Node current = lists.get(source);
        while (current != null)
        {
            if (current.getDest().equals(dest))
            {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int vertexSize()
    {
        return lists.size();
    }

    @Override
    public int edgeSize()
    {
        return edgeSize;
    }

    @Override
    public boolean removeVertex(V vertex)
    {
        return false;
    }

    @Override
    public boolean removeEdge(V source, V dest)
    {
        return false;
    }

    @Override
    public Set<V> vertices()
    {
        return Collections.unmodifiableSet(lists.keySet());
    }

    @Override
    public Set<Edge<V>> edges()
    {
        //create a set to hold our results
        Set<Edge<V>> results = new HashSet<>();

        //loop over all vertices
        for (V source : lists.keySet())
        {
            Node<V> current = lists.get(source);
            while (current != null)
            {
                results.add(new Edge<V>(source, current.getDest(),
                            current.getWeight()));
                current = current.getNext();
            }
        }

        return results;
    }

    @Override
    public List<V> dfs()
    {
        Set<V> visited = new HashSet<>();
        List<V> traversal = new ArrayList<>();

        for (V vertex : vertices())
        {
            dfs(vertex, visited, traversal);
        }
        return traversal;
    }

    @Override
    public List<V> dfs(V source)
    {
        Set<V> visited = new HashSet<>();
        List<V> traversal = new ArrayList<>();

        //preconditions...
        if (!hasVertex(source))
        {
            return traversal;
        }

        dfs(source, visited, traversal);
        return traversal;
    }

    private void dfs(V current, Set<V> visited, List<V> traversal)
    {
        //have I been here before?
        if (!visited.contains(current))
        {
            //record the current vertex
            visited.add(current);
            traversal.add(current);

            //visit neighbors
            Node edge = lists.get(current);
            while (edge != null)
            {
                V neighbor = (V)edge.getDest();
                dfs(neighbor, visited, traversal);

                edge = edge.getNext();
            }
        }
    }

    @Override
    public List<Edge<V>> mstPrims(V source)
    {
        //step #1 - set up data structures
        PriorityQueue<Edge<V>> heap = new PriorityQueue<>();
        List<Edge<V>> results = new ArrayList<>();
        Set<V> known = new HashSet<>();

        //step #2 - mark first vertex
        visit(source, known, heap);

        //step #3 - loop over all edges
        while (results.size() < vertexSize() - 1)
        {
            Edge<V> smallest = heap.poll();

            if (!known.contains(smallest.getSource()) ||
                !known.contains(smallest.getDestination()))
            {
                //store the edge as part of the mst
                results.add(smallest);

                //visit the unknown vertex
                V unknownVert = known.contains(smallest.getSource()) ?
                        smallest.getDestination() : smallest.getSource();
                visit(unknownVert, known, heap);
            }
        }

        return results;
    }

    private void visit(V vertex, Set<V> known, PriorityQueue<Edge<V>> heap)
    {
        known.add(vertex);
        Node current = lists.get(vertex);
        while (current != null)
        {
            Edge<V> edge = new Edge<V>(vertex, (V)current.getDest(),
                    current.getWeight());
            heap.add(edge);
            current = current.getNext();
        }
    }

    @Override
    public int inDegree(V vertex)
    {
        return 0;
    }

    @Override
    public int outDegree(V vertex)
    {
        return 0;
    }

    @Override
    public boolean isComplete()
    {
        return false;
    }
}
