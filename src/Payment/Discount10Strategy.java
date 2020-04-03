package Payment;

public class Discount10Strategy implements HotelSalesStrategy{

    @Override
    public double doSalesStrategy(double amount) {
        double totalAmount;
        totalAmount = amount - (amount * 0.1);
        return totalAmount;
    }
}
