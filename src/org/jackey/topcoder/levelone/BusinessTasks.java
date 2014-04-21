package org.jackey.topcoder.levelone;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 4/21/14
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement    A busy businessman has a number of equally important tasks which he must accomplish. To decide which of the tasks to perform first, he performs the following operation.
 * He writes down all his tasks in the form of a circular list, so the first task is adjacent to the last task. He then thinks of a positive number. This number is the random seed, which he calls n. Starting with the first task, he moves clockwise (from element 1 in the list to element 2 in the list and so on), counting from 1 to n. When his count reaches n, he removes that task from the list and starts counting from the next available task. He repeats this procedure until one task remains. It is this last task that he chooses to execute.
 * Given a String[] list representing the tasks and an int n, return the task which the businessman chooses to execute.
 * Definition    Class:BusinessTasksMethod:getTaskParameters:String[], intReturns:StringMethod signature:String getTask(String[] list, int n)(be sure your method is public)     Constraints-list will contain between 2 and 50 elements inclusive.-Each element in list will contain between 1 and 50 characters inclusive.-Each element in list will contain only characters 'a'-'z'.-n will be between 1 and 10000000 inclusive. Examples0)
 * {"a","b","c","d"}
 * <p/>
 * 2
 * <p/>
 * Returns: "a"
 * <p/>
 * We start counting from a. So a is 1, b is 2. We remove b, so list is now {a,c,d}. We continue from c. So c is 1, d is 2. We remove d, so list is now {a,c}. We continue from a. So a is 1, c is 2. We remove c, and now we are left with the last task a.1)
 * {"a","b","c","d","e"}
 * <p/>
 * 3
 * <p/>
 * Returns: "d"
 * <p/>
 * We start counting from a. So a is 1, b is 2, c is 3. We remove c, now list = {a,b,d,e}. We continue from d. So d is 1, e is 2, a is 3. We remove a, now list = {b,d,e}. We continue from b. So b is 1, d is 2, e is 3. We remove e, now list = {b,d}. We continue from b. So b is 1, d is 2 and finally b is 3. We remove b, and now we are left with just one task d.2)
 * {"alpha","beta","gamma","delta","epsilon"}
 * <p/>
 * 1
 * <p/>
 * Returns: "epsilon"
 * <p/>
 * 3)
 * {"a","b"}
 * <p/>
 * 1000
 * <p/>
 * Returns: "a"
 * <p/>
 * 4)
 * {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
 * "u","v","w","x","y","z"}
 * <p/>
 * 17
 * <p/>
 * Returns: "n"
 * <p/>
 * 5)
 * {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
 * "olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
 * "qgcxjbfx","my","mlhy","bt","bo","q"}
 * <p/>
 * 9000000
 * <p/>
 * Returns: "fxjqzznvg"
 */
public class BusinessTasks {
    public String getTask(final String[] list, final int
            n) {
        final List<String> tasks = new ArrayList<String>();
        for (String temp : list) {
            tasks.add(temp);
        }
        for (int currentTask = (n - 1) % tasks.size();
             tasks.size() > 1;
             currentTask = (currentTask + n - 1) % tasks.size()) {
            tasks.remove(currentTask);
        }
        return tasks.get(0);
    }

    public static void main(String[] args) {
        String[] tasks =
                {"zlqamum", "yjsrpybmq", "tjllfea", "fxjqzznvg", "nvhekxr", "am", "skmazcey", "piklp",
                        "olcqvhg", "dnpo", "bhcfc", "y", "h", "fj", "bjeoaxglt", "oafduixsz", "kmtbaxu",
                        "qgcxjbfx", "my", "mlhy", "bt", "bo", "q"};
        System.out.println(new BusinessTasks().getTask(tasks, 9000000));
    }
}
