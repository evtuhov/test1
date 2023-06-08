package academy.kovalevskyi.codingbootcamp.week1.day0;

import java.util.Objects;

//import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils.power;

public class Point implements Comparable<Point> {
    private final int coordX;
    private final int coordY;

    //Создать конструктор, который принимает две координаты и сохраняет их в полях класса
    public Point(final int coordinateX, final int coordinateY) {
        this.coordX = coordinateX;
        this.coordY = coordinateY;
    }

    //Написать метод getX(), который возвращает координату X, которая была передана конструктору
    public int getX() {
        return coordX;
    }

    public int getY() {
        return coordY;
    }

    /* метод возвращает новую точку.
    Координаты новой точки равны: координата X равна
    сумме координаты X текущей точки и координаты X
    входящей точки,
    а координата Y — сумме координаты Y текущей точки и    координаты Y входящей точки.
    */
    public Point sum(final Point that) {
        return new Point(this.getX() + that.getX(), this.getY() + that.getY());
    }

    //создает новую координату: Y остается старой, X — обновляем на newX
    public Point updateX(int newX) {
        return new Point(newX, getY());
    }

    public Point updateY(int newY) {
        return new Point(getX(), newY);
    }

    //метод  считает и возвращает расстояние от текущей точки A(X1, Y1)
    // до входящей точки B(X2, Y2) по формуле
    public int distanceTo(Point that) {
        //return (int) (power(this.getX() - that.getX(), 2) + power(this.getY() - that.getY(), 2));
        int xx = (this.getX() - that.getX());

        int yy = (this.getY() - that.getY());
        return xx * xx + yy * yy;
    }

    public int hashCode() {
        return coordX + coordY;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point that = (Point) o;
        return (coordX == that.coordX) && (coordY == that.coordY);
    }

    @Override
    public int compareTo(Point that) {
        //int sumThis = hashCode();
        //int sumThat = that.hashCode();
        //if (sumThat > sumThis) {
        //  return sumThis - sumThat;
        //}
        //if (sumThat < sumThis) {
        //  return sumThis - sumThat;
        //}
        //return 0;
        return this.hashCode() - that.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Point{X: %d, Y: %d}", getX(), getY());
    }

}

