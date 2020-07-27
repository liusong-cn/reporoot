package algorithm.graph;

import algorithm.linked.Stack;

/**
 * @author: ls
 * @date: 2020/7/8 0008 22:19
 * 结合有向环以及深度优先算法得到topo算法
 */
public class TopoAlgorithm {

    public static void main(String[] args) {
        Digraph g = new Digraph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(2,4);
        DirectedCycle dc = new DirectedCycle(g);
        //当没有有向环时，表示可以进行topo排序
        if(!dc.hasCycle()){
            DepthFirstOrder d = new DepthFirstOrder(g);
            Stack<Integer> s = d.reversePost();
            while (!s.isEmpty()){
                System.out.println(s.pop());
            }
        }
    }
}
