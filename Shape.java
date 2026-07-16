public abstract class Shape {

    private final String color;

    protected Shape(String color) {
        if (color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color cannot be null or blank.");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public void displayInfo() {
        System.out.printf(
                "Shape: %s%nColor: %s%nArea: %.2f%nPerimeter: %.2f%n",
                getClass().getSimpleName(),
                color,
                calculateArea(),
                calculatePerimeter()
        );
    }

    @Override
    public String toString() {
        return String.format(
                "%s{color='%s', area=%.2f, perimeter=%.2f}",
                getClass().getSimpleName(),
                color,
                calculateArea(),
                calculatePerimeter()
        );
    }
}
