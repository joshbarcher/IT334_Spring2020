package graphs;

public class Edge<V> implements Comparable<Edge<V>>
{
    private V source;
    private V destination;
    private double weight;

    public Edge(V source, V destination, double weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public V getSource()
    {
        return source;
    }

    public void setSource(V source)
    {
        this.source = source;
    }

    public V getDestination()
    {
        return destination;
    }

    public void setDestination(V destination)
    {
        this.destination = destination;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "(" + source + ", " + destination + ")";
    }

    @Override
    public int compareTo(Edge<V> other)
    {
        if (weight < other.weight)
        {
            return -1;
        }
        else if (weight > other.weight)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}














