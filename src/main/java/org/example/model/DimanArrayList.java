package org.example.model;

import java.util.*;


public class DimanArrayList<E> extends AbstractList<E> implements List<E> {

    private int size;
    Object[] elementData;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;


    public DimanArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }


    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }


    public E get(int index) {
        return elementData(index);

    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public E remove(int index) {
        final Object[] es = elementData;

        E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }


    @Override
    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }


    @Override
    public void sort(Comparator<? super E> c) {

        quickSort((E[]) elementData, 0, size - 1, c);
    }


    private void quickSort(E[] a, int lo, int hi, Comparator<? super E> c) {
        if (lo >= hi) {
            return;
        }
        int pi = partition(a, lo, hi, c);
        quickSort(a, lo, pi - 1, c);
        quickSort(a, pi + 1, hi, c);
    }

    private int partition(E[] a, int lo, int hi, Comparator<? super E> c) {
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            if (c.compare(a[i], a[lo]) <= 0) {
                i++;
            } else if (c.compare(a[j], a[lo]) > 0) {
                j--;
            } else if (j < i) {
                break;
            } else {
                exchange(a, i, j);
            }
        }
        exchange(a, lo, j);
        return j;
    }


    private static void exchange(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }


    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = (int) (minCapacity * 1.5 + 1);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }


    private Object[] grow() {
        return grow(size + 1);
    }


    E elementData(int index) {
        return (E) elementData[index];
    }


    public int size() {
        return size;
    }


}
