package VO;

import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @author: ls
 * @date: 2020/4/3 0003 14:55
 */
public class Test {
    public static void main(String[] args) {
        String tasks = "[{\n" +
                "\t\t\"name\": \"测试任务\",\n" +
                "\t\t\"taskType1\": \"任务大类\",\n" +
                "\t\t\"taskType2\": \"任务小类\",\n" +
                "\t\t\"startTime\": \"2020-02-20\",\n" +
                "\t\t\"endTime\": \"2020-02-20\",\n" +
                "\t\t\"assigner\": \"xialn\",\n" +
                "\t\t\"projectCode\": \"001\",\n" +
                "\t\t\"state\": \"开工\",\n" +
                "\t\t\"requirement\": \"没有要求\",\n" +
                "\t\t\"owner\": \"xialn\",\n" +
                "\t\t\"taskLevel\": \"一般\",\n" +
                "\t\t\"monitorLevel\": \"一般\",\n" +
                "\t\t\"taskId\": \"002\",\n" +
                "\t\t\"pid\": \"001\",\n" +
                "\t\t\"inputs\": [{\n" +
                "\t\t\t\"id\": \"001\",\n" +
                "\t\t\t\"name\": \"输入物1\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": \"002\",\n" +
                "\t\t\t\"name\": \"输入物2\"\n" +
                "\t\t}]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"name\": \"测试任务\",\n" +
                "\t\t\"taskType1\": \"任务大类\",\n" +
                "\t\t\"taskType2\": \"任务小类\",\n" +
                "\t\t\"startTime\": \"2020-02-20\",\n" +
                "\t\t\"endTime\": \"2020-02-20\",\n" +
                "\t\t\"assigner\": \"xialn\",\n" +
                "\t\t\"projectCode\": \"001\",\n" +
                "\t\t\"state\": \"开工\",\n" +
                "\t\t\"requirement\": \"没有要求\",\n" +
                "\t\t\"owner\": \"xialn\",\n" +
                "\t\t\"taskLevel\": \"一般\",\n" +
                "\t\t\"monitorLevel\": \"一般\",\n" +
                "\t\t\"taskId\": \"002\",\n" +
                "\t\t\"pid\": \"001\",\n" +
                "\t\t\"inputs\": [{\n" +
                "\t\t\t\"id\": \"001\",\n" +
                "\t\t\t\"name\": \"输入物1\"\n" +
                "\t\t}, {\n" +
                "\t\t\t\"id\": \"002\",\n" +
                "\t\t\t\"name\": \"输入物2\"\n" +
                "\t\t}]\n" +
                "\t}]\n";
        List<PmTaskVO> voList = JSONArray.parseArray(tasks,PmTaskVO.class);
        System.out.println(voList.get(0).getAssigner() + "====" + voList.get(0).getInputs().get(0).getName());
    }
}
