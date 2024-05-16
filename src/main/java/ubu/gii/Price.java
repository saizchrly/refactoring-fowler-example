package ubu.gii;

public abstract class Price {
	public abstract int getPriceCode();
	public abstract double getCharge(int daysRented);
	public int getFrequentRenterPoints(Movie movie, int daysRented) {
		return getFrequentRenterPoints(daysRented);
	}
	public int getFrequentRenterPoints(int daysRented) {
		int points = 0;
		points++;
		// add bonus for a two dReay new release rental
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			points++;
		return points;
	}
}
