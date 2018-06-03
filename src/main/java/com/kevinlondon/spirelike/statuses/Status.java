package com.kevinlondon.spirelike.statuses;

import lombok.Getter;

public abstract class Status {

    @Getter
    protected int duration;

    public Status(final int duration) {
        this.duration = duration;
    }

}
