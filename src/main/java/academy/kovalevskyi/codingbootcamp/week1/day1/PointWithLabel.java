package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;

public class PointWithLabel extends PointWithValue<String> {

    public PointWithLabel(int coordinateX, int coordinateY, String value) {
        super(coordinateX, coordinateY, value);
    }

    //Возвращает строку, которая была сохранена при создании объекта (value из класса PointWithValue)
    public String getLabel() {
        return getValue();
    }

    @Override
    public int compareTo(Point that) {
        if (that instanceof PointWithLabel point) {
            return this.getLabel().compareTo(point.getLabel());
        }
        return super.compareTo(that);
    }

}
