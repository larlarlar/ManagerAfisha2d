import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {

    private AfishaManager manager = new AfishaManager();
    private Afisha first = new Afisha(1, "Movie.one", "url.one", "genre.one");
    private Afisha second = new Afisha(2, "Movie.two", "url.two", "genre.two");
    private Afisha third = new Afisha(3, "Movie.three", "url.three", "genre.three");
    private Afisha fourth = new Afisha(4, "Movie.four", "url.four", "genre.four");
    private Afisha fivth = new Afisha(5, "Movie.five", "url.five", "genre.five");
    private Afisha sixth = new Afisha(6, "Movie.six", "url.six", "genre.six");
    private Afisha seventh = new Afisha(7, "Movie.seven", "url.seven", "genre.seven");
    private Afisha eighth = new Afisha(8, "Movie.eight", "url.eight", "genre.eight");
    private Afisha ninth = new Afisha(9, "Movie.nine", "url.nine", "genre.nine");
    private Afisha tenth = new Afisha(10, "Movie.ten", "url.ten", "genre.ten");
    private Afisha eleventh = new Afisha(11, "Movie.eleven", "url.eleven", "genre.eleven");
    // private Afisha twelve = new Afisha(12, "Movie.twelve", "url.twelve", "genre.twelve");

    void setMovie() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fivth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        //   manager.add(twelve);
    }

    @Test
    void shouldAddNoFilm() {
        Afisha[] expected = new Afisha[0];
        Afisha[] actual = manager.getItems();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllButNewestFirst() {
        manager = new AfishaManager(10);
        setMovie();
        Afisha[] actual = manager.getNewest();
        Afisha[] expected = new Afisha[]{eleventh, tenth, ninth, eighth, seventh, sixth, fivth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAFewNewestFirst() {
        manager = new AfishaManager(5);
        setMovie();
        Afisha[] actual = manager.getNewest();
        Afisha[] expected = new Afisha[]{eleventh, tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    //в данном тесте не задаю количество фильмов, которые хочу, чтобы афиша показала и по умолчанию выпадают 10 последних
    void shouldntGetMoreThanTen() {
        manager = new AfishaManager();
        setMovie();
        Afisha[] actual = manager.getNewest();
        Afisha[] expected = new Afisha[]{eleventh, tenth, ninth, eighth, seventh, sixth, fivth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}

