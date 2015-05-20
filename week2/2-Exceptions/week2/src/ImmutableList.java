import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang3.SerializationUtils;

public class ImmutableList<E extends Serializable> extends ArrayList<E> {

    private static final long serialVersionUID = 1L;

    ImmutableList(Collection<? extends E> collection) {
        super.addAll(collection);
    }

    @Override
    public boolean add(E arg0) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public void add(int arg0, E arg1) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public boolean contains(Object arg0) {
        return super.contains(arg0);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    public E get(int index) {
        return SerializationUtils.clone(super.get(index));
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return super.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return super.listIterator(index);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("This is an immuptable list! It can't be modified!");
    }

    @Override
    public int size() {
        return super.size();
    }

    @SafeVarargs
    public static <T> List<T> asList(T... args) {
        return Arrays.asList(args);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> copy = new ArrayList<E>();

        for (int i = fromIndex; i < toIndex; i++)
            copy.add(SerializationUtils.clone(super.get(i)));

        List<E> immutableCopy = new ImmutableList(copy);

        return immutableCopy;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[super.size()];

        for (int i = 0; i < super.size(); i++)
            arr[i] = SerializationUtils.clone(super.get(i));

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        final T[] arr = a;

        return arr;

    }

}
