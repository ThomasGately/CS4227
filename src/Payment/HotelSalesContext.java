package Payment;

public class HotelSalesContext {
    private HotelSalesStrategy hotelSalesStrategy;
    public HotelSalesContext (HotelSalesStrategy hotelSalesStrategy){
        this.hotelSalesStrategy = hotelSalesStrategy;
    }
    public double SalesStrategy(double amount){
        return this.hotelSalesStrategy.doSalesStrategy(amount);
    }
}
