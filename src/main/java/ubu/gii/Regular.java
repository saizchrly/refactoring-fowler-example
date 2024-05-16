package ubu.gii;

public class Regular extends Price {

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	public double getCharge(int daysRented) {
		double result = 0;
		result += 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
