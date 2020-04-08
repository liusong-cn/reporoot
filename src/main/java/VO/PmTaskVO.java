package VO;

import java.util.List;

/**
 * @author: ls
 * @date: 2020/4/3 0003 14:43
 */
public class PmTaskVO {
    private String name;
    private String taskType1;
    private String taskType2;
    private String startTime;
    private String endTime;
    private String assigner;
    private String projectCode;
    private String state;
    private String requirement;
    private String owner;
    private String taskLevel;
    private String monitorLevel;
    private String taskId;
    private String pid;
    private List<PmTaskInputVO> inputs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskType1() {
        return taskType1;
    }

    public void setTaskType1(String taskType1) {
        this.taskType1 = taskType1;
    }

    public String getTaskType2() {
        return taskType2;
    }

    public void setTaskType2(String taskType2) {
        this.taskType2 = taskType2;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(String taskLevel) {
        this.taskLevel = taskLevel;
    }

    public String getMonitorLevel() {
        return monitorLevel;
    }

    public void setMonitorLevel(String monitorLevel) {
        this.monitorLevel = monitorLevel;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<PmTaskInputVO> getInputs() {
        return inputs;
    }

    public void setInputs(List<PmTaskInputVO> inputs) {
        this.inputs = inputs;
    }
}
