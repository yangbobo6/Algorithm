/**
 * @author zhangsan
 * @date 2021-05-29 16:33
 */
public class DecorationPattern {
    public static void main(String[] args) {
        new RobotDecoration(new FirstRobot()).doSomethings();
    }
}

interface Robot{
    void doSomethings();
}

class FirstRobot implements Robot{
    @Override
    public void doSomethings() {
        System.out.println("Singing");
        System.out.println("talking");
    }
}

class RobotDecoration implements Robot{

    Robot robot;
    public RobotDecoration(Robot robot){
        this.robot = robot;
    }
    @Override
    public void doSomethings() {
        robot.doSomethings();
        System.out.println("Dancing");
    }
}
