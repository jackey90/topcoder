//package org.jackey.topcoder;
//
//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.util.*;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.Callable;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ThreadPoolExecutor;
//
//class Test{
//
//    /**
//     *   1. List<Node> getChilren(Node root)
//     *   2. return all lefes
//     *
//     *   a. bfs -> list<Node>
//     *       loop   - getChilrByNode()
//     *       thead poll, fix size queue
//     *       b. size full wait
//     *          size not full notity
//     *   b. tree large  ,
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//
//    }
//
//    //fixed size
//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//
//    public List<Node> getAllChildren(Node root){
//        List<Node> ret = new ArrayList();
//        Queue<Node> queue = new LinkedBlockingDeque<>(100);
//        queue.add(root);
//        while(!queue.isEmpty()){
//            Node node = queue.poll();
//            Future<List<Node>> featureList = threadPoolExecutor.submit(new Callable<Node>() {
//                getChildren(node);
//            });
//
//            if(list == null || list.isEmpty()){
//                ret.add(node);
//            }else{
//                queue.addAll(list);
//            }
//        }
//        return result;
//    }
//
//
//
//    public List<Node> getChildren(Node node){
//
//    }
//
//
//
//    class Node{
//
//    }
//
//}