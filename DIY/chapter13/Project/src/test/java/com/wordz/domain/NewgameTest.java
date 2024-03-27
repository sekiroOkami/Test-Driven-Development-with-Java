package com.wordz.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class NewgameTest {
    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private Wordz wordz;

    @Test
    void startsNewGame() {
        var game = new Wordz();
        var player = new Player();
        game.newGame(player);

        var gameArgument = ArgumentCaptor.forClass(Wordz.class);
        verify(gameRepository)
                .create(gameArgument.capture());
        var game = gameArgument.getValue();

    }
}