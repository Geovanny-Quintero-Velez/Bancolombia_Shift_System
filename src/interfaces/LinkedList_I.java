package interfaces;

public interface LinkedList_I <V>{
	
	public abstract void add(V value);
	
	public abstract void remove(int position);
	
	public abstract boolean isEmpty();
	
	public abstract int size(); 
	
	public abstract V getValue(int position); 
}
