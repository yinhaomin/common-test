package com.island.common.test.service.iterater;

/* ------------------------------------------------------------ */
// iterators

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public abstract class HashIterator<K,V> {
//    HashMap.Node<K,V> next;        // next entry to return
//    HashMap.Node<K,V> current;     // current entry
//    int expectedModCount;  // for fast-fail
//    int index;             // current slot
//
//    HashIterator() {
//        expectedModCount = modCount;
//        HashMap.Node<K,V>[] t = table;
//        current = next = null;
//        index = 0;
//        if (t != null && size > 0) { // advance to first entry
//            do {} while (index < t.length && (next = t[index++]) == null);
//        }
//    }
//
//    public final boolean hasNext() {
//        return next != null;
//    }
//
//    final HashMap.Node<K,V> nextNode() {
//        HashMap.Node<K,V>[] t;
//        HashMap.Node<K,V> e = next;
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
//        if (e == null)
//            throw new NoSuchElementException();
//        if ((next = (current = e).next) == null && (t = table) != null) {
//            do {} while (index < t.length && (next = t[index++]) == null);
//        }
//        return e;
//    }
//
//    public final void remove() {
//        HashMap.Node<K,V> p = current;
//        if (p == null)
//            throw new IllegalStateException();
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
//        current = null;
//        K key = p.key;
//        removeNode(hash(key), key, null, false, false);
//        expectedModCount = modCount;
//    }
//
//
//    // The remove method in Hashtable.Enumerator
//    public void remove() {
//        if (!iterator)
//            throw new UnsupportedOperationException();
//        if (lastReturned == null)
//            throw new IllegalStateException("Hashtable Enumerator");
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
//
//        synchronized(Hashtable.this) {
//            Hashtable.Entry<?,?>[] tab = Hashtable.this.table;
//            int index = (lastReturned.hash & 0x7FFFFFFF) % tab.length;
//
//            @SuppressWarnings("unchecked") Hashtable.Entry<K,V> e = (Hashtable.Entry<K,V>)tab[index];
//            for(Hashtable.Entry<K,V> prev = null; e != null; prev = e, e = e.next) {
//                if (e == lastReturned) {
//                    modCount++;
//                    expectedModCount++;
//                    if (prev == null)
//                        tab[index] = e.next;
//                    else
//                        prev.next = e.next;
//                    count--;
//                    lastReturned = null;
//                    return;
//                }
//            }
//            throw new ConcurrentModificationException();
//        }
//    }

}