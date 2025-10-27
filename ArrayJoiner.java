class ArrayJoiner {
    public static void main(String[] args) {
        int[] firstArray = {10, 20, 30};
        int[] secondArray = {40, 50, 60, 70};

        int firstLength = firstArray.length;
        int secondLength = secondArray.length;
        int resultLength = firstLength + secondLength;

        int[] joinedArray = new int[resultLength];

        int index = 0;
        for (int element : firstArray) {
            joinedArray[index] = element;
            index++;
        }

        for (int element : secondArray) {
            joinedArray[index] = element;
            index++;
        }

        System.out.print("Joined Array: [");
        for (int i = 0; i < joinedArray.length; i++) {
            System.out.print(joinedArray[i]);
            if (i < joinedArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
