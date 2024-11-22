import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String genre, String movie);
}

// Concrete Observer: User
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String genre, String movie) {
        System.out.println("Hello " + name + ", a new " + genre + " movie has been uploaded: " + movie);
    }
}

// Observable Class: GenreNotifier
class GenreNotifier {
    private String genreName;
    private List<Observer> subscribers;

    public GenreNotifier(String genreName) {
        this.genreName = genreName;
        this.subscribers = new ArrayList<>();
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
            subscriber.update(genreName, movie);
        }
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
        thrillerNotifier.addSubscriber(user1);
        horrorNotifier.addSubscriber(user1);
        horrorNotifier.addSubscriber(user2);
        comedyNotifier.addSubscriber(user3);

        // Notify users of new movies
        thrillerNotifier.notifySubscribers("Inception");
        horrorNotifier.notifySubscribers("The Conjuring");
        comedyNotifier.notifySubscribers("The Hangover");
    }
}
