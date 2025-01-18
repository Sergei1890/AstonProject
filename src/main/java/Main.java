public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"4", "5", "6", "8"},
                {"3", "4", "5", "1"},
                {"4", "3", "2", "6"}
        };

        try {
            System.out.println(SumMethod.sumMethod(array));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}