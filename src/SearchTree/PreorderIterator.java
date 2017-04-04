package SearchTree;

import java.util.ArrayDeque;
import java.util.Iterator;

import java.util.Stack;

import SearchTree.Position;
import SearchTree.Tree;

public class PreorderIterator<E> implements Iterator<Position<E>> {
    private Stack<Position<E>> nodeStack;
    private Tree<E> tree;

    public PreorderIterator(Tree<E> tree) {
        this.tree = tree;
        nodeStack = new Stack();
        if (!tree.isEmpty()) {
                nodeStack.push(tree.root());
        }
    }
    public PreorderIterator(Tree<E> tree, Position<E> position) {
    	this.tree = tree;
        nodeStack = new Stack();
        nodeStack.push(position);
    }
	@Override
	public boolean hasNext() {
		return nodeStack.size()!=0;
	}
        
	@Override
	public Position<E> next() {
            Position<E> aux = nodeStack.pop();
            Stack<Position<E>> pilaAuxiliar = new Stack();
            for (Position<E> node : tree.children(aux)) {
                pilaAuxiliar.push(node);
            }
            while (!pilaAuxiliar.isEmpty()){
                Position<E> node = pilaAuxiliar.pop();
                nodeStack.push(node);
            }
            return aux;
	}

    @Override
    public void remove() {
    }

}
