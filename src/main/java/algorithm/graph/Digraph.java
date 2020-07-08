package algorithm.graph;

import algorithm.linked.Queue;

/**
 * @author: ls
 * @date: 2020/7/6 0006 17:15
 * 有向图
 * di=direct
 * 不同于无向图，有向图边是有方向的，
 * 入度：指向某顶点的边数量
 * 出度：由某顶点发出指向其他顶点的边数量
 */
public class Digraph {

    //edge 边
    private int E;

    //vertex 顶点
    private final int V;

    private Queue<Integer>[] adj;

    public Digraph(int v){
        this.V =v;
        this.E = 0;
        //初始化邻接数组
        adj = new Queue[v];
        for (int i = 0;i<v;i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    //添加由i到j的有向边
    public void addEdge(int i, int j){
        adj[i].enQueue(j);
        E++;
    }

    public int E(){
        return E;
    }

    public int V(){
        return V;
    }

    //获取邻接表
    public Queue<Integer> adj(int j){
        return adj[j];
    }

    //获取反向图
    public Digraph reverse(){
        //反向图顶点个数一致
        Digraph r = new Digraph(V);
        //将当前顶点的邻接表找到，给每一个邻接表的每一个元素添加一条由该元素发出的边
        for (int i = 0; i < r.V(); i++) {
            Queue<Integer> a = adj[i];
            for (Integer integer : a) {
                r.addEdge(integer,i);
            }
        }
        return r;
    }
}
