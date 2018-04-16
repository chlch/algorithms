package algorithms;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root; // root of the BST
	private int n; // number of key-value pairs in BST

	// BST helper node data type
	private class Node {
		private Key key; // key
		private Value val; // associated data
		private Node left, right; // links to left and right subtrees
		private boolean color; // color of parent link

		public Node(Key key, Value val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;
		}
	}

	// return value associated with the given key, or null if no such key exists
	public Value get(Key key) {
		return get(root, key);
	}

	public Value get(Node x, Key key) {
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.val;
		}
		return null;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}


	public void put(Key key, Value val) {
		root = insert(root, key, val);
		root.color = BLACK;
	}

	private Node insert(Node h, Key key, Value val) {
		if (h == null) {
			n++;
			return new Node(key, val, RED);
		}

		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = insert(h.left, key, val);
		else if (cmp > 0)
			h.right = insert(h.right, key, val);
		else
			h.val = val;

		// fix-up any right-leaning links
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);

		return h;
	}



	// is node x red (and non-null) ?
	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	// rotate right
	private Node rotateRight(Node h) {
		assert (h != null) && isRed(h.left);
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	// rotate left
	private Node rotateLeft(Node h) {
		assert (h != null) && isRed(h.right);
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private void flipColors(Node h) {
		assert !isRed(h) && isRed(h.left) && isRed(h.right);
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

}
