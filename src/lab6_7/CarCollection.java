package lab6_7;

import java.util.*;

public class CarCollection<T extends Car> implements Set<T> {

    // Внутрішня структура - двозв'язний список
    private LinkedList<T> list;

    // Порожній конструктор
    public CarCollection() {
        this.list = new LinkedList<>();
    }

    // Конструктор, в який передається один об’єкт узагальненого класу
    public CarCollection(T initialObject) {
        this.list = new LinkedList<>();
        this.list.add(initialObject);
    }

    // Конструктор, в який передається стандартна колекція об’єктів
    public CarCollection(Collection<T> initialCollection) {
        this.list = new LinkedList<>(initialCollection);
    }

    // Метод, який викликається у виконавчому методі для задання початкових даних
    public void reinitialize(Collection<T> initialData) {
        this.list.clear();
        this.list.addAll(initialData);
    }

    // Реалізація методів інтерфейсу Set

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return list.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString ( ) {
        return "CarCollection{" +
                "list=" + list +
                '}';
    }
}
