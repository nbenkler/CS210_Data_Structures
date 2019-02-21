/**
 * BST.java
 * Jeff Ondich, 7-20 February 2019
 *
 * The beginnings of a binary search tree implementation.
 */

import java.lang.Comparable;
import java.lang.Math;
import java.util.LinkedList;

public class BST<K extends Comparable<K>, V> {
    private Node<K, V> root;

    private class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> leftChild;
        public Node<K, V> rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST() {
        this.root = null;
    }

    /**
     * Adds the specified (key, value) pair to this binary search tree, using
     * the key as the new node's search key.
     * NOTE: This is an ITERATIVE implementation.
     */
    public void add(K key, V value) {
        Node<K, V> newNode = new Node<K, V>(key, value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node<K, V> currentNode = this.root;
            boolean done = false;
            while (!done) {
                int comparison = key.compareTo(currentNode.key);
                if (comparison <= 0) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = newNode;
                        done = true;
                    } else {
                        currentNode = currentNode.leftChild;
                    }
                } else {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = newNode;
                        done = true;
                    } else {
                        currentNode = currentNode.rightChild;
                    }
                }
            }
        }
    }

    /**
     * Adds the specified (key, value) pair to this binary search tree, using
     * the key as the new node's search key.
     * NOTE: This is a RECURSIVE implementation.
     */
    public void addRecursive(K key, V value) {
		if (this.root == null) {
			this.root = new Node<K, V>(key, value);
		} else {
			addToSubtree(this.root, key, value);
		}
    }

	private void addToSubtree(Node<K, V> subtreeRoot, K key, V value) {
		// Assume that subtreeRoot is non-null
		int comparison = key.compareTo(subtreeRoot.key);
		if (comparison <= 0) {
			// goat < moose so comparison < 0
			if (subtreeRoot.leftChild == null) {
				Node<K, V> newNode = new Node<K, V>(key, value);
				subtreeRoot.leftChild = newNode;
			} else {
				addToSubtree(subtreeRoot.leftChild, key, value);
			}

		} else {
			if (subtreeRoot.rightChild == null) {
				Node<K, V> newNode = new Node<K, V>(key, value);
				subtreeRoot.rightChild = newNode;
			} else {
				addToSubtree(subtreeRoot.rightChild, key, value);
			}
		}
	}

    /**
     * @return the value associated with the specified key if one exists, or
     *    null otherwise.
     * NOTE: This is an ITERATIVE implementation.
     */
    public V find(K key) {
        // Not yet implemented
        return null;
    }

    /**
     * @return the value associated with the specified key if one exists, or
     *    null otherwise.
     * NOTE: This is a RECURSIVE implementation.
     */
    public V findRecursive(K key) {
        // Not yet implemented
        return null;
    }

    /**
     * Returns the number of nodes in this binary search tree.
     * NOTE: This is a RECURSIVE implementation.
     */
    public int size() {
        // Not yet implemented
        return 0;
    }

    /**
     * Returns the height of this binary search tree. (See section 6.1 of
     * your textbook for the definition of height.)
     * NOTE: This is a RECURSIVE implementation.
     */
    public int height() {
        // Strategy: if empty, 0
		//   Otherwise: height of left, height of right, pick max
		//     and add 1
        return heightOfSubtree(this.root);
    }

	private int heightOfSubtree(Node<K, V> subtreeRoot) {
		if (subtreeRoot == null) {
			return 0;
		} else {
			int leftHeight = heightOfSubtree(subtreeRoot.leftChild);
			int rightHeight = heightOfSubtree(subtreeRoot.rightChild);
			if (leftHeight > rightHeight) {
				return 1 + leftHeight;
			} else {
				return 1 + rightHeight;
			}
		}
	}

    /**
     * Prints the keys of this tree in increasing sorted order.
     */
    public void printInOrder() {
        printSubtreeInOrder(this.root);
    }

    private void printSubtreeInOrder(Node<K, V> subtreeRoot) {
        if (subtreeRoot != null) {
            printSubtreeInOrder(subtreeRoot.leftChild);
            System.out.println(subtreeRoot.key.toString());
            printSubtreeInOrder(subtreeRoot.rightChild);
        }
    }

    /**
     * Prints the keys of this tree in decreasing sorted order.
     */
    public void printInReverseOrder() {
        // Not yet implemented
    }

    /**
     * Prints an ASCII version of this tree. This printing will be "pretty"
     * only if the nodes' keys are single characters. This method is thus
     * intended only as a debugging tool to help you view the structure of
     * a particular tree.
     *
     * Really, this was just Jeff fooling around to see if he could do it
     * and if so, how it would look.
     */
    public void printPretty() {
        int treeHeight = height();
		if (treeHeight <= 0) {
			return;
		}

        LinkedList<Node<K, V>> queue = new LinkedList<Node<K, V>>();
        queue.add(this.root);
        int level = 0;
        int nodesLeftInLevel = 1;
        int betweenNodesGapSize = (int)Math.pow(2, (double)treeHeight + 1) - 1;
        String betweenNodesGap = new String(new char[betweenNodesGapSize]).replace('\0', ' ');
        int leftMarginSize = (betweenNodesGapSize / 2) - 1;
        System.out.print(new String(new char[leftMarginSize]).replace('\0', ' '));

        while (!queue.isEmpty() && level < treeHeight) {
            Node<K, V> node = queue.remove();
            if (node != null) {
                System.out.print(node.key);
                queue.add(node.leftChild);
                queue.add(node.rightChild);
            } else {
                System.out.print("-");
                queue.add(null);
                queue.add(null);
            }
            System.out.print(betweenNodesGap);

            nodesLeftInLevel--;
            if (nodesLeftInLevel <= 0) {
                level++;
                nodesLeftInLevel = (int)Math.pow(2, (double)level);
                System.out.println();

                betweenNodesGapSize = (int)Math.pow(2, (double)(treeHeight - level) + 1) - 1;
                betweenNodesGap = new String(new char[betweenNodesGapSize]).replace('\0', ' ');

                leftMarginSize = (betweenNodesGapSize / 2) - 1;
                if (leftMarginSize > 0) {
                    System.out.print(new String(new char[leftMarginSize]).replace('\0', ' '));
                }
            }
        }
    }

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<String, Integer>();
        for (String arg : args) {
            bst.addRecursive(arg, 0);
            //bst.add(arg, 0);
        }
        System.out.println("======= printInOrder =======");
        bst.printInOrder();

        System.out.println("======= printPretty =======");
        bst.printPretty();
    }
}