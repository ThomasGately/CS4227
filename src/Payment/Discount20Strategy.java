package Payment;

public class Discount20Strategy implements HotelSalesStrategy{
    @Override
    public double doSalesStrategy(double amount) {
        double totalAmount;
        totalAmount = amount - (amount * 0.2);
        return totalAmount;
    }
}
