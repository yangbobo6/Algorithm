package xmlTest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-17:43
 * @Description:
 */
public class xmlTest1 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //sax解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂中获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.加载文档 Document注册解析器
        //4.编写处理器
        PHandler handler = new PHandler();
        //5.解析  当前线程的类加载器
        parse.parse(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("xmlTest/p.xml"),handler);
    }
}

class PHandler extends DefaultHandler {
    //开始解析文档
    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //只关注qName  标签名
        System.out.println(qName+"标签解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contests = new String(ch,start,length).trim();
        if(contests.length()>0){
            System.out.println("内容为："+contests);

        }else {
            System.out.println("内容为空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"标签解析结束");
    }

    //结束
    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束");
    }
}
