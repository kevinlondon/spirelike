package com.kevinlondon.spirelike.statuses;

import lombok.Getter;

public class Weak {

    @Getter
    private final int duration;

    public Weak(int duration) {
        this.duration = duration;
    }
}
