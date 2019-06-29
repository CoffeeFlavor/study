package chapter03.node01.point11.stack_1;

/**
 * @author : jennie
 * @date: 2018/8/12
 * @Time: 15:56
 */
public class C {

    private MyStack myStack;

    public C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService(){
        System.out.println("pop="+myStack.pop());
    }
}
