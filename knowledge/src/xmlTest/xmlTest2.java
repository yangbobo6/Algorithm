package xmlTest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-17:43
 * @Description:
 */
public class xmlTest2 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //sax解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂中获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.加载文档 Document注册解析器
        //4.编写处理器
        PersonHandler handler = new PersonHandler();
        //5.解析  当前线程的类加载器
        parse.parse(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("xmlTest/p.xml"),handler);

        //获取数据
        List<Person> personList = handler.getPersons();
        System.out.println(personList.size());
        for (Person p:personList
             ) {
            System.out.println(p.getName()+"-->"+p.getAge());
        }
    }
}

class PersonHandler extends DefaultHandler {

    private List<Person> persons;
    private Person person;
    private String tag;  //存储操作的标签

    public List<Person> getPersons() {
        return persons;
    }

    //开始解析文档
    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<Person>();

    }

    //解析开始标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //只关注qName  标签名person  -->name  -->age
        System.out.println(qName);

        if (qName!=null){
            tag = qName;
            if(qName.equals("person")){
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contests = new String(ch,start,length).trim();
        if(tag!=null){  //处理为空的问题
            if(tag.equals("name")){
                person.setName(contests);
            }else if(tag.equals("age")){
                if(contests.length()>0){
                    //age后面会被 空字符串 覆盖，
                    person.setAge(Integer.valueOf(contests));
                }
            }
        }
    }

    //解析结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"标签解析结束");
        if(qName!=null){
            if(qName.equals("person")){
                persons.add(person);
            }
            //将tag丢弃，防止赋空值
            tag = null;
        }
    }

    //结束
    @Override
    public void endDocument() throws SAXException {


    }
}
