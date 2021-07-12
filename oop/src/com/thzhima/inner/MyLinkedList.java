package com.thzhima.inner;

public class MyLinkedList<E> {

	private Node first;
	private Node last;
	private int size = 0;
	
	public int size() {
		return this.size;
	}
	
	public void add(E e) {
		if(0 == this.size) {// 当前链表长度为0，添加的是第一个节点
			Node newNode = new Node<E>(e, null, null);
			this.first = newNode;
			this.last = newNode;
		}else { // 在尾节点之后添加节点
			Node newNode = new Node(e, this.last, null);
			this.last.next = newNode;
			this.last = newNode;
		}
		
		size++;
	}
	
	public E get(int idx) {
		E value = null;
		if(idx >= this.size) {
			throw new IndexOutOfBoundsException();
		}else {
			Node<E> currNode = this.first;
			for(int i=0; i<idx; i++) {
				currNode = currNode.next;
			}
			value = currNode.value;
		}
		return value;
	}
	
	
	 class Node<E>{
		E value;
		Node next;
		Node previous;
		
		int s = size;
		
		Node(E value, Node previous, Node next){
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		
		list.add("Java");
		list.add("python");
		list.add("oracle");
		list.add("js");
		
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		
		MyLinkedList.Node n = list.new Node(null, null, null);
		
	}
}
