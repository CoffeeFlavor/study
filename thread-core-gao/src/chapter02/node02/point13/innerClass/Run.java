package chapter02.node02.point13.innerClass;

import chapter02.node02.point13.innerClass.PubblicClass;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 11:06
 */
public class Run {

    public static void main(String[] args) {

        PubblicClass pubblicClass=new PubblicClass();
        pubblicClass.setUsername("usernameValue");
        pubblicClass.setPassword("passwordValue");

        System.out.println(pubblicClass.getUsername()+" " +pubblicClass.getPassword());

        PubblicClass.PrivateClass privateClass =pubblicClass.new PrivateClass();

        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge()+ " "+privateClass.getAddress());
    }
}