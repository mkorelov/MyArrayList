import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyArrayListTester {
    public static void main(String[] args) throws Exception {
    }

    @Test
    public void testDefaultConstructor() {
        MyArrayList ls = new MyArrayList();
        assertEquals(ls.size, 0);
        assertEquals(ls.capacity, 10);
    }

    @Test
    public void testConstructor() {
        MyArrayList ls = new MyArrayList(20);
        assertEquals(ls.size, 0);
        assertEquals(ls.capacity, 20);
    }

    @Test
    public void testAdd() {
        MyArrayList ls = new MyArrayList();

        assertEquals(ls.add("Cat",0), true);
        assertEquals(ls.array[0], "Cat");

        assertEquals(ls.add("Dog", 1), true);
        assertEquals(ls.array[1], "Dog");

        assertEquals(ls.add("Snake", 0), true);
        assertEquals(ls.array[0], "Snake");
        assertEquals(ls.array[1], "Cat");
        assertEquals(ls.array[2], "Dog");

        assertEquals(ls.add("Fish", 5), false);

        assertEquals(ls.add("Pig", 100), false);

        assertEquals(ls.add("Hamster", -1), false);
    }

    @Test
    public void testContains() {
        MyArrayList ls = new MyArrayList();
        ls.add("Cat",0);
        ls.add("Dog", 1);
        ls.add("Snake", 0);
        ls.add("Fish", 5);
        ls.add("Pig", 100);
        ls.add("Hamster", -1);

        assertEquals(ls.contains("Cat"), true);
        assertEquals(ls.contains("Dog"), true);
        assertEquals(ls.contains("Snake"), true);
        assertEquals(ls.contains("Fish"), false);
        assertEquals(ls.contains("Pig"), false);
        assertEquals(ls.contains("Hamster"), false);
    }

    @Test
    public void testRemove() {
        MyArrayList ls = new MyArrayList();
        ls.add("Cat",0);
        ls.add("Dog", 1);
        ls.add("Snake", 0);
        ls.add("Fish", 5);
        ls.add("Pig", 100);
        ls.add("Hamster", -1);

        assertEquals(ls.remove(5), null);
        assertEquals(ls.remove(0), "Snake");
        assertEquals(ls.remove(0), "Cat");
        assertEquals(ls.remove(2), null);
        assertEquals(ls.remove(100), null);
        assertEquals(ls.remove(0), "Dog");

        assertEquals(ls.contains("Snake"), false);
        assertEquals(ls.contains("Cat"), false);
        assertEquals(ls.contains("Dog"), false);
    }
}
