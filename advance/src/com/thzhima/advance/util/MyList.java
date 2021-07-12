package com.thzhima.advance.util;

import java.util.ListIterator;

public interface MyList<E> extends MyCollection<E> {
	
	void add(int index, E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IndexOutOfBoundsException;

	boolean addAll(int index, MyCollection<? extends E> c) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IndexOutOfBoundsException;

	E get(int index) throws IndexOutOfBoundsException;

	int indexOf(Object o) throws ClassCastException, NullPointerException;

	int lastIndexOf(Object o) throws ClassCastException, NullPointerException;

    ListIterator<E> listIterator();

	ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException;

	E remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException;

	E set(int index, E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IndexOutOfBoundsException;

	MyList<E> subList(int from, int to) throws IndexOutOfBoundsException;

}
