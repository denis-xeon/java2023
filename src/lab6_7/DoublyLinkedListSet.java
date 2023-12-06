package lab6_7;

import java.util.*;

class Node<T extends Car> {
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

}

public class DoublyLinkedListSet<T extends Car> implements Set<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedListSet() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoublyLinkedListSet(T initialObject) {
        this.head = new Node<>(initialObject);
        this.tail = this.head;
        this.size = 1;
    }

    public DoublyLinkedListSet(Collection<? extends T> initialCollection) {
        this();
        addAll(initialCollection);
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
    public boolean contains(Object o) {
        if (o == null) {
            for (Node<T> current = head; current != null; current = current.getNext()) {
                if (current.getData() == null) {
                    return true;
                }
            }
        } else {
            for (Node<T> current = head; current != null; current = current.getNext()) {
                if (o.equals(current.getData())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new UnsupportedOperationException("No more elements in the set");
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }

            @Override
            public void remove() {
                if (current == null) {
                    throw new IllegalStateException("Неможливо видалити перед викликом next()");
                }

                Node<T> prev = current.getPrev();
                Node<T> next = current.getNext();

                if (prev == null) {
                    head = next;
                } else {
                    prev.setNext(next);
                    current.setPrev(null);
                }

                if (next == null) {
                    tail = prev;
                } else {
                    next.setPrev(prev);
                    current.setNext(null);
                }

                Node<T> oldCurrent = current;
                current = next; // Переміщення ітератора до наступного елемента
                oldCurrent.setNext(null);
                oldCurrent.setPrev(null);

                size--;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node<T> current = head; current != null; current = current.getNext()) {
            array[index++] = current.getData();
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) toArray();
        } else {
            int index = 0;
            for (Node<T> current = head; current != null; current = current.getNext()) {
                a[index++] = (T1) current.getData();
            }
            return a;
        }
    }

    @Override
    public boolean add(T t) {
        if (t == null) {
            throw new CarException ("Cannot add null element to the set");
        }

        if (!contains(t)) {
            Node<T> newNode = new Node<>(t);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new CarException ("Cannot remove null element from the set");
        }

        for (Node<T> current = head; current != null; current = current.getNext()) {
            if (o.equals(current.getData())) {
                unlink(current);
                return true;
            }
        }
        return false;
    }

    private void unlink(Node<T> node) {
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();

        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }

        if (next == null) {
            tail = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }

        size--;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T item : c) {
            modified |= add(item);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        List <T> retainedElements = new ArrayList <> ();
        for (Node<T> current = head; current != null; current = current.getNext()) {
            if (c.contains(current.getData())) {
                retainedElements.add(current.getData());
            }
        }

        boolean modified = size != retainedElements.size();

        clear();
        addAll(retainedElements);

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            modified |= remove(element);
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        return "DoublyLinkedListSet{" +
                "size=" + size +
                ", elements=" + java.util.Arrays.toString(toArray()) +
                '}';
    }

}
