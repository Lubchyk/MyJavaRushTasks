package com.javarush.task.task17.task1713;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* 
Общий список
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }

    public synchronized void trimToSize() {
        synchronized (this) {
            original.trimToSize();
        }
    }

    public synchronized void ensureCapacity(int minCapacity) {
        synchronized (this) {
            original.ensureCapacity(minCapacity);
        }
    }

    public synchronized int size() {
        synchronized (this) {
            return original.size();
        }
    }

    public synchronized boolean isEmpty() {
        synchronized (this) {
            return original.isEmpty();
        }
    }

    public synchronized boolean contains(Object o) {
        synchronized (this) {
            return original.contains(o);
        }
    }

    public synchronized int indexOf(Object o) {
        synchronized (this) {
            return original.indexOf(o);
        }
    }

    public synchronized int lastIndexOf(Object o) {
        synchronized (this) {
            return original.lastIndexOf(o);
        }
    }

    public synchronized Object[] toArray() {
        synchronized (this) {
            return original.toArray();
        }
    }

    public synchronized <T> T[] toArray(T[] a) {
        synchronized (this) {
            return original.toArray(a);
        }
    }

    public synchronized Long get(int index) {
        synchronized (this) {
            return original.get(index);
        }
    }

    public synchronized Long set(int index, Long element) {
        synchronized (this) {
            return original.set(index, element);
        }
    }

    public synchronized boolean add(Long aLong) {
        synchronized (this) {
            return original.add(aLong);
        }
    }

    public synchronized void add(int index, Long element) {
        synchronized (this) {
            original.add(index, element);
        }
    }

    public synchronized Long remove(int index) {
        synchronized (this) {
            return original.remove(index);
        }
    }

    public synchronized boolean remove(Object o) {
        synchronized (this) {
            return original.remove(o);
        }
    }

    public synchronized void clear() {
        synchronized (this) {
            original.clear();
        }
    }

    public synchronized boolean addAll(Collection<? extends Long> c) {
        synchronized (this) {
            return original.addAll(c);
        }
    }

    public synchronized boolean addAll(int index, Collection<? extends Long> c) {
        synchronized (this) {
            return original.addAll(index, c);
        }
    }

    public synchronized boolean removeAll(Collection<?> c) {
        synchronized (this) {
            return original.removeAll(c);
        }
    }

    public synchronized boolean retainAll(Collection<?> c) {
        synchronized (this) {
            return original.retainAll(c);
        }
    }

    public synchronized ListIterator<Long> listIterator(int index) {
        synchronized (this) {
            return original.listIterator(index);
        }
    }

    public synchronized ListIterator<Long> listIterator() {
        synchronized (this) {
            return original.listIterator();
        }
    }

    public synchronized Iterator<Long> iterator() {
        synchronized (this) {
            return original.iterator();
        }
    }

    public synchronized List<Long> subList(int fromIndex, int toIndex) {
        synchronized (this) {
            return original.subList(fromIndex, toIndex);
        }
    }

    public synchronized void forEach(Consumer<? super Long> action) {
        synchronized (this) {
            original.forEach(action);
        }
    }

    public synchronized Spliterator<Long> spliterator() {
        synchronized (this) {
            return original.spliterator();
        }
    }

    public synchronized boolean removeIf(Predicate<? super Long> filter) {
        synchronized (this) {
            return original.removeIf(filter);
        }
    }

    public synchronized void replaceAll(UnaryOperator<Long> operator) {
        synchronized (this) {
            original.replaceAll(operator);
        }
    }

    public synchronized void sort(Comparator<? super Long> c) {
        synchronized (this) {
            original.sort(c);
        }
    }

    public synchronized boolean containsAll(Collection<?> c) {
        synchronized (this) {
            return original.containsAll(c);
        }
    }

    public synchronized Stream<Long> stream() {
        synchronized (this) {
            return original.stream();
        }
    }

    public synchronized Stream<Long> parallelStream() {
        synchronized (this) {
            return original.parallelStream();
        }
    }
}
