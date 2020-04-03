package Payment;

public class Discount30Strategy implements HotelSalesStrategy{
    @Override
    public double doSalesStrategy(double amount) {
        double totalAmount;
        totalAmount = amount - (amount * 0.3);
        return totalAmount;
    }
}
