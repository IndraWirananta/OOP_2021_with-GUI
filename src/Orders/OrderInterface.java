package Orders;

public interface OrderInterface {

    double TAXES = 0.1;
    double DELIVERY_CHARGES = 0.2;

    abstract public double calculateTaxes();

    abstract public double calculateDeliveryCharges();

    abstract public double calculateTotal();

}
