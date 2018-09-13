package com.sethboston;

import java.util.ArrayList;
import java.util.LinkedList;

public class Participant{
    private String name;
    private ArrayList<Task> dailyDocket;
    private ArrayList<Task> isCurrentlyDoing;
    private LinkedList<Task> completedTasks;
    private LinkedList<Task> workRecord;

    public Participant(String name) {
        this.name = name;
        this.dailyDocket = new ArrayList<>();
        this.isCurrentlyDoing = new ArrayList<>();
        this.completedTasks = new LinkedList<>();
        this.workRecord = new LinkedList<>();
    }

    public boolean undertakeTask(Task taskAtHand) {
        if(taskAtHand.setTaskToStarted()) {
            isCurrentlyDoing.add(taskAtHand);
            if(dailyDocket.contains(taskAtHand)) {
                dailyDocket.remove(taskAtHand);
            }
            return true;
        }
        return false;
    }

    public boolean finishTask(Task taskAtHand) {
        if(taskAtHand.setTaskToFinished()) {
            if(taskAtHand instanceof WorkShift) {
                workRecord.add(taskAtHand);
            }else {
                completedTasks.add(taskAtHand);
            }
            isCurrentlyDoing.remove(taskAtHand);
            return true;
        }
        return false;
    }

    public boolean abortTask(Task task) {
        if(task.setTaskAbort()) {
            isCurrentlyDoing.remove(task);
            dailyDocket.add(task);
            System.out.println("Task returned to the docket of " + this.name);
            return true;
        }else
            return false;
    }

    

}
