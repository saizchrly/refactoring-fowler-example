package ubu.gii;

public class Children extends Price {

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	public double getCharge(int daysRented) {
		double result = 0;
		result += 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}

}
