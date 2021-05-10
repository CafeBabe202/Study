package cn.happyonion801.study.spring.bean;

public class Orders {
    private String name;

    public Orders(){
        System.out.println("1、通过构造器创建对象");
    }

    public void setName(String name) {
        System.out.println("2、为bean设置属性和其他bean的引用 ==通过set方法==");
        this.name = name;
    }

    //创建执行的初始化方法 ==叫啥都行==
    public void initMethod(){
        System.out.println("3、调用bean的初始化方法 ==需要进行配置==");
    }

    public void test(){
        System.out.println("4、bean可以使用了");
    }

    //创建销毁方法 ==叫啥都行==
    public void destroyMethod(){
        System.out.println("5、当容器关闭时，调用bean的销毁方法 ==需要进行配置==");
    }
}
