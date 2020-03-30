package com.learning.test.charpter19;

/**
 * @author: ls
 * @date: 2020/3/30 0030 23:33
 */
public enum PersonMapping implements PersonHandler {
    /**
     * 策略模式 + enum + 枚举实现接口，达到每个枚举实现一个具体的处理逻辑
     */
    NAME("name"){
        @Override
        public void handle(Person p) {
            p.setName("zhangsan");
        }
    },
    AGE("age"){
        @Override
        public void handle(Person p) {
            p.setAge(3);
        }
    }
    ;
    private String what;

    public String getWhat() {
        return what;
    }

    private PersonMapping(String what){
        this.what = what;
    }

    public static PersonMapping getIns(String type){
        for (PersonMapping mapping : PersonMapping.values()) {
            if(mapping.getWhat() == type){
                return mapping;
            }
        }
        return null;
    }
}
