package com.sethboston;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task {
    private String label;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private long timeElapsed;

    public Task(String label) {
        this.label = label;
    }

    public boolean setTaskToStarted() {
        if(this.startedAt == null) {
            this.startedAt = LocalDateTime.now();
            System.out.println("Starting task at " + startedAt);
            return true;
        }else if(finishedAt == null) {
            System.out.println("Already doing task");
            return false;
        }else {
            System.out.println("Task has already been done");
            return false;
        }
    }

    public boolean setTaskToFinished() {
        if(this.startedAt != null && this.finishedAt == null) {
            this.finishedAt = LocalDateTime.now();
            this.timeElapsed = calculateTimeElapsed();
            System.out.println("Finished " + this.label + " at " + this.finishedAt + ". Total time elapsed: " + this.timeElapsed);
            return true;
        }else if(this.startedAt == null) {
            System.out.println("This task has not been started yet");
            return false;
        }else {
            System.out.println("Task already completed");
            return false;
        }
    }

    public boolean setTaskAbort() {
        if(this.startedAt != null && this.finishedAt == null) {
            this.startedAt = null;
            System.out.println("Total time wasted: " + this.timeElapsed);
            System.out.println("Task aborted at " + LocalDateTime.now());
            return true;
        }else if(this.finishedAt != null) {
            System.out.println("Error: Cannot abort task. It has already been completed");
        }else {
            System.out.println("Error: cannot abort task. It has not yet been started.");
        }
        return false;
    }

    protected long calculateTimeElapsed() {
        if(this.startedAt != null && this.finishedAt != null) {
            long spanInMinutes = Duration.between(this.startedAt, this.finishedAt).toMinutes();
            long hours = spanInMinutes / 60;
            long minutes = spanInMinutes % 60;
            System.out.println("Time elapsed on this task: " + hours + " hours and " + minutes + " minutes");
            return spanInMinutes;
        }
        return -1;
    }

    public String getLabel() {
        return label;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }
}