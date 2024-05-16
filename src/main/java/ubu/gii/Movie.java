package ubu.gii;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	Price _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _priceCode.getPriceCode();
	}

	public double getCharge(int daysRented) {
		return _priceCode.getCharge(daysRented);
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_priceCode = new Regular();
			break;
		case CHILDRENS:
			_priceCode = new Children();
			break;
		case NEW_RELEASE:
			_priceCode = new NewRelease();
			break;
		default:
			throw new IllegalArgumentException("Incorrect PriceCode");
		}
	}
	public int getFrequentRenterPoint(int daysRented) {
		return _priceCode.getFrequentRenterPoints(daysRented);
	}
	public String getTitle() {
		return _title;
	}
}
