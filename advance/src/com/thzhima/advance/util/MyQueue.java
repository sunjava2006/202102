package com.thzhima.advance.util;

import java.util.NoSuchElementException;

public interface MyQueue<E> extends MyCollection<E>{

	boolean add(E e) throws IllegalStateException, ClassCastException, NullPointerException, IllegalArgumentException;
	
	boolean offer(E e) throws ClassCastException, NullPointerException, IllegalArgumentException;

	E element() throws NoSuchElementException;
	
	E peek();
	
	E remove() throws NoSuchElementException;
	
	E poll();
	
}
