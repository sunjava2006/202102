package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, MyQueue<E> {

	private Node first;
	private Node last;
	private int size;

	private class Node {
		E value;
		Node previous;
		Node next;

		Node() {

		}

		Node(E e) {
			this(e, null, null);
		}

		Node(E e, Node previous, Node next) {
			this.value = e;
			this.previous = previous;
			this.next = next;
		}

	}

	@Override
	public boolean add(E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IllegalStateException {

		Node newNode = new Node(e);
		// 为列表添加第一个节点
		if (0 == size) {
			this.first = this.last = newNode;
		}
		// 在尾节点之后，添加一个新节点
		else {
			this.last.next = newNode;
			newNode.previous = this.last;
			this.last = newNode;
		}

		this.size++;
		return true;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return 0 == size;
	}

	@Override
	public boolean contains(Object o) throws ClassCastException, NullPointerException {
		boolean exists = false;

		Node currNode = this.first;
		while (null != currNode) {
			E e = currNode.value;
			if (o == null ? e == null : o.equals(e)) {
				exists = true;
				break;
			}
			currNode = currNode.next;
		}

		return exists;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];

		Node currNode = this.first;
		for (int i = 0; i < size; i++) {
			arr[i] = currNode.value;
			currNode = currNode.next;
		}

		return arr;
	}

	@Override
	public <T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException {
		if (null == a) {
			throw new NullPointerException();
		}
		if (a.length != this.size) {
			throw new ArrayStoreException();
		}

		Node currNode = this.first;
		for (int i = 0; i < size; i++) {
			a[i] = (T) currNode.value;
			currNode = currNode.next;
		}

		return a;
	}

	@Override
	public boolean addAll(MyCollection<? extends E> c) throws UnsupportedOperationException, ClassCastException,
			NullPointerException, IllegalArgumentException, IllegalStateException {
		if (null == c) {
			throw new NullPointerException();
		}
		for (E e : c) {
			this.add(e);
		}
		return true;
	}

	@Override
	public boolean remove(Object o) throws UnsupportedOperationException, ClassCastException, NullPointerException {
		boolean exist = false;

		Node currNode = this.first;
		while (null != currNode) {
			E e = currNode.value;
			if (o == null ? e == null : o.equals(e)) {
				exist = true;
				break;
			}
			currNode = currNode.next;
		}
		if (exist) {
			if (currNode.previous == null) { // First节点
				this.first = currNode.next;
				if (this.first != null) {
					this.first.previous.next = null;
					this.first.previous = null;
				}

			} else if (null == currNode.next) { // Last节点
				this.last = this.last.previous;
				this.last.next.previous = null;
				this.last.next = null;
			} else { // 中间节点
				currNode.previous.next = currNode.next;
				currNode.next.previous = currNode.previous;
				currNode.previous = null;
				currNode.next = null;

			}
			size--;
		}
		return exist;
	}

	@Override
	public boolean containsAll(MyCollection<?> c) throws ClassCastException, NullPointerException {
		boolean allContain = true;
		if (null == c) {
			throw new NullPointerException();
		}

		for (Object o : c) {
			boolean eq = false;
			for (E e : this) {
				if (o == null ? e == null : o.equals(e)) {
					eq = true;
					break;
				}
			}
			if (!eq) {
				allContain = false;
				break;
			}
		}

		return allContain;
	}

	@Override
	public boolean removeAll(MyCollection<?> c)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		boolean rm = false;
		if (null == c) {
			throw new NullPointerException();
		}
		for (Object o : c) {
			if (this.remove(o)) {
				rm = true;
			}
		}
		return rm;
	}

	@Override
	public boolean retainAll(MyCollection<?> c)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {
		boolean update = false;
		if (null == c) {
			throw new NullPointerException();
		}
		Iterator<E> ite = this.iterator();
		while (ite.hasNext()) {
			E e = ite.next();
			if (!c.contains(e)) { // 删除当前列表中不在c参数中的元素。
				ite.remove();
				update = true;
			}
		}

		return update;
	}

	@Override
	public void clear() throws UnsupportedOperationException {
		this.first = this.last = null;
		size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int idx = 0;

			@Override
			public boolean hasNext() {
				return idx < size;
			}

			@Override
			public E next() {
				return get(idx++);

			}

			@Override
			public void remove() {
				MyLinkedList.this.remove(--idx);
			}
		};
	}

	@Override
	public boolean offer(E e) throws ClassCastException, NullPointerException, IllegalArgumentException {
		this.add(e);
		return true;
	}

	@Override
	public E element() throws NoSuchElementException {
		E e = null;
		if (size == 0) {
			throw new NoSuchElementException();
		}
		e = this.get(0);
		return e;
	}

	@Override
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return this.get(0);
		}

	}

	@Override
	public E remove() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			return this.remove(0);
		}
	}

	@Override
	public E poll() {
		if (size == 0) {
			return null;
		} else {
			return this.remove(0);
		}

	}

	@Override
	public void add(int index, E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node currNode = this.first;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		Node newNode = new Node(e);
		if (null == currNode) { // 当前列表为空，添加的是唯一节点。
			this.first = this.last = newNode;
		} else if (currNode == this.first) {
			this.first.previous = newNode;
			newNode.next = this.first;
			this.first = newNode;
		} else {
			currNode.previous.next = newNode;
			newNode.previous = currNode.previous;
			currNode.previous = newNode;
			newNode.next = currNode;

		}
		size++;

	}

	@Override
	public boolean addAll(int index, MyCollection<? extends E> c) throws UnsupportedOperationException,
			ClassCastException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (null == c) {
			throw new NullPointerException();
		}
		if (c.size() > 0) {

			for (E e : c) {
				this.add(index, e);
			}
			return true;
		}
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		E e = null;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node currNode = this.first;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}

		e = currNode.value;
		return e;
	}

	@Override
	public int indexOf(Object o) throws ClassCastException, NullPointerException {
		int at = -1;
		Node curr = first;
		for (int i = 0; i < size; i++) {
			E e = curr.value;
			if (o == null ? e == null : o.equals(e)) {
				at = i;
				break;
			}
			curr = curr.next;
		}

		return at;
	}

	@Override
	public int lastIndexOf(Object o) throws ClassCastException, NullPointerException {
		int at = -1;
		Node curr = last;
		for (int i = size - 1; i >= 0; i--) {
			E e = curr.value;
			if (o == null ? e == null : o.equals(e)) {
				at = i;
				break;
			}
			curr = curr.previous;
		}

		return at;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new MyListIterator<>(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException {
		return new MyListIterator<>(index);
	}

	@Override
	public E remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E e = null;

		// 找到index指定的节点
		Node currNode = this.first;
		for (int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		// 取节点中的值
		e = currNode.value;

		// 删除该节点
		if (currNode.previous == null) { // First节点
			this.first = currNode.next;
			if (this.first != null) {
				this.first.previous.next = null;
				this.first.previous = null;
			}

		} else if (null == currNode.next) { // Last节点
			this.last = this.last.previous;
			this.last.next.previous = null;
			this.last.next = null;
		} else { // 中间节点
			currNode.previous.next = currNode.next;
			currNode.next.previous = currNode.previous;
			currNode.previous = null;
			currNode.next = null;

		}
		size--;

		return e;
	}

	@Override
	public E set(int index, E e) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E old = null;
		
		Node currNode = first;
		for(int i=0;i<index; i++) {
			currNode = currNode.next;
		}
		
		old = currNode.value;
		
		currNode.value = e;
		
		return old;
	}

	
	private Node nodeOnIdx(int idx) {
		Node curr = this.first;
		for(int i=0;i<idx;i++) {
			curr = curr.next;
		}
		return curr;
	}
	
	@Override
	public MyList<E> subList(int from, int to) throws IndexOutOfBoundsException {
		MyLinkedList<E> list = new MyLinkedList<E>();
		if(from>=to || from<0 || to>=size) {
			 throw new IndexOutOfBoundsException();
		}
		
		
		list.first = this.nodeOnIdx(from);
		list.last = this.nodeOnIdx(to);
		list.size = to-from;
		return list;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");

		Node currNode = this.first;
		for (int i = 0; i < size; i++) {
			E e = currNode.value;
			sb.append(e);
			if (i < size - 1) {
				sb.append(", ");
			}
			currNode = currNode.next;
		}

		sb.append("]");

		return sb.toString();
	}

	private class MyListIterator<T> implements ListIterator<T> {

		private int idx;
		private boolean next;

		MyListIterator(int idx) {
			this.idx = idx;
		}

		@Override
		public boolean hasNext() {
			return idx < size;
		}

		@Override
		public T next() {
			next = true;
			return (T) MyLinkedList.this.get(idx++);
		}

		@Override
		public boolean hasPrevious() {

			return size > 0 ? idx > 0 : false;
		}

		@Override
		public T previous() {
			next = false;
			return (T) MyLinkedList.this.get(--idx);
		}

		@Override
		public int nextIndex() {
			return idx;
		}

		@Override
		public int previousIndex() {

			return idx - 1;
		}

		@Override
		public void remove() {
			if (next) {
				MyLinkedList.this.remove(--idx);
			} else {
				MyLinkedList.this.remove(idx);
			}
		}

		@Override
		public void set(T e) {
			if (next) {
				MyLinkedList.this.set(--idx, (E)e);
			} else {
				MyLinkedList.this.set(idx, (E)e);
			}
		}

		@Override
		public void add(T e) {
			MyLinkedList.this.add((E)e);
		}

	}

	public static void main(String[] args) {
//		MyLinkedList<String> list = new MyLinkedList<>();
//		list.add("java");
//		list.add("js");
//		list.add("c");
//		list.add("c++");
//		list.add("VB");
//		System.out.println(list);
//
//		MyLinkedList<String> list2 = new MyLinkedList<>();
//		list2.add("java");
//		list2.add("js");
//		list2.add("A");
//
//		System.out.println(list.containsAll(list2));
//
////		System.out.println(list.retainAll(list2));
////		System.out.println(list.removeAll(list2));
//
//		list.addAll(0, list2);
//		System.out.println(list);
//
//		System.out.println(list.lastIndexOf("VB"));
//		System.out.println("========================");
//		System.out.println(list);
//		
//	    MyLinkedList<String> li = (MyLinkedList<String>) list.subList(2, 4);
//	    
//	    System.out.println(li);
		
		MyQueue<Integer> q = new MyLinkedList<>();
		
		for(int i=0;i<10;i++) {
			q.offer(i);
		}
			System.out.println(q);
		System.out.println(q.peek());
		System.err.println(q.element());
		System.out.println("=============================");
	
		
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
		System.out.println("---------------------");
//		System.out.println(q.poll());
//		System.out.println(q.remove());
		
	}
}
