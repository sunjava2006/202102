package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;



public class MyVector<E> implements MyList<E>{

	private E[] array;

	private int size;

	private static final int DEFAUL_INCREMENT = 16;

	public MyVector(int capacity) {
		this.array = (E[]) new Object[capacity];
	}

	public MyVector() {
		this(16);
	}

	@Override
	public synchronized boolean add(E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IllegalStateException {
		if (this.array.length == this.size) {
			this.ensureCapacity(1);
		}
		this.array[size] = e;
		size++;
		return true;
	}

	@Override
	public synchronized boolean remove(Object o) throws UnsupportedOperationException, ClassCastException, NullPointerException {
		boolean rm = false;
		int at = -1;
		for (int i = 0; i < this.size; i++) {
			E e = this.array[i];
			if (o == null ? e == null : o.equals(e)) {
				at = i;
				rm = true;
				break;
			}
		}
		if (rm) {
			for (int i = at + 1; i < this.size; i++) {
				this.array[i - 1] = this.array[i];
			}
			size--;
		}
		return rm;
	}

	@Override
	public synchronized int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return 0 == size;
	}

	@Override
	public synchronized boolean contains(Object o) throws ClassCastException, NullPointerException {
		boolean exists = false;
		for (int i = 0; i < this.size; i++) {
			E e = this.array[i];
			if (o == null ? e == null : o.equals(e)) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	@Override
	public synchronized Object[] toArray() {
		return Arrays.copyOf(this.array, size);
	}

	@Override
	public synchronized <T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException {
		if (null == a) {
			throw new NullPointerException();
		}
		if (this.size != a.length) {
			throw new ArrayStoreException();
		}

		try {
			System.arraycopy(this.array, 0, a, 0, size);
		} catch (ClassCastException e2) {
			throw new ArrayStoreException();
		}

		return a;
	}

	@Override
	public synchronized boolean addAll(MyCollection<? extends E> c) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IllegalStateException {
		if (null == c) {
			throw new NullPointerException();
		}
		this.ensureCapacity(c.size());
		for (E e : c) {
			this.array[size] = e;
			size++;
		}
		return true;
	}

	@Override
	public  synchronized boolean containsAll(MyCollection<?> c) throws ClassCastException, NullPointerException {
		boolean contains = true;
		if (null == c) {
			throw new NullPointerException("参数c不能为空.");
		}
		for (Object o : c) {
			E e = (E) o;
			if (!this.contains(e)) {
				contains = false;
				break;
			}

		}
		return contains;
	}

	@Override
	public synchronized boolean removeAll(MyCollection<?> c)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		boolean update = false;
		for(Object o : c) {
			if(this.remove((E)o)) {
				update = true;
			}
		}
		return update;
	}

	@Override
	public synchronized boolean retainAll(MyCollection<?> c)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		boolean update = false;
		if(null == c) {
			throw new NullPointerException();
		}
		// 当前列表中的元素与C中元素比较，有相同元素留下。否则删除。
		Iterator<E> iter = this.iterator();
		while(iter.hasNext()) {
			E e = iter.next();
			if(! c.contains(e)) {
				iter.remove();
				update = true;
			}
		}
		
		return update;
	}

