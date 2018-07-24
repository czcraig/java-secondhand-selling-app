package models;

public enum CategoryType {


    CARS("Cars"),
    BICYCLES("Bicycles"),
    FURNITURE("Furniture"),
    TECHNOLOGY("Technology"),
    INSTRUMENTS("Instruments"),
    CLOTHES("Clothes"),
    APPLIANCES("Appliances"),
    TOYS("Toys"),
    FREE("Free");


   private final String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
