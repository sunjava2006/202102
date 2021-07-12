package com.thzhima.advance.util;

public interface MyCollection<E> extends Iterable<E> {

	boolean add(E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IllegalStateException;

	int size();

	boolean isEmpty();

	boolean contains(Object o) throws ClassCastException, NullPointerException;

	Object[] toArray();

	<T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException;

	boolean addAll(MyCollection<? extends E> c) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IllegalStateException;

	boolean remove(Object o) throws UnsupportedOperationException, ClassCastException, NullPointerException;

	boolean containsAll(MyCollection<?> c) throws ClassCastException, NullPointerException;

	boolean removeAll(MyCollection<?> c) throws UnsupportedOperationException, ClassCastException, NullPointerException;

	boolean retainAll(MyCollection<?> c) throws UnsupportedOperationException, ClassCastException, NullPointerException;

	void clear() throws UnsupportedOperationException;

	boolean equals(Object o);

	int hashCode();

}
