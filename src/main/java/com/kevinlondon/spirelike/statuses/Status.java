package com.kevinlondon.spirelike.statuses;

import lombok.Getter;

public class Status {

    @Getter
    protected int duration;

    public Status(StatusType statusType, final int duration) {
        this.duration = duration;
    }

}
