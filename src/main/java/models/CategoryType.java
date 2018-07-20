package models;

public enum CategoryType {


    CARS("Cars"),
    BICYLES("Bicyles"),
    FURNITURE("Furniture"),
    TECHNOLOGY("Technology"),
    SPORTS("Sports"),
    INSTRUMENTS("Instruments"),
    CLOTHES("Clothes"),
    APPLIANCES("Appliances"),
    TOYS("Toys"),
    FREE("Free Stuff");


   private final String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
