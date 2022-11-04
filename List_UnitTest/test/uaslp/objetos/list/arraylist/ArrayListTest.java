package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;

public class ArrayListTest {

    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given
        ArrayList<String> list= new ArrayList<>();

        //When
        int size = list.getSize();

        //Then
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne(){
        //Given
        ArrayList<String> list = new ArrayList<>();

        //When
        list.addAtTail("Uno");

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenAnEmptyList_whenAddAtTail_thenSizeIsIncreased(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");

        //When
        list.addAtTail("Dos");

        //Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
        Assertions.assertEquals("Dos", list.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne(){
        //Given
        ArrayList<String> list = new ArrayList<>();

        //When
        list.addAtFront("Uno");

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Uno");

        //When
        list.addAtFront("Dos");

        //Then
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLeesThanSize_thenReturnFalse(){
        //Given
        ArrayList<String> list = new ArrayList<>();

        //When
        list.addAtFront("Uno");
        boolean result = list.remove(-1);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse(){
        //Given
        ArrayList<String> list = new ArrayList<>();

        //When
        list.addAtFront("Uno");
        boolean result = list.remove(1);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("Uno");

        //When
        list.remove(0);

        //Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemove0_thenReturnTrue(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtTail("Dos");

        //When
        boolean result = list.remove(0);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(list.getAt(0), "Dos");
    }

    @Test
    public void givenAListWithTwoElement_whenRemoveTail_thenReturnTrue(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtTail("Dos");

        //When
        boolean result = list.remove(1);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals(list.getAt(0), "Uno");
    }

    @Test
    public void givenAListWith3Element_whenRemoveMiddle_thenReturnTrue(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        boolean result = list.remove(1);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals(list.getAt(0), "Dos");
        Assertions.assertEquals(list.getAt(1), "Tres");
    }

    @Test
    public void givenAListWith3Element_whenRemoveAll_thenSizeIsZero(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        list.removeAll();

        //Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWith3Element_whenSetAt1_thenElementIsModified(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        boolean result = list.setAt(1,"Cuatro");

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Cuatro", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAListWith3Element_whenSetAtLessThan0_thenReturnNull(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        boolean result = list.setAt(-1,"Cuatro");

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith3Element_whenSetAtIndex3_thenReturnNull(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        boolean result = list.setAt(3,"Cuatro");

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith2Elements_whenAddAtFront_thenArrayIsIncreasedSuccessfully(){
        //Given
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");

        //When

        list.addAtFront("Tres");

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Tres", list.getAt(0));
        Assertions.assertEquals("Dos", list.getAt(1));
        Assertions.assertEquals("Uno", list.getAt(2));
    }

    @Test
    public void givenAnArray_whenGetAtNegative_thenNullIsReturned(){
        //Given
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Algo");

        //When
        String value = list.getAt(-1);

        //Then
        Assertions.assertNull(value);
    }

    @Test
        public void givenAnArray_whenGetAtIndexGreaterThanSize_thenNullIsReturned(){
        //Given
        ArrayList<String> list = new ArrayList<>();

        list.addAtFront("Algo");

        //When
        String value = list.getAt(1);

        //Then
        Assertions.assertNull(value);
    }

    @Test
    public void givenAnArray_whenRemoveAllWithValue_thenValuesAreRemoved(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.addAtFront(10);
        list.addAtFront(20);
        list.addAtTail(30);
        list.addAtFront(20);
        list.addAtTail(40);
        list.addAtFront(20);
        list.addAtTail(30);

        //When
       list.removeAllWithValue(20);

        //Then
        Assertions.assertEquals(4, list.getSize());
        Assertions.assertEquals(10, list.getAt(0));
        Assertions.assertEquals(30, list.getAt(1));
        Assertions.assertEquals(40, list.getAt(2));
        Assertions.assertEquals(30, list.getAt(3));
    }

    @Test
    public void givenAnArrayWithNoCoincidences_whenRemoveAllWithValue_thenValuesAreRemoved(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.addAtFront(10);
        list.addAtTail(30);
        list.addAtTail(40);
        list.addAtTail(30);

        //When
        list.removeAllWithValue(20);

        //Then
        Assertions.assertEquals(4, list.getSize());
        Assertions.assertEquals(10, list.getAt(0));
        Assertions.assertEquals(30, list.getAt(1));
        Assertions.assertEquals(40, list.getAt(2));
        Assertions.assertEquals(30, list.getAt(3));
    }

    @Test
    public void givenAnNonEmptyList_whenIterate_thenIterationIsSuccessful(){
        //Given
        ArrayList<Integer> list = new ArrayList<>();

        list.addAtFront(10);
        list.addAtTail(30);
        list.addAtTail(40);
        list.addAtTail(30);

        //When
        Iterator<Integer> iterator = list.getIterator();

        //Then
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(4, list.getSize());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(10, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(40, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30, iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }
}