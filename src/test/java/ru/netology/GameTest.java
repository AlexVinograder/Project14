package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void firstPlayerWinTest() {
        Player captainAmerica = new Player(1, "CaptainAmerica", 1500);
        Player ironMan = new Player(2, "IronMan", 1000);
        Game game = new Game();

        game.register(captainAmerica);
        game.register(ironMan);

        int expected = game.round("CaptainAmerica", "IronMan");
        int actual = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerWinTest() {
        Player captainAmerica = new Player(1, "CaptainAmerica", 1000);
        Player ironMan = new Player(2, "IronMan", 1500);
        Game game = new Game();

        game.register(captainAmerica);
        game.register(ironMan);

        int expected = game.round("CaptainAmerica", "IronMan");
        int actual = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bothPlayersEqualTest() {
        Player captainAmerica = new Player(1, "CaptainAmerica", 1500);
        Player ironMan = new Player(2, "IronMan", 1500);
        Game game = new Game();

        game.register(captainAmerica);
        game.register(ironMan);

        int expected = game.round("CaptainAmerica", "IronMan");
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerNotExistTest() {
        Player captainAmerica = new Player(1, "CaptainAmerica", 1500);
        Player ironMan = new Player(2, "IronMan", 1500);
        Game game = new Game();

        game.register(captainAmerica);
        game.register(ironMan);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Thanos", "IronMan")
        );
    }

    @Test
    public void SecondPlayerNotExistTest() {
        Player captainAmerica = new Player(1, "CaptainAmerica", 1500);
        Player ironMan = new Player(2, "IronMan", 1500);
        Game game = new Game();

        game.register(captainAmerica);
        game.register(ironMan);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("CaptainAmerica", "Thanos")
        );
    }

    @Test
    public void BothPlayersNotExistTest() {
        Player captainAmerica = new Player(1, "CaptainAmerica", 1500);
        Player ironMan = new Player(2, "IronMan", 1500);
        Game game = new Game();

        game.register(captainAmerica);
        game.register(ironMan);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("DeadPool", "Thanos")
        );

    }
}
