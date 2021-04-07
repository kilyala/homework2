package ru.geekbrains.javaLevel2;

public class Main {

    public static void main(String[] args) {

        String[][] array = new String[][]{{"1", "2", "3", "4"}, {"2", "3", "4", "5"},
                {"3", "4", "5", "6"}, {"4", "5", "6", "7"}};

//        String[][] array = new String[][]{{"1", "2", "3", "4"}, {"2", "3", "4", "5"},
//                {"4", "5", "6"}, {"4", "5", "6", "7"}};

//        String[][] array = new String[][]{{"1", "2", "3", "4"}, {"2", "3", "4", "5"},
//                {"3", "4", "5", "b"}, {"4", "5", "6", "7"}};
        try {
            try {
                int result = method(array);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Array size is out of bounds");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Wrong value in the array");
            System.out.println("Mistake destination is string: " + e.i + ", column: "  + e.j);
        }
    }

    public static int method(String[][] array) throws MyArrayDataException, MyArraySizeException {
        int count = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count = count + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}
