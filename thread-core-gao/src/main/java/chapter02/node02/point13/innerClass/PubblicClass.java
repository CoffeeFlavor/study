package chapter02.node02.point13.innerClass;

/**
 * @author : jennie
 * @date: 2018/7/21
 * @Time: 10:58
 */
public class PubblicClass {

    private String username;

    private String password;

    public class PrivateClass{

        private String age;

        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
