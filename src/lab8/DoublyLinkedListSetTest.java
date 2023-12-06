package lab8;

import lab6_7.Car;
import lab6_7.CarException;
import lab6_7.DoublyLinkedListSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListSetTest {

    private DoublyLinkedListSet <ConcreteCar> carSet;

    @BeforeEach
    void setUp() {
        carSet = new DoublyLinkedListSet<>();
    }

    @Test
    void testConstructor() {
        assertNotNull(carSet);
        assertTrue(carSet.isEmpty());
        assertEquals(0, carSet.size());
    }

    @Test
    void testConstructorWithInitialObject() throws CarException {
        ConcreteCar car = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        carSet = new DoublyLinkedListSet<>(car);
        assertFalse(carSet.isEmpty());
        assertEquals(1, carSet.size());
        assertTrue(carSet.contains(car));
    }

    @Test
    void testConstructorWithInitialCollection() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");
        Collection<ConcreteCar> carCollection = Arrays.asList(car1, car2);
        carSet = new DoublyLinkedListSet<>(carCollection);

        assertFalse(carSet.isEmpty());
        assertEquals(2, carSet.size());
        assertTrue(carSet.contains(car1));
        assertTrue(carSet.contains(car2));
    }

    @Test
    void testSize() throws CarException {
        assertEquals(0, carSet.size());

        ConcreteCar car = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        carSet.add(car);
        assertEquals(1, carSet.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(carSet.isEmpty());

        ConcreteCar car = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        carSet.add(car);
        assertFalse(carSet.isEmpty());
    }

    @Test
    void testContains() throws CarException {
        ConcreteCar car = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        assertFalse(carSet.contains(car));

        carSet.add(car);
        assertTrue(carSet.contains(car));
    }

    @Test
    void testIterator() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");
        carSet.addAll(Arrays.asList(car1, car2));

        Iterator<ConcreteCar> iterator = carSet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(car1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(car2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testToArray() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");
        carSet.addAll(Arrays.asList(car1, car2));

        Object[] array = carSet.toArray();
        assertEquals(2, array.length);
        assertTrue(Arrays.asList(array).contains(car1));
        assertTrue(Arrays.asList(array).contains(car2));
    }


    @Test
    void testAdd() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        assertTrue(carSet.add(car1));
        assertEquals(1, carSet.size());
        assertTrue(carSet.contains(car1));

        assertFalse(carSet.add(car1));
        assertEquals(1, carSet.size());
    }

    @Test
    void testRemove() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        assertFalse(carSet.remove(car1));

        carSet.add(car1);
        assertTrue(carSet.remove(car1));
        assertEquals(0, carSet.size());
        assertFalse(carSet.contains(car1));

        assertFalse(carSet.remove(car1));
        assertEquals(0, carSet.size());
    }

    @Test
    void testContainsAll() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");

        Set<ConcreteCar> set1 = new HashSet<>(Arrays.asList(car1, car2));
        Set<ConcreteCar> set2 = new HashSet<>(Arrays.asList(car1));

        carSet.addAll(set1);
        assertTrue(carSet.containsAll(set2));
    }

    @Test
    void testAddAll() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");

        Set<ConcreteCar> set = new HashSet<>(Arrays.asList(car1, car2));

        assertTrue(carSet.addAll(set));
        assertEquals(2, carSet.size());
        assertTrue(carSet.contains(car1));
        assertTrue(carSet.contains(car2));

        assertFalse(carSet.addAll(set));
        assertEquals(2, carSet.size());
    }

    @Test
    void testRetainAll() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");
        ConcreteCar car3 = new ConcreteCar("Ford", "Focus", 7.0, 18000, 160, "Compact");

        carSet.addAll(Arrays.asList(car1, car2, car3));

//        Set<ConcreteCar> retainSet = new HashSet<>(Arrays.asList(car1, car2));
        assertTrue(carSet.retainAll(Arrays.asList ( car2, car3 )));

        assertEquals(2, carSet.size());
        assertFalse(carSet.contains(car1));
        assertTrue(carSet.contains(car2));
        assertTrue(carSet.contains(car3));
    }

    @Test
    void testRemoveAll() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");
        ConcreteCar car3 = new ConcreteCar("Ford", "Focus", 7.0, 18000, 160, "Compact");

        carSet.addAll(Arrays.asList(car1, car2, car3));

        Set<ConcreteCar> removeSet = new HashSet<>(Arrays.asList(car1, car2));
        assertTrue(carSet.removeAll(removeSet));

        assertEquals(1, carSet.size());
        assertFalse(carSet.contains(car1));
        assertFalse(carSet.contains(car2));
        assertTrue(carSet.contains(car3));
    }

    @Test
    void testClear() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");

        carSet.addAll(Arrays.asList(car1, car2));
        assertEquals(2, carSet.size());

        carSet.clear();
        assertTrue(carSet.isEmpty());
        assertEquals(0, carSet.size());
    }

    @Test
    void testToString() throws CarException {
        ConcreteCar car1 = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        ConcreteCar car2 = new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact");

        carSet.addAll(Arrays.asList(car1, car2));

        assertEquals("DoublyLinkedListSet{size=2, elements=" + Arrays.asList(car1, car2) + '}', carSet.toString());
    }

    @Test
    void testAddNull() {
        assertThrows(CarException.class, () -> carSet.add(null));
        assertTrue(carSet.isEmpty());
        assertEquals(0, carSet.size());
    }

    @Test
    void testRemoveNull() {
        assertThrows(CarException.class, () -> carSet.remove(null));
        assertTrue(carSet.isEmpty());
        assertEquals(0, carSet.size());
    }

    @Test
    void testAddAllWithNull() {
        assertThrows(CarException.class, () -> carSet.addAll(Arrays.asList(new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact"), null)));
        assertFalse(carSet.isEmpty());
        assertEquals(1, carSet.size());
    }

    @Test
    void testRemoveAllWithNull() throws CarException {
        ConcreteCar car = new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact");
        carSet.add(car);
        assertThrows(CarException.class, () -> carSet.removeAll(Arrays.asList(new ConcreteCar("Toyota", "Corolla", 7.5, 20000, 150, "Compact"), null)));
        assertEquals(1, carSet.size());
    }
    

    @Test
    void testAddAllWithNullElement() {
        assertThrows(CarException.class, () -> carSet.addAll(Arrays.asList(null, new ConcreteCar("Honda", "Civic", 8.0, 22000, 140, "Compact"))));
        assertTrue(carSet.isEmpty());
        assertEquals(0, carSet.size());
    }

    private static class ConcreteCar extends Car {
        public ConcreteCar(String brand, String model, double fuelConsumption, double price, double speed, String carClass) throws CarException {
            super(brand, model, fuelConsumption, price, speed, carClass);
        }

        @Override
        public double calcCostPerKm() {
            return getPrice() / getFuelConsumption();
        }
    }
}
