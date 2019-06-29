package chapter03.node01.point11.stack_2_new;

/**
 * @author : jennie
 * @date: 2018/8/12
 * @Time: 11:51
 */
public class P {

    private MyStack myStack;

    public P(MyStack myStack) {
        this.myStack = myStack;
    }

    public void pushService(){
        myStack.push();
    }
}
