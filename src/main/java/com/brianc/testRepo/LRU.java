package com.brianc.testRepo;

import java.util.HashMap;
import java.util.Map;

// Feel free to use this class
class LRUNode {
	
	public LRUNode() {}

	/**
	 * @param key
	 * @param value
	 */
	public LRUNode(int key, int value) {
		this.key = key;
		this.value = value;
	}

	int key;
	int value;

	LRUNode pre;
	LRUNode post;
}

public class LRU {

	/**
	 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
	 * @param key
	 * @param value
	 * 
	 * Implement the LRUCache class:
	 * 	LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
	 * 	int get(int key) Return the value of the key if the key exists, otherwise return -1.
	 * 	void put(int key, int value) Update the value of the key if the key exists. Otherwise,
	 *  add the key-value pair to the cache. If
	 *  the number of keys exceeds the capacity from this operation, evict the least recently
	 *   used key.
	 */
	
	/**
	 * Your LRUCache object will be instantiated and called as such:
	 *
	 * LRUCache cache = new LRUCache(2);
	 * cache.put(1, 2);
	 * cache.put(3, 4)
	 * int param_1 = cache.get(1);
	 * cache.put(4,5)
	 * 
	 * Q: What will be the state of the cache after this code is run?
	 *
	 */
	  
	  /**
	   * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
	   * - The goal of this exercise is to see how you would implement this code.  Do your best to
	   *   communicate correctness syntactically, but don't worry about perfect syntax or code needing to complile.
	   */

	  private Map< Integer, LRUNode > cache = new HashMap<> ();
	  private int count;
	  private int capacity;
	  private LRUNode head, tail;
	  
	  // add your fields here
	    
	  // Initialize the LRU cache with positive size capacity.
	  public LRU(int capacity) {
	        
	      this.capacity = capacity;
	      this.count = 0;
	      
	      head = new LRUNode();
	      head.pre = null;
	      
	      tail = new LRUNode();
	      tail.post = null;
	      
	      head.post = tail;
	      tail.pre = head;
	      
	    }
	    
	    // Return the value of the key if the key exists, otherwise return -1
	    public int get(int key) {
	    	LRUNode node = cache.get( key );
	      
	        if ( node == null ) {
	          return -1;
	        }
	      
	        moveNodeToHead( node );
	      
	      return node.value;
	    }
	    
	   LRUNode popTheTailNode() {
		   LRUNode lruNode = tail.pre;
		   removeNode( lruNode );
		   return lruNode;
	   }
	   
	   void removeNode ( LRUNode node ) {
		  LRUNode preNode = node.pre;
		  LRUNode postNode = node.post;
	    
	    preNode.post = postNode;
	    postNode.pre = preNode;
	  }
	  void addNode ( LRUNode node ) {
	    node.pre = head;
	    node.post = head.post;
	    
	    head.post.pre = node;
	    head.post = node;
	  }
	  private void moveNodeToHead( LRUNode node ) {
	    removeNode(  node );
	    addNode ( node );
	  }
	  
	  // Update the value of the key if the key exists. Otherwise, 
	  // add the key-value pair to the cache. If the number of keys 
	  // exceeds the capacity from this operation, evict the least recently used key.
	  public void put( LRUNode node) {
	        
		  LRUNode cachedNode = cache.get( node.key );
	      
	      if ( cachedNode == null) {
	    	  
	    	  cache.put( node.key, node);
	          addNode( node );
	          ++count;
	          if ( count > capacity ) {
	        	  // pop
	        	  LRUNode nodeToPop = popTheTailNode();
	        	  cache.remove( nodeToPop.key );
	        	  --count;
	          }
	      }
	      else { 
	    	  cachedNode.value = node.value;
	    	  moveNodeToHead( cachedNode );
	      }
	    }

    public static void main( String[] args ) {
    	LRU lru = new LRU( 10 );
    	
    	lru.put( new LRUNode( 1, 2));
    	lru.put( new LRUNode( 2, 3));
    	lru.put( new LRUNode( 3, 4));
    	lru.put( new LRUNode( 4, 5));
    	lru.put( new LRUNode( 5, 6));
    	lru.put( new LRUNode( 6, 7));
    	lru.put( new LRUNode( 7, 8));
    	lru.put( new LRUNode( 8, 9));
    	lru.put( new LRUNode( 9, 10));
    	lru.put( new LRUNode( 10, 11));
    	lru.put( new LRUNode( 11, 12));
    	lru.put( new LRUNode( 12, 12));
    	lru.get( 4 );
    	lru.put( new LRUNode( 13, 12));
    	lru.put( new LRUNode( 14, 12));
    	lru.put( new LRUNode( 15, 12));
    }
}
