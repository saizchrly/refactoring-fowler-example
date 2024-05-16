package ubu.gii;

public class NewRelease extends Price {

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	public double getCharge(int daysRented) {
		double result = 0;
		result += daysRented * 3;
		return result;
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
