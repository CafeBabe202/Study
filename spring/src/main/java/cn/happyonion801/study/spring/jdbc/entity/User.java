package cn.happyonion801.study.spring.jdbc.entity;

public class User {
    private int id;
    private String user_name;
    private float money;

    public User() {
    }

    public User(int id, String user_name, float money) {
        this.id = id;
        this.user_name = user_name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", money=" + money +
                '}';
    }
}
