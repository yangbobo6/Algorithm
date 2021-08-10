/**
 * @author zhangsan
 * @date 2021-05-29 17:27
 */
public class ProxyPattern {
    public static void main(String[] args) {
//        Host host = new Host();
//        Proxy proxy = new Proxy(host);
//        proxy.rent();
        new Proxy(new Host()).rent();
    }
}

interface Rent{
    void rent();
}
class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}

class Proxy implements Rent{
    Host host;
    public Proxy(Host host){
        this.host = host;
    }

    @Override
    public void rent() {
        System.out.println("代理去看房子");
        host.rent();
        System.out.println("收费");
    }
}