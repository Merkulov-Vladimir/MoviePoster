package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.MoviePoster;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

public class PosterManagerTestNonEmpty {
    private PosterRepository repository = Mockito.mock(PosterRepository.class);
    private PosterManager manager = new PosterManager(repository);
    MoviePoster one = new MoviePoster("Brat", 1);
    MoviePoster two = new MoviePoster("Brat2", 2);
    MoviePoster three = new MoviePoster("Brat3", 3);
    MoviePoster four = new MoviePoster("Brat4", 4);

    @Test
    public void getAll() {
        MoviePoster[] returned = {one, two, three, four};
        doReturn(returned).when(repository).findAll();
        MoviePoster[] expected = {four, three, two, one};
        MoviePoster[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
