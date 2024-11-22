import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Observer Interface
interface Observer {
    void update(String genre, String movie);
}

// Concrete Observer: User
class User implements Observer {
    private String name;
    private List<String> favoriteGenres;

    public User(String name) {
        this.name = name;
        this.favoriteGenres = new ArrayList<>();
    }

    public void addFavoriteGenre(String genre) {
        if (!favoriteGenres.contains(genre)) {
            favoriteGenres.add(genre);
        }
    }

    public void removeFavoriteGenre(String genre) {
        favoriteGenres.remove(genre);
    }

    public List<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    @Override
    public void update(String genre, String movie) {
        if (favoriteGenres.contains(genre)) {
            System.out.println("Hello " + name + ", a new " + genre + " movie has been uploaded: " + movie);
        }
    }
}

// Subject Interface
interface Subject {
    void addSubscriber(Observer subscriber);
    void removeSubscriber(Observer subscriber);
    void notifySubscribers(String movie);
}

// ConcreteSubject Class
class GenreNotifier implements Subject {
    private String genreName;
    private List<Observer> subscribers;
    private ExecutorService executor;

    public GenreNotifier(String genreName) {
        this.genreName = genreName;
        this.subscribers = new ArrayList<>();
        this.executor = Executors.newCachedThreadPool(); // Use cached thread pool for dynamic task handling
    }

    public void addSubscriber(Observer subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    public void removeSubscriber(Observer subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String movie) {
        for (Observer subscriber : subscribers) {
            executor.submit(() -> {
                subscriber.update(genreName, movie);
            });
        }
    }

    // Ensure to shutdown executor to free resources
    public void shutdownNotifier() {
        executor.shutdown();
    }
}

// Main Application
public class DesiFlix {
    public static void main(String[] args) {
        // Create Genre Notifiers
        GenreNotifier thrillerNotifier = new GenreNotifier("Thriller");
        GenreNotifier horrorNotifier = new GenreNotifier("Horror");
        GenreNotifier comedyNotifier = new GenreNotifier("Comedy");

        // Create Users
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Users subscribe to genres
        user1.addFavoriteGenre("Thriller");
        user1.addFavoriteGenre("Horror");
        user2.addFavoriteGenre("Horror");
        user2.addFavoriteGenre("Comedy");
        user3.addFavoriteGenre("Comedy");

        thrillerNotifier.addSubscriber(user1);
        horrorNotifier.addSubscriber(user1);
        horrorNotifier.addSubscriber(user2);
        comedyNotifier.addSubscriber(user2);
        comedyNotifier.addSubscriber(user3);

        // Notify users of new movies
        thrillerNotifier.notifySubscribers("Inception");
        horrorNotifier.notifySubscribers("The Conjuring");
        comedyNotifier.notifySubscribers("The Hangover");

        // Shutdown notifiers (in a real application, this would be done on exit)
        thrillerNotifier.shutdownNotifier();
        horrorNotifier.shutdownNotifier();
        comedyNotifier.shutdownNotifier();
    }
}
