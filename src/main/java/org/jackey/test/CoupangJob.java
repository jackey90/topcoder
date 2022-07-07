package org.jackey.test;

import java.util.*;

public class CoupangJob implements Job{

    Map<Task, Set<Task>> dependencies = new HashMap<>();
    Map<Task, Set<Task>> reverseDependencies = new HashMap<>();

    @Override
    public void add(Task task, Task dependency) {
        add(task,dependency,dependencies);
        add(dependency,task,reverseDependencies);
    }

    private void add(Task task, Task dependency, Map<Task, Set<Task>> depen){
        Set<Task> set = depen.get(task);
        if(set == null){
            set = new HashSet();
            depen.put(task,set);
        }
        if(dependency != null){
            set.add(dependency);
        }
    }


    @Override
    public boolean hasNext() {
        for(Map.Entry<Task, Set<Task>> entry: dependencies.entrySet()){
            Set<Task> set = entry.getValue();
            if(set.size() == 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public void doNext() {
        Task task = null;
        for(Map.Entry<Task, Set<Task>> entry: dependencies.entrySet()){
            Set<Task> set = entry.getValue();
            if(set.size() == 0){
                task = entry.getKey();
                break;
            }
        }
        excuteTask(task);
    }

    /**
     * A
     * @param task
     */
    private void excuteTask(Task task){
        task.doTask();
        Set<Task> set = reverseDependencies.get(task);
        for(Task t: set){
           Set<Task> depens = dependencies.get(t);
           depens.remove(task);
        }
        dependencies.remove(task);
    }


}
