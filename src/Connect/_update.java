package Connect;

public class _update {
    private int id;
    private String name;
    private int age;
    private float avg;
    private _update(){

    }
    public _update(int id, String name, int age, float avg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avg = avg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}
