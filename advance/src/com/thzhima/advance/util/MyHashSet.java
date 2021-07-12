package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.thzhima.advance.util.MyHashMap.Node;

public class MyHashSet<E> implements Set<E>{

	private static final Object PRESENT = new Object();
	
	private MyHashMap<E, Object> map;
	
	public MyHashSet() {
		this.map = new MyHashMap<>();
	}
	
	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this.map.containsKey(o);
	}

	@Override
	public Iterator<E> iterator() {
		
		return new Iterator<E>() {

			int idx = 0;
			
			@Override
			public boolean hasNext() {
				
				return idx < MyHashSet.this.map.size();
			}

			@Override
			public E next() {
				E e = null;
				int count = 0;
				a: for(MyHashMap.Node<E, Object> first : MyHashSet.this.map.table) {
					if(null != first) {
						Node<E,Object> curr = first;
						while(curr!= null) {
							e = curr.entry.getKey();
							if(count==idx) {
								count++;
								break a;
							}
							curr = curr.next;
						}
					}
				}
				idx++;
				return e;
			}
			
			@Override
			public void remove() {
				E e = null;
				int count = 0;
				a: for(MyHashMap.Node<E, Object> first : MyHashSet.this.map.table) {
					if(null != first) {
						Node<E,Object> curr = first;
						while(curr!= null) {
							e = curr.entry.getKey();
							if(count==--idx) {
								count++;
								break a;
							}
							curr = curr.next;
						}
					}
				}
				MyHashSet.this.remove(e);
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[map.size()];
		int i=0;
		for(MyHashMap.Node<E, Object> first: map.table) {
			if(null != first) {
				MyHashMap.Node<E, Object> curr = first;
				while(null != curr) {
					E key = curr.entry.getKey();
					array[i++] = key;
					curr = curr.next;
				}
			}
		}
		
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		int i=0;
		for(Node<E, Object> first: map.table) {
			if(null != first) {
				MyHashMap.Node<T, Object> curr = (Node<T, Object>) first;
				while(null != curr) {
					T key = curr.entry.getKey();
					a[i++] = key;
					curr = curr.next;
				}
			}
		}
		
		return a;
	}

	@Override
	public boolean add(E e) {
		boolean containKey = false;
		if(!map.containsKey(e)) {
			containKey = true;
			map.put(e, PRESENT);
		}
		return containKey;
	}

	@Override
	public boolean remove(Object o) {
		boolean contain = false;
		if(this.map.containsKey(o)) {
			contain = true;
			this.map.remove(o);
		}
		return contain;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean contain = true;
		for(Object o : c) {
			if(!this.map.containsKey(o)) {
				contain = false;
				break;
			}
		}
		return contain;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean add = false;
		for(E e : c) {
			if(!map.containsKey(e)) {
				map.put(e, PRESENT);
				add = true;
			}
		}
		return add;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean update = false;
		Iterator<E> ite = this.iterator();
		while(ite.hasNext()) {
			E e = ite.next();
			if(!c.contains(e)) {
				ite.remove();
				update = true;
			}
		}
		return update;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean update = false;
		for(Object o : c) {
			if(this.remove(o)) {
				update = true;
			}
		}
		return update;
	}

	@Override
	public void clear() {
		this.map.clear();
		
	}

	@Override
	public String toString() {
		return Arrays.toString(this.toArray());
	}
}
