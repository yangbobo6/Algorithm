package desginPattern.chainOfResponsibility;

/**
 * @Author: yangbo
 * @Date: 2022-03-30-10:37
 * @Description:
 */
public abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract void handleRequest(int n);
}

class ConcreteHandler1 extends Handler{

    @Override
    public void handleRequest(int n) {
        if(n<5){
            System.out.println("handler1处理成功");
        }else {
            getNext().handleRequest(n);
        }
    }
}

class ConcreteHandler2 extends Handler{

    @Override
    public void handleRequest(int n) {
        if(n<10){
            System.out.println("handler2处理成功");
        }
    }
}
