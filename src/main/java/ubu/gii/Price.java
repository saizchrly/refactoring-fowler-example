package ubu.gii;

public abstract class Price {
	public abstract int getPriceCode();
	public double getCharge (Movie movie,int daysRented) {
		return getCharge(daysRented);
	}
	public abstract double getCharge(int daysRented);
}
