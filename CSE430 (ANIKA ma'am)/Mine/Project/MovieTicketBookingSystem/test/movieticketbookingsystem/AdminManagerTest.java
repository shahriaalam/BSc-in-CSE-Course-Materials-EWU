package movieticketbookingsystem;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.fail;

public class AdminManagerTest {

    private AdminManager adminManager;
    private MovieManager movieManager;
    private ShowtimeManager showtimeManager;
    private UserManager userManager;

    @Before
    public void setUp() {
        movieManager = new MovieManager();
        showtimeManager = new ShowtimeManager();
        adminManager = new AdminManager(movieManager, showtimeManager);
        userManager = new UserManager();
    }

    @Test
    public void testShowTotalRevenue() {
        Movie movie = new Movie("Test Movie", "Action", 120, 8.5);
        Showtime showtime = new Showtime(movie, "18:00", 100, 10.0);

        showtimeManager.getShowtimes().add(showtime);

        adminManager.displayRevenueReports(new Scanner("1\n4\n"));
    }

    @Test
    public void testShowRevenueByMovie() {
        Movie movie = new Movie("Another Movie", "Drama", 90, 7.5);
        Showtime showtime = new Showtime(movie, "20:00", 50, 8.0);

        showtimeManager.getShowtimes().add(showtime);

        adminManager.displayRevenueReports(new Scanner("2\n4\n"));
    }

    @Test
    public void testManageMovies_AddAndList() {
        Scanner scanner = new Scanner("1\nTest Movie\nComedy\n110\n7.2\n4\n5\n");

        adminManager.manageMovies(scanner);
    }

    @Test
    public void testManageShowtimes_AddAndList() {
        movieManager.addMovie("Showtime Movie", "Horror", 100, 6.8);

        Scanner scanner = new Scanner("1\n0\n21:00\n80\n9.5\n4\n5\n");

        adminManager.manageShowtimes(scanner);
    }

    @Test
    public void testDisplayAnalytics() {

        Movie movie = new Movie("Analytics Movie", "Thriller", 105, 8.0);
        Showtime showtime = new Showtime(movie, "19:00", 70, 11.0);
        showtimeManager.getShowtimes().add(showtime);

        List<User> users = new ArrayList<>();
        users.add(new User("user1", "password1", "User"));

        adminManager.displayAnalytics(userManager);
    }

    @Test
    public void testShowTotalRevenue_NoShowtimes() {

        adminManager.displayRevenueReports(new Scanner("1\n4\n"));

    }

    @Test
    public void testShowRevenueByMovie_NoShowtimes() {

        adminManager.displayRevenueReports(new Scanner("2\n4\n"));
    }

    @Test
    public void testShowRevenueByShowtime_NoShowtimes() {

        adminManager.displayRevenueReports(new Scanner("3\n4\n"));
    }

    @Test
    public void testManageMovies_NullInput() {
        try {
            adminManager.manageMovies(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void testManageShowtimes_NullInput() {
        try {
            adminManager.manageShowtimes(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void testDisplayRevenueReports_NullInput() {
        try {
            adminManager.displayRevenueReports(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void testDisplayAnalytics_NullUserManager() {
        try {
            adminManager.displayAnalytics(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void testDisplayAnalytics_NoUsers() {

        adminManager.displayAnalytics(userManager);
    }

    @Test
    public void testRevenueWithZeroValues() {
        Movie movie = new Movie("Zero Movie", "Sci-Fi", 0, 0.0);
        Showtime showtime = new Showtime(movie, "00:00", 0, 0.0);

        showtimeManager.getShowtimes().add(showtime);

        adminManager.displayRevenueReports(new Scanner("1\n4\n"));
    }
    
  
    @Test
    public void testAddShowtimeWithNegativeTicketPrice() {
    movieManager.addMovie("Test Movie", "Action", 120, 8.5);
    Scanner scanner = new Scanner("1\n0\n18:00\n100\n-10.0\n4\n5\n"); 
    adminManager.manageShowtimes(scanner);
    }
    
    @Test
    public void testAddShowtimeWithZeroSeats() {
    movieManager.addMovie("Test Movie", "Action", 120, 8.5);
    Scanner scanner = new Scanner("1\n0\n18:00\n0\n15.0\n4\n5\n"); 
    adminManager.manageShowtimes(scanner);
    }
    
    @Test
    public void testAddMovieWithInvalidRating() {
    Scanner scanner = new Scanner("1\nTest Movie\nComedy\n120\n-1.0\n4\n5\n"); 
    adminManager.manageMovies(scanner);
    }

    @Test
    public void testAddShowtimeWithNullMovie() {
    Showtime showtime = new Showtime(null, "18:00", 100, 15.0);
    showtimeManager.getShowtimes().add(showtime);
    }
    
    @Test
    public void testAddMovieWithEmptyTitleOrGenre() {
        Scanner scanner = new Scanner("1\n\nComedy\n120\n8.5\n4\n5\n");
        adminManager.manageMovies(scanner);
    }

    @Test
    public void testDisplayAnalyticsWithZeroBookings() {
        adminManager.displayAnalytics(userManager); 
    }

    @Test
    public void testAddShowtimeWithInvalidTimeFormat() {
        movieManager.addMovie("Test Movie", "Action", 120, 8.5);
        Scanner scanner = new Scanner("1\n0\n25:00\n100\n15.0\n4\n5\n"); 
        adminManager.manageShowtimes(scanner);
    }
}
