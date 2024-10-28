public class trycatch
 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        
        try {
            
            System.out.println(numbers[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            
            System.out.println("Array index is out of bounds: " + e.getMessage());
        } finally {
            
            System.out.println("Execution finished.");
        }
    }
}

