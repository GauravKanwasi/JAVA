public class RandomArrangement {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int randomIndex = (int) (Math.random() * n);

            if (i != randomIndex) {
                int temp = numbers[i];
                numbers[i] = numbers[randomIndex];
                numbers[randomIndex] = temp;
            } else {
                
            }
        }

        System.out.println("Randomly arranged numbers:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
