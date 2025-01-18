class SumMethod {
    public static int sumMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length > 4) throw new MyArraySizeException("В массиве кол-во строк больше 4");
        if (array.length < 4) throw new MyArraySizeException("В массиве кол-во строк меньше 4");

        for (int i = 0; i < array.length; i++) {
            if (array[i].length > 4) {
                throw new MyArraySizeException("В массиве array[" + i + "][n], n больше 4");
            }
            if (array[i].length < 4) {
                throw new MyArraySizeException("В массиве array[" + i + "][n], n меньше 4");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка формата данных в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}
