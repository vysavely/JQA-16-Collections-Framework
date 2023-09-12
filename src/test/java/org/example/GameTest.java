package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Иван", 25);
    Player player2 = new Player(2, "Олег", 15);
    Player player3 = new Player(20, "Андрей", 40);
    Player player4 = new Player(35, "Василий", 40);
    Player player5 = new Player(55, "Максим", 60);

    @Test
    public void shouldWinPlayer1() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Иван", "Олег");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Game game = new Game();

        game.register(player3);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Андрей", "Максим");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawnGameTest() { //ничья, силы участников равны
        Game game = new Game();

        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Андрей", "Василий");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredPlayer1() {
        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oleg", "Олег");
        });
    }

    @Test
    public void notRegisteredPlayer2() {
        Game game = new Game();

        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Андрей", "Anton");
        });
    }
}