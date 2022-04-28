package structures;

import interfaces.LinkedList_I;

public class CircularDoubleLinkedList<V> implements LinkedList_I<V> {

	int size;
	CircularDoubleNode<V> first;
	CircularDoubleNode<V> last;
	
	public CircularDoubleLinkedList() {
		size = 0;
		last = null;
		first = null;
	}

	public void passTurn() {
		if(!isEmpty()) {
			CircularDoubleNode<V> temp = first;
			first = first.getNext();
			if(temp.getAvoidedTurns() < 3) {
				temp.setAvoidedTurns(temp.getAvoidedTurns()+1);
				last = temp;
			}else {
				first.setPrevious(last);
				last.setNext(first);
			}	
		}
	}
	
	public void removeActualTurn() {
		if(!isEmpty()) {
			first = first.getNext();
			first.setPrevious(last);
			last.setNext(first);
		}else if(size == 1) {
			first = null;
			last = null;
		}
		
	}

	public String showActualTurn() {
		if(isEmpty()) {
			return "No hay turnos aun.";
		}
		return ""+first.getValue();
	}
	
	@Override
	public void add(V value) {
		if(size == 0) {
			first = new CircularDoubleNode<V>(value);
			last = first;
			first.setNext(last);
			last.setPrevious(first);
			
		}
		else {
			last.addNext(value);
			last.getNext().setPrevious(last);
			last.getNext().setNext(first);
		}
		size++;
		last = last.getNext();
	}

	@Override
	public void remove(int position) {
		if(size==1 && position == 1) {
			first = null;
			last = null;
		}else if(size>0 && 1<=position && position<=size) {
			CircularDoubleNode<V> container = first;
			for(int i=1;i<position;i++) {
			container = container.getNext();
			}
			if(container.getNext() != null) {
				container.getNext().setPrevious(container.getPrevious());
			}
			container.getPrevious().setNext(container.getNext());
			container.setNext(null);
			container.setPrevious(null);
			size--;			
		}
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public V getValue(int position) {
		if(size>0 && 1<=position && position<=size) {
			CircularDoubleNode<V> container = first;
			for(int i=1;i<position;i++) {
				container = container.getNext();
			}
			return container.getValue();
		}
		return null;
	}

	
}
