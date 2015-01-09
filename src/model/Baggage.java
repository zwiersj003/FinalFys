package model;

public class Baggage {

    
    public String baggageId;
    public String color;
    public String weight;
    public String brand;
    public String description;
    public String materials;
    public String department;
    public String status ;
    public String flightnr;
    public String CustomerName;
    public String Adress;
    public String ShippingAdress;
    public String City;
    public String Postal;
    public String Country;
    public String Email;

    public Baggage() {
        this( "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public Baggage(String baggageId, String color, String weight, String brand, String description, String materials, String department, String status, String flightnr, String Name, String Adress, String shippingAdress, String City, String Postal, String Country, String Email) {
        
        this.baggageId = baggageId;
        this.color = color;
        this.weight = weight;
        this.brand = brand;
        this.description = description;
        this.materials = materials;
        this.department = department;
        this.status = status;
        this.flightnr = flightnr;
        this.CustomerName = Name;
        this.Adress = Adress;
        this.ShippingAdress = shippingAdress;
        this.City = City;
        this.Postal = Postal;
        this.Country = Country;
        this.Email = Email;
    }

}
