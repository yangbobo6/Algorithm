import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsan
 * @date 2021-05-28 11:45
 */
class ObservationPattern{
    public static void main(String[] args) {
        Debit yangbo = new Yangbo();
        yangbo.borrow(new WangWu());
        yangbo.borrow(new Zhaosi());
        yangbo.notifyCredits();
    }
}
//借钱人
interface Debit{
    void borrow(Credit credit);
    void notifyCredits();
}
//债主
interface Credit{
    void takeMoney();
}
class Yangbo implements Debit{
    //债主不只是一个人
    private List<Credit> allCredits= new ArrayList<>();

    @Override
    public void borrow(Credit credit){
        //添加一个观察者对象
        allCredits.add(credit);
    }

    @Override
    public void notifyCredits(){
        allCredits.forEach(credit->credit.takeMoney());
    }
}

class WangWu implements Credit{
    @Override
    public void takeMoney(){
        System.out.println("王五要钱");
    }
}
class Zhaosi implements Credit{
    @Override
    public void takeMoney(){
        System.out.println("赵四要钱");
    }
}
