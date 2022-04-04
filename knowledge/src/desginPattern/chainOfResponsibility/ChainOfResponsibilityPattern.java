package desginPattern.chainOfResponsibility;

/**
 * @Author: yangbo
 * @Date: 2022-03-30-10:36
 * @Description:
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        handler2.handleRequest(6);
    }
}
