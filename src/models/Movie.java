package models;

public class Movie {
    private String name, format;
    private double rating, sellingPrice, rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating) {
        if(name == null || name.isEmpty() || !(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray")) || rating < 0 || rating > 10)
            throw new IllegalArgumentException("Invalid parameters.");
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellingPrice = (format.equals("Blue-Ray") ? 4.25 : 2.25);
        this.rentalPrice = (format.equals("Blue-Ray") ? 1.99 : 0.99);

    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.isAvailable = source.isAvailable;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null/blank");
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if(format == null || format.isEmpty() || !(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray")))
            throw new IllegalArgumentException("Format cannot be null/blank/not DVD or Blue-ray");
        this.format = format;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if(rating < 0 || rating > 10)
            throw new IllegalArgumentException("Rating cannot be negative or higher than 10");
        this.rating = rating;
    }

    private double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString() {
        return "\tName: " + name + "\n" + "\tFormat: " + format
                + "\n" + "\tRating: " + rating + "\n" + "\tSelling Price: "
                + sellingPrice + "\n" + "\tRental Price: " + rentalPrice + "\n"
                + "\tAvailability: " + (isAvailable ? "in-stock " : " rented") + "\n";
    }
}