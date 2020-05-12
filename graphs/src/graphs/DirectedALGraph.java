package graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DirectedALGraph<V> implements IGraph<V>
{
    private Map<V, Node> lists;

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
    public boolean addEdge(V source, V dest)
    {
        if (!hasVertex(source) || !hasVertex(dest))
        {
            return false;
        }

        return false;
    }

    @Override
    public void addEdges(Edge... edges)
    {

    }

    @Override
    public boolean hasVertex(V vertex)
    {
        return lists.containsKey(vertex);
    }

    @Override
    public boolean hasEdge(V source, V dest)
    {
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
        return 0;
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
    public Set<Edge> edges()
    {
        return null;
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
