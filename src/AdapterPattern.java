/**
 * @author zhangsan
 * @date 2021-05-29 17:06
 */
public class AdapterPattern {
    public static void main(String[] args) {
        new Adapter(new Speaker()).translate();
    }
}

class Speaker{
    public String speak(){
        return "CH No.1";
    }
}

interface Translator{
    public String translate();
}

class Adapter implements Translator{

    Speaker speaker;
    public Adapter(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String result = speaker.speak();

        return result;
    }
}