package academy.kovalevskyi.codingbootcamp.week2.day1.models;

public record Box(int width, int height, String wall, String corner, String message) {

  public Box(int width, int height, String wall, String corner, String message) {
    this.width = width;
    this.height = height;
    this.wall = wall;
    this.corner = corner;
    this.message = message == null || message.isEmpty() ? " " : message;

    if (width < 5) {
      throw new IllegalArgumentException("weight can't be < 5");
    }

    if (height < 3) {
      throw new IllegalArgumentException("height can't be < 3");
    }

    if (wall == null) {
      throw new IllegalArgumentException("wall symbol can't be empty");
    }

    if (wall.length() > 1) {
      throw new IllegalArgumentException("Wall symbol length should be 1");
    }

    if (corner == null) {
      throw new IllegalArgumentException("corner symbol can't be empty");
    }

    if (corner.length() > 1) {
      throw new IllegalArgumentException("Corner symbol length should be 1");
    }
  }

  @Override
  public String toString() {
    return String.format("Box[width=%d, height=%d, wall=%s, corner=%s, message=%s]",
            width, height, wall, corner, message);
  }
  public static class Builder {
    private int width;
    private int height;
    private String wall;
    private String corner;
    private String message;

    public Builder() {
    }

    public Builder(Box other) {
      this.width = other.width;
      this.height = other.height;
      this.wall = other.wall;
      this.corner = other.corner;
      this.message = other.message;
    }

    public Builder width(int width) {
      this.width = width;
      return this;
    }

    public Builder height(int height) {
      this.height = height;
      return this;
    }

    public Builder wall(String wall) {
      this.wall = wall;
      return this;
    }

    public Builder corner(String corner) {
      this.corner = corner;
      return this;
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public Box build() {
      return new Box(width, height, wall, corner, message);
    }
  }

}

