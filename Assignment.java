package com.sethboston;

import java.time.LocalDateTime;

public class Assignment extends Task {
    private LocalDateTime deadLine;

    public Assignment(String label, LocalDateTime deadLine) {
        super(label);
        this.deadLine = deadLine;
    }

}
