package com.cerbon.brigadista_training.util;

public interface IServerPlayerMixin {
    void increaseBlocksCollected();
    void resetBlocksCollected();
    int getBlocksCollectedAmount();
}
