package graphs;

public class Node<V>
{
    private V dest;
    private Node<V> next;

    public Node(V dest)
    {
        this.dest = dest;
    }

    public Node(V dest, Node<V> next)
    {
        this.dest = dest;
        this.next = next;
    }

    public V getDest()
    {
        return dest;
    }

    public void setDest(V dest)
    {
        this.dest = dest;
    }

    public Node<V> getNext()
    {
        return next;
    }

    public void setNext(Node<V> next)
    {
        this.next = next;
    }

    @Override
    public String toString()
    {
        return dest.toString();
    }
}
