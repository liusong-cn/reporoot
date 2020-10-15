package algorithm.uftree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author:ls
 * @date: 2020/05/14 17:10
 * 道路通工程，
 * 为了完成某市每个乡镇道路相通的目标，计算还需修多少道路
 * 输入:文件roads_project.csv,
 * 第一行表示乡镇个数，第二行表示已有道路条数，后续每行表示已通道路的两个乡镇
 * eg   20
 *      2
 *      0,1
 *      3,4
 **/
public class RoadsConnected {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(RoadsConnected.class.getResourceAsStream("roads_project.csv"))
        )){
            int count = Integer.parseInt(br.readLine());
            UFTreeWeighted ufTreeWeighted = new UFTreeWeighted(count);
            //互通乡镇数
            int total = Integer.parseInt(br.readLine());
            for (int i = 0; i < total; i++) {
                String[] s = br.readLine().split(",");
                //将两个乡镇相连
                ufTreeWeighted.union(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            }
            System.out.println("还需要开通的道路数:" + (ufTreeWeighted.getCount() -1));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
