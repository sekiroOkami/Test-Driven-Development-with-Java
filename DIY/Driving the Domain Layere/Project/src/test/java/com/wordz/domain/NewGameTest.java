package com.wordz.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NewGameTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private Wordz wordz;

    @Test
    void startsNewGame() {
        // setup port handles the request to start a new game
//        var wordz = new Wordz();
        var player = new Player();// player that start new game

        // act
        wordz.newGame(player);
        var gameArgument = ArgumentCaptor.forClass(Game.class);
        verify(gameRepository).create(gameArgument.capture());
        var game = gameArgument.getValue();

        assertThat(game.getWord()).isEqualTo("ARISE");
        assertThat(game.getAttemptNumber()).isZero();
        assertThat(game.getPlayer()).isSameAs(player);
    }
}