	@Override
	public synchronized void clear() throws UnsupportedOperationException {
		this.size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int idx = 0;

			@Override
			public boolean hasNext() {
				return idx < MyVector.this.size;
			}

			@Override
			public E next() {
				E e = MyVector.this.get(idx);
				idx++;
				return e;
			}

			@Override
			public void remove() {
				MyVector.this.remove(--idx);
			}

		};
	}

	@Override
	public synchronized void add(int index, E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IndexOutOfBoundsException {
		if(index <0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		this.ensureCapacity(1);
		for(int i=size-1; i>=index; i--) {
			this.array[i+1] = this.array[i];
		}
		this.array[index] = e;
		
		size++;

	}

	@Override
	public synchronized boolean addAll(int index, MyCollection<? extends E> c) throws UnsupportedOperationException,
			ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		boolean add = false;
		if(index <0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(null == c) {
			throw new NullPointerException();
		}
		this.ensureCapacity(c.size());
		for(E e : c) {
			this.array[size++] = e;
		}
		
		return add;
	}

	@Override
	public synchronized E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return this.array[index];
	}

	@Override
	public synchronized int indexOf(Object o) throws ClassCastException, NullPointerException {
		int idx = -1;
		for(int i=0; i<this.size; i++) {
			E e = this.array[i];
			if(o==null ?  e==null : ((E)o).equals(e)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	@Override
	public synchronized int lastIndexOf(Object o) throws ClassCastException, NullPointerException {
		int idx = -1;
		for(int i= this.size-1; i>=0; i--) {
			E e = this.array[i];
			if(o==null ?  e==null : ((E)o).equals(e)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	@Override
	public synchronized ListIterator<E> listIterator() {
		return new MyListIterator(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException {
		
		return new MyListIterator(index);
	}

	@Override
	public synchronized E remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E e = this.array[index];
		for (int i = index + 1; i < size; i++) {
			this.array[i - 1] = this.array[i];
		}
		size--;
		return e;
	}

	@Override
	public synchronized E set(int index, E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IndexOutOfBoundsException {
		this.array[index] = e;
		return null;
	}

	@Override
	public synchronized MyList<E> subList(int from, int to) throws IndexOutOfBoundsException {
		if(from>=to && (from<0 || to>=size) ){
		    throw new IndexOutOfBoundsException();	
		}
		MyVector list = new MyVector<>();
		list.array = Arrays.copyOfRange(this.array, from, to);
		list.size = list.array.length;
		return list;
	}

	public synchronized Object clone() throws CloneNotSupportedException {
		MyVector list = new MyVector<>();
		list.array = Arrays.copyOf(this.array, this.array.length);
		list.size = this.size;
		return list;
	}

	public synchronized void ensureCapacity(int minCapacity) {
		E[] newArray = (E[]) new Object[this.array.length + minCapacity + DEFAUL_INCREMENT];
		System.arraycopy(this.array, 0, newArray, 0, this.array.length);
		this.array = newArray;
	}

	protected synchronized void removeRange(int fromIndex, int toIndex) {
		if((fromIndex < 0 || fromIndex >= size() || toIndex > size() || toIndex < fromIndex)) {
			throw new IndexOutOfBoundsException();
		}
		int x = toIndex-fromIndex;
        for(int i=toIndex ; i<size; i++) {
        	this.array[i-x] = array[i];
        }
        
        size-=x;
	}

	public synchronized void trimToSize() {
		this.array = Arrays.copyOf(this.array, size);
	}
	
	@Override
	public synchronized String toString() {
		return Arrays.toString(this.toArray());
	}
	
	

	@Override
	public synchronized int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(Arrays.copyOf(array, size));
		result = prime * result + size;
		return result;
	}

	/**
	 * Java中约定，重写equals方法，必须重写hashCode方法，
	 *   两个对象equals相等，hashCode返回值也必须相等。
	 *   但是hashCode相等，equals不必相等。
	 */
	
	@Override
	public synchronized boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyVector other = (MyVector) obj;
		if (size != other.size)
			return false;
		for(int i=0;i<this.size;i++) {
			if(!this.array[i].equals(other.array[i])){
				return false;
			}
		}
		return true;
	}
	
	
	
	private class MyListIterator implements ListIterator<E>{
		int idx = 0;
		boolean next = false;
		    MyListIterator(int idx){
		    	this.idx = idx;
		    }
			
			
			@Override
			public boolean hasNext() {
				
				return idx<size;
			}

			@Override
			public E next() {
				next = true;
				return (E) MyVector.this.get(idx++);
			}

			@Override
			public int nextIndex() {
				return idx;
				
			}

			
			@Override
			public boolean hasPrevious() {
				
				return size>0? idx>0 : false;
			}

			@Override
			public E previous() {
				next = false;
				return get(--idx);
			}

			
			@Override
			public int previousIndex() {
				
				return idx-1;
			}

			@Override
			public void remove() {
				if(next) {
					MyVector.this.remove(--idx);
				}else {
					MyVector.this.remove(idx);
				}
				
			}

			@Override
			public void set(E e) {
				if(next) {
					MyVector.this.set(--idx, e);
				}else {
					MyVector.this.set(idx, e);
				}
				
			}

			@Override
			public void add(E e) {
				MyVector.this.add(e);
				
			}

			
		}
	

}
