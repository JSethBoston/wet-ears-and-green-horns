package com.sethboston;

public class Main {

    public static void main(String[] args) {
        Participant testPerson1 = new Participant("Seth");
        Task task1 = new Task("Vacuum");
        testPerson1.undertakeTask(task1);
        testPerson1.abortTask(task1);

    }
}
