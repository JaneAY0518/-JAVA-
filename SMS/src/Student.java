

/**
 * @version 2.0
 * @Date 2022/6/17
 */

public class Student {
    private String id;
    private String name;
    private String classes;
    private String major;
    private String telephone;

    //无参构造
    public Student() {

    }

    public Student(String id, String name, String classes, String major, String telephone) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.major = major;
        this.telephone = telephone;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMajor() {
        return major;
    }

    public String getClasses() {
        return classes;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return "Card{" + "id:" + id + ",name:" + name + ",classes:" + classes +
                ",major:" + major + ",telephone:" + telephone + "}";
    }
}