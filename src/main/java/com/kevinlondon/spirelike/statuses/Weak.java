package com.kevinlondon.spirelike.statuses;

import com.kevinlondon.spirelike.Status;
import lombok.Getter;

public class Weak extends Status {

    private final int duration;

    public Weak(final int duration) {
        this.duration = duration;
    }
}
