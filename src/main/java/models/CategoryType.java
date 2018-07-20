package models;

public enum CategoryType {


    CAR("Cars"),
    BICYLE("Bicyles"),
    FURNITURE("Furniture"),
    TECHNOLOGY("Technology"),
    SPORTS("Sports Equipment"),
    INSTRUMENT("Instruments"),
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
