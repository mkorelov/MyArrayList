import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyArrayListTester {
    public static void main(String[] args) throws Exception {
        MyArrayList ls = new MyArrayList();
        System.out.println(ls.get(0));
    }

    @Test
    public void testDefaultConstructor() {
        MyArrayList ls = new MyArrayList();
        assertEquals(ls.size(), 0);
        assertEquals(ls.getCapacity(), 10);
    }

    @Test
    public void testConstructor() {
        MyArrayList ls = new MyArrayList(20);
        assertEquals(ls.size(), 0);
        assertEquals(ls.getCapacity(), 20);
    }

    @Test
    public void testInsert() {
        MyArrayList ls = new MyArrayList();

        assertEquals(ls.insert("Cat",0), true);
        assertEquals(ls.get(0), "Cat");

        assertEquals(ls.insert("Dog", 1), true);
        assertEquals(ls.get(1), "Dog");

        assertEquals(ls.insert("Snake", 0), true);
        assertEquals(ls.get(0), "Snake");
        assertEquals(ls.get(1), "Cat");
        assertEquals(ls.get(2), "Dog");

        assertEquals(ls.insert("Fish", 5), false);

        assertEquals(ls.insert("Pig", 100), false);

        assertEquals(ls.insert("Hamster", -1), false);
    }

    @Test
    public void testContains() {
        MyArrayList ls = new MyArrayList();
        ls.insert("Cat",0);
        ls.insert("Dog", 1);
        ls.insert("Snake", 0);
        ls.insert("Fish", 5);
        ls.insert("Pig", 100);
        ls.insert("Hamster", -1);

        assertEquals(ls.contains("Cat"), true);
        assertEquals(ls.contains("Dog"), true);
        assertEquals(ls.contains("Snake"), true);
        assertEquals(ls.contains("Fish"), false);
        assertEquals(ls.contains("Pig"), false);
        assertEquals(ls.contains("Hamster"), false);
    }

    @Test
    public void testDelete() {
        MyArrayList ls = new MyArrayList();
        ls.insert("Cat",0);
        ls.insert("Dog", 1);
        ls.insert("Snake", 0);
        ls.insert("Fish", 5);
        ls.insert("Pig", 100);
        ls.insert("Hamster", -1);

        assertEquals(ls.delete(5), null);
        assertEquals(ls.delete(0), "Snake");
        assertEquals(ls.delete(0), "Cat");
        assertEquals(ls.delete(2), null);
        assertEquals(ls.delete(100), null);
        assertEquals(ls.delete(0), "Dog");

        assertEquals(ls.contains("Snake"), false);
        assertEquals(ls.contains("Cat"), false);
        assertEquals(ls.contains("Dog"), false);
    }
}
