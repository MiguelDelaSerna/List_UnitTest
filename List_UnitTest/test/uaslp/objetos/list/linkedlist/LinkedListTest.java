package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void givenANewList_thenSizeIsZero(){
        //Given
        LinkedList<String> list= new LinkedList<>();

        //When
        int size = list.getSize();

        //Then
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne(){
        //Given
        LinkedList<String> list = new LinkedList<>();

        //When
        list.addAtTail("Uno");

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenAnEmptyList_whenAddAtTail_thenSizeIsIncreased(){
        //Given
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();

        //When
        list.addAtFront("Uno");

        //Then
        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Uno", list.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_thenSizeIsIncreased(){
        //Given
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();

        //When
        list.addAtFront("Uno");
        boolean result = list.remove(-1);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_thenReturnFalse(){
        //Given
        LinkedList<String> list = new LinkedList<>();

        //When
        list.addAtFront("Uno");
        boolean result = list.remove(1);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWithOneElement_whenRemove0_thenReturnTrue(){
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("Uno");

        //When
        list.remove(0);

        //Then
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemove0_thenReturnTrue(){
        //Given
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
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
        LinkedList<String> list = new LinkedList<>();
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
    public void givenAListWith3Element_whenGetAtLessThan0_thenReturnNull(){
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        list.getAt(-1);

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }

    @Test
    public void givenAListWith3Element_whenGetAtIndex3_thenReturnNull(){
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");

        //When
        list.getAt(3);

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
        Assertions.assertEquals("Tres", list.getAt(2));
    }

    @Test
    public void givenAListWithNElement_removeAllWithAValue(){
        //Given
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("Uno");
        list.addAtFront("Dos");
        list.addAtTail("Tres");
        //Dos Uno Tres

        //When
        list.removeAllWithValue("Tres");

        //Then
        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Dos", list.getAt(0));
        Assertions.assertEquals("Uno", list.getAt(1));
    }

}
