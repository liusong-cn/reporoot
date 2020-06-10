package review.map2dto;

/**
 * @author: ls
 * @date: 2020/6/9 0009 22:17
 */
public class UseCase {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UseCase{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
