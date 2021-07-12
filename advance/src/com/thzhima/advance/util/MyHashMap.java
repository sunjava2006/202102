package com.thzhima.advance.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MyHashMap<K,V> implements Map<K,V>{

   transient  Node<K, V>[] table ;
	
	public MyHashMap() {
		table = (Node[]) new Node[16];
	}
	
	public MyHashMap(int capacity) {
		table = (Node[]) new Node[capacity];
	}
	
	private int size = 0;
	
	
	/**
	 *  将参数对象的hashCode取出，计算出在 table中的位置
	 * @param o
	 * @return table 中的索引
	 */
	private int hash(Object o) {
		int idx = -1;
		int hashcode = o.hashCode();
		idx = hashcode % table.length;
		return Math.abs(idx);
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		boolean exist = false;
	
		int idx = this.hash(key);
		Node first = this.table[idx];
		if(null != first) {

			Node currentNode = first;
			while(true) {
				Entry<K,V> entry = currentNode.entry;
				K k = entry.getKey();
				if(key==null? k==null : key.equals(k)) {
					exist = true;
					break;
				}
				if(null==currentNode.next) {
					break;
				}else {
					currentNode=currentNode.next;
				}
			}
		}
		return exist;
	}

	@Override
	public boolean containsValue(Object value) {
		return this.values().contains(value);
	}

	@Override
	public V get(Object key) {
		V v = null;
		
		int idx = this.hash(key);
		Node<K,V> first = this.table[idx];
		if(first != null) {
			Node currentNode = first;
			while(true) {
				Entry<K,V> entry = currentNode.entry;
				K k = entry.getKey();
				if(key==null? k==null : key.equals(k)) {

					v  = entry.getValue();

				}
				if(null==currentNode.next) {
					break;
				}else {
					currentNode=currentNode.next;
				}
			}
		}
		return v;
	}

	@Override
	public V put(K key, V value) {
		V v = null;
		int idx = this.hash(key);
		Node first = this.table[idx];
		if(null == first) {
			Node newNode = new Node(key, value);
			this.table[idx] = newNode;
		}else {
			boolean exist = false;
			Node currentNode = first;
			while(true) {
				Entry<K,V> entry = currentNode.entry;
				K k = entry.getKey();
				if(key==null? k==null : key.equals(k)) {
					exist = true;
					v  = entry.getValue();
					entry.setValue(value);
				}
				if(null==currentNode.next) {
					break;
				}else {
					currentNode=currentNode.next;
				}
			}
			if(!exist) {
				Node newNode = new Node(key, value);
				newNode.previous = currentNode;
				currentNode.next = newNode;
			}
		}
		size++;
		return v;
	}

	@Override
	public V remove(Object key) {
		V v = null;
		int idx = this.hash(key);
		Node first = this.table[idx];
		if(null != first) {
			Node<K,V> curr = first;
			while(curr!=null) {
				K k = curr.entry.getKey();
				if(k==null ? key==null : k.equals(key)) {
					v = curr.entry.getValue();
					if(curr.previous!=null) {
						curr.previous.next = curr.next;
						
					}
					if(curr.previous == null) {
						this.table[idx] = curr.next;
					}
					
					if(curr.next!=null) {
						curr.next.previous = curr.previous;
					}
					
					curr.previous = null;
					curr.next = null;
				}
				curr = curr.next;
			}
		}
		size--;
		return v;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		Arrays.fill(this.table, null);
		size = 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set =  new MyHashSet();
		for(Node<K, V> first: this.table) {
			if(null != first) {
				Node<K,V> curr = first;
				while(curr!= null) {
					K k = curr.entry.getKey();
					set.add(k);
					curr = curr.next;
				}
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		List<V> list = new ArrayList<>();
		for(Node<K, V> first: this.table) {
			if(null != first) {
				Node<K,V> curr = first;
				while(curr!= null) {
					V v = curr.entry.getValue();
					list.add(v);
					curr = curr.next;
				}
			}
		}
		return list;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set =  new MyHashSet<>();
		for(Node<K, V> first: this.table) {
			if(null != first) {
				Node<K,V> curr = first;
				while(curr!= null) {
				
					set.add(curr.entry);
					curr = curr.next;
				}
			}
		}
		return set;
	}
	
	
	static class Node<K, V>{
		Map.Entry<K, V> entry ; // 存储节点中Key和Value的值。
		Node previous;          // 链表前向指针
		Node next;              // 链表后向指针
		
		Node(K k, V v){
			this.entry = new MyEntry(k, v);
		}
		
		Node(Entry entry){
			this.entry = entry;
		}
		
		
		
	}
	
	private static class MyEntry<K,V> implements Map.Entry<K,V>{
		
		private K k;
		private V v;
		
		MyEntry(K k, V v){
			this.k = k;
			this.v = v;
		}
		
		@Override
		public K getKey() {
			return this.k;
		}

		@Override
		public V getValue() {
			return this.v;
		}

		@Override
		public V setValue(V value) {
			V v = this.v;
			this.v = value;
			return v;
		}
		
	}

	
	public static void main(String[] args) {
		Map<Object, Integer> map = new MyHashMap<>();
		
		map.put("a", 40);
		map.put(97, 50);
		map.put("hello", 100);
		
		System.out.println("a".hashCode());
		System.out.println(new Integer(97).hashCode());
		System.out.println("-------------------------------------");
		System.out.println(map.get("a"));
		System.out.println(map.get(97));
		System.out.println(map.get("hello"));
		System.out.println(map.get("hello3"));
		
		System.out.println(map.containsKey("a"));
		
		System.out.println(map.values());
		System.out.println("===================================");
		
		System.out.println(map.remove(97));
		System.out.println("contains a :"+map.containsKey(97));
		
		System.out.println(map);
		
	}
}
