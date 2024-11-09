import java.util.*;

/**
 * A class representing a collection of unique Aircraft objects.
 * This collection is backed by a custom array structure with an initial capacity
 * and increases in size by 30% when needed.
 */
public class AircraftCollection implements Set<Aircraft> {
    private Aircraft[] aircraftArray;
    private int size;

    /**
     * Default initial capacity for the collection.
     */
    private static final int INITIAL_CAPACITY = 15;

    /**
     * Constructor initializing the collection with an initial capacity.
     */
    public AircraftCollection() {
        this.aircraftArray = new Aircraft[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructor that accepts a single Aircraft object and adds it to the collection.
     *
     * @param aircraft the Aircraft object to be added
     */
    public AircraftCollection(Aircraft aircraft) {
        this();
        if (aircraft != null) {
            add(aircraft);
        } else {
            throw new IllegalArgumentException("Aircraft cannot be null");
        }
    }

    /**
     * Constructor that accepts a collection of Aircraft objects.
     *
     * @param aircraftCollection the collection of Aircraft objects to initialize with
     */
    public AircraftCollection(Collection<Aircraft> aircraftCollection) {
        this();
        if (aircraftCollection == null) {
            throw new IllegalArgumentException("Input collection cannot be null");
        }
        this.addAll(aircraftCollection);
    }

    /**
     * Adds an Aircraft to the collection, ensuring uniqueness.
     *
     * @param aircraft the Aircraft to be added
     * @return true if the element is added successfully, false if it already exists
     */
    @Override
    public boolean add(Aircraft aircraft) {
        if (aircraft == null) {
            throw new IllegalArgumentException("Aircraft cannot be null");
        }
        if (contains(aircraft)) {
            return false;
        }
        ensureCapacity();
        aircraftArray[size++] = aircraft;
        return true;
    }

    /**
     * Ensures that the array has enough capacity, increasing its size by 30% if needed.
     */
    private void ensureCapacity() {
        if (size >= aircraftArray.length) {
            int newCapacity = (int) (aircraftArray.length * 1.3);
            aircraftArray = Arrays.copyOf(aircraftArray, newCapacity);
        }
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
        if (o instanceof Aircraft) {
            for (int i = 0; i < size; i++) {
                if (aircraftArray[i].equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Aircraft> iterator() {
        return new Iterator<Aircraft>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Aircraft next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return aircraftArray[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(aircraftArray, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(aircraftArray, size, a.getClass());
        }
        System.arraycopy(aircraftArray, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Aircraft) {
            for (int i = 0; i < size; i++) {
                if (aircraftArray[i].equals(o)) {
                    int numMoved = size - i - 1;
                    if (numMoved > 0) {
                        System.arraycopy(aircraftArray, i + 1, aircraftArray, i, numMoved);
                    }
                    aircraftArray[--size] = null; // clear to let GC do its work
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Aircraft> c) {
        boolean modified = false;
        for (Aircraft aircraft : c) {
            if (add(aircraft)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(aircraftArray[i])) {
                remove(aircraftArray[i]);
                i--; // adjust index after removal
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        Arrays.fill(aircraftArray, 0, size, null);
        size = 0;
    }
}
