package br.com.zbra.androidlinq;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class ListStream<T> extends AbstractStream<T> {

    private List<T> source;

    ListStream(List<T> source) {
        this.source = source;
    }

    @Override
    public int count() {
        return source.size();
    }

    @Override
    public Iterator<T> iterator() {
        return source.iterator();
    }

    @Override
    protected Iterator<T> reverseIterator() {
        return new ReverseListIterator<>(source);
    }

    private static class ReverseListIterator<T> implements Iterator<T> {
        ListIterator<T> iterator;
        public ReverseListIterator(List<T> list) {
            iterator = list.listIterator(list.size());
        }

        public boolean hasNext() {
            return iterator.hasPrevious();
        }

        public T next() {
            return iterator.previous();
        }
    }
}
