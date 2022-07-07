package org.jackey.test;


/**
 * #Function Description
 * Implement a scheduler to execute a job, one job may contains multiple tasks.
 * One task maybe has multiple dependencies, and it shouldn't be executed before its dependencies is completed.
 *
 * One example,
 * A|     |D->F|
 *  |->C->|    |->H
 * B|     |E->G|
 *
 * #Expectation:
 * 1.Design interface & classes, follow design principles.
 * 2.Parse the dependencies for each task correctly.
 * 3.Scheduler can execute tasks based on the dependencies.
 * 4.Should consider some edge case like one job has multiple root tasks.
 * 5.Good coding style, easy-reading code style is a plus.
 */
public class TestTask {

    /**
     *  1. 计算出所有job之间的依赖关系
     *     数据结构：
     *     A Map<A,Set<>>
     *
     *  2. 把所有无需依赖的job放入到queue中
     *  3. 先进先出，依次执行。
     *      3.1 执行之后把依赖节点的依赖删掉
     *      3.2 如果依赖节点，入度为0，加入queue中
     */

    /**
     * Job
     *
     *  addTask(Task cur, Task dependency);
     *
     *  next();
     *
     *  hasNext();
     */

    public static void main(String[] args) {
        Job job = new CoupangJob();
        Task taskA = new CoupangTask("A");
        Task taskB = new CoupangTask("B");
        Task taskC = new CoupangTask("C");
        Task taskD = new CoupangTask("D");
        Task taskE = new CoupangTask("E");
        Task taskF = new CoupangTask("F");
        Task taskG = new CoupangTask("G");
        Task taskH = new CoupangTask("H");

        job.add(taskA,null);
        job.add(taskB,null);
        job.add(taskC,taskA);
        job.add(taskC,taskB);

        job.add(taskD,taskC);
        job.add(taskE,taskC);

        job.add(taskF,taskD);
        job.add(taskG,taskE);

        job.add(taskH,taskF);
        job.add(taskH,taskG);

        while(job.hasNext()){
            job.doNext();
        }
    }
}
