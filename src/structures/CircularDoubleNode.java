package structures;

public class CircularDoubleNode <V> {
	
	private V value;
	private CircularDoubleNode<V> next, previous;
	private int avoidedTurns;
	
	public CircularDoubleNode(V value) {
		this.value = value;
		next = null;
		previous = null;
		setAvoidedTurns(0);
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void addNext(V value) {
		next = new CircularDoubleNode<V>(value);
		next.setPrevious(this);
	}
	
	public void setNext(CircularDoubleNode<V> nodo) {
		this.next = nodo;
	}
	
	public void setPrevious(CircularDoubleNode<V> nodo) {
		this.previous = nodo;
	}
	
	public CircularDoubleNode<V> getNext() {
		return next;
	}
	
	public CircularDoubleNode<V> getPrevious() {
		return previous;
	}

	public int getAvoidedTurns() {
		return avoidedTurns;
	}

	public void setAvoidedTurns(int avoidedTurns) {
		this.avoidedTurns = avoidedTurns;
	}
	
}
