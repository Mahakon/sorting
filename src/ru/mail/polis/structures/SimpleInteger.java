package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger implements Numerical<SimpleInteger> {

    private static final int DIGIT_COUNT = 10;

    public final StringBuilder data;
    private final int length;

    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        this.data = getNumbers(data);
        this.length = this.data.length();
    }



    @Override
    public int getDigit(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index " + index);
        } else if (index >= getDigitCount()) {
            return 0;
        } else {
            return Character.getNumericValue(data.charAt(index));
        }
    }

    @Override
    public int getDigitMaxValue() {
        return DIGIT_COUNT;
    }

    @Override
    public int getDigitCount() {
        return length;
    }

    private StringBuilder getNumbers(Integer num) {
        StringBuilder str = new StringBuilder();

        for(int a = num; a > 0; a /= 10) {
            str.insert(0,a % 10);
        }

        return str;
    }

    @Override
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        return 0;
    }
}
