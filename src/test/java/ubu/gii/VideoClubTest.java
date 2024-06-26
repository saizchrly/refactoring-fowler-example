package ubu.gii;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ubu.gii.Customer;
import ubu.gii.Movie;
import ubu.gii.Rental;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1

 * 
 */
public class VideoClubTest {
	protected static Movie m0, m11, m12, m2;
	protected static Customer c1,c2;
	
	@BeforeAll
	public static void setUp() {
		m11 = new Movie("Sky Captain", 1);
		m12 = new Movie("Alejandro Magno", 1);
		m0 = new Movie("Accion Mutante", 0);
		m2 = new Movie("Hermano Oso", 2);

		c1 = new Customer("Manuel");
	}

	@AfterAll
	public static void tearDown() throws Exception {}

	@Test
	public void testAlquiler() {

		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m0, 1);
		Rental r3 = new Rental(m2, 10);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);

		String salida = c1.statement();

		String salidaEsperada = new String("Rental Record for Manuel\n"
				+ "\tSky Captain\t15.0\n" + "\tAccion Mutante\t2.0\n"
				+ "\tHermano Oso\t12.0\n" + "Amount owed is 29.0\n"
				+ "You earned 4 frequent renter points");

		assertTrue(salidaEsperada.equals(salida),"Calcula mal el alquiler");

	}
	@Test
    public void testHtmlAlquiler() {
		c2 = new Customer("Manuel");
        Rental r1 = new Rental(m11, 5);
        Rental r2 = new Rental(m0, 1);
        Rental r3 = new Rental(m2, 10);

        c2.addRental(r1);
        c2.addRental(r2);
        c2.addRental(r3);

        String salida = c2.htmlStatement();

        String salidaEsperada = "<H1>Rental Record for Manuel</H1>\n"
                + "<H2>Sky Captain 15.0</H2>\n"
                + "<H2>Accion Mutante 2.0</H2>\n"
                + "<H2>Hermano Oso 12.0</H2>\n"
                + "<P>Amount owed is 29.0</P>\n"
                + "<P>You earned 4 frequent renter points</P>\n";

        assertTrue(salidaEsperada.equals(salida),"Calcula mal el alquiler");

}
	@Test
    void testMovieInitialization() {
        Movie movie = new Movie("The Matrix", Movie.REGULAR);
        assertEquals("The Matrix", movie.getTitle());
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }

    @Test
    void testSetPriceCode() {
        Movie movie = new Movie("The Matrix", Movie.REGULAR);
        movie.setPriceCode(Movie.CHILDRENS);
        assertEquals(Movie.CHILDRENS, movie.getPriceCode());
        movie.setPriceCode(Movie.NEW_RELEASE);
        assertEquals(Movie.NEW_RELEASE, movie.getPriceCode());
    }

    @Test
    void testGetChargeRegular() {
        Movie movie = new Movie("The Matrix", Movie.REGULAR);
        assertEquals(2.0, movie.getCharge(2), 0.001);
        assertEquals(3.5, movie.getCharge(3), 0.001);
    }

    @Test
    void testGetChargeChildrens() {
        Movie movie = new Movie("The Lion King", Movie.CHILDRENS);
        assertEquals(1.5, movie.getCharge(3), 0.001);
        assertEquals(1.5, movie.getCharge(2), 0.001);
        assertEquals(1.5 + (4 - 3) * 1.5, movie.getCharge(4), 0.001);
    }

    @Test
    void testGetChargeNewRelease() {
        Movie movie = new Movie("The Matrix Resurrections", Movie.NEW_RELEASE);
        assertEquals(3.0, movie.getCharge(1), 0.001);
        assertEquals(6.0, movie.getCharge(2), 0.001);
    }

    @Test
    void testGetFrequentRenterPointsRegular() {
        Movie movie = new Movie("The Matrix", Movie.REGULAR);
        assertEquals(1, movie.getFrequentRenterPoint(1));
    }

    @Test
    void testGetFrequentRenterPointsChildrens() {
        Movie movie = new Movie("The Lion King", Movie.CHILDRENS);
        assertEquals(1, movie.getFrequentRenterPoint(1));
    }

    @Test
    void testGetFrequentRenterPointsNewRelease() {
        Movie movie = new Movie("The Matrix Resurrections", Movie.NEW_RELEASE);
        assertEquals(1, movie.getFrequentRenterPoint(1));
        assertEquals(2, movie.getFrequentRenterPoint(2));
    }
    
    @Test
    void testSetPriceCodeInvalid() {
        Movie movie = new Movie("The Matrix", Movie.REGULAR);
        IllegalArgumentException thrown = assertThrows(
            IllegalArgumentException.class,
            () -> movie.setPriceCode(999),
            "Expected setPriceCode(999) to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Incorrect PriceCode"));
    }
}
