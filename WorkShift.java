package com.sethboston;

import java.time.LocalDateTime;

public class WorkShift extends Task {
    private LocalDateTime inTime;
    private LocalDateTime outTime;

    public WorkShift(String label, LocalDateTime inTime, LocalDateTime outTime) {
        super(label);
        this.inTime = inTime;
        this.outTime = outTime;
    }

    @Override
    public boolean setTaskToStarted() {
        Boolean outBool = super.setTaskToStarted();
        if(outBool) {
            System.out.println("Clocking in at " + LocalDateTime.now());
        }
        return outBool;
    }

    @Override
    public boolean setTaskToFinished() {
        Boolean outBool = super.setTaskToFinished();
        long var = calculateTimeElapsed();
        if(outBool) {
            System.out.println("Clocking out at " + LocalDateTime.now() + " after " + var + "minutes");
        }
        return outBool;
    }

    @Override
    protected long calculateTimeElapsed() {
        return super.calculateTimeElapsed();
    }
}
