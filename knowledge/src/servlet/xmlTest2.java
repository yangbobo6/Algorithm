package servlet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-17:43
 * @Description:
 */
public class xmlTest2 {
    public static void main(String[] args) throws Exception {
        //sax解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂中获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.加载文档 Document注册解析器
        //4.编写处理器
        WebHandler handler = new WebHandler();
        //5.解析  当前线程的类加载器
        parse.parse(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("servlet/web.xml"),handler);

        //获取数据  在WebContext 构造方法中，有访问的跟路径，定位到类名称
        WebContext context = new WebContext(handler.getEntities(),handler.getMappings());
        //假设输入 /login
        String className = context.getClz("/reg");
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet) clz.getConstructor().newInstance();
        System.out.println(servlet);
        servlet.service();

    }
}

class WebHandler extends DefaultHandler {

    private List<Entity> entities;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;  //存储操作的标签
    private String tag;
    private boolean isMapping;

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    //开始解析文档
    @Override
    public void startDocument() throws SAXException {
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();

    }

    //解析开始标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //只关注qName  标签名person  -->name  -->age

        if (qName!=null){
            tag = qName;
            if(tag.equals("servlet")){
                entity = new Entity();
                isMapping = false;

            }else if(tag.equals("servlet-mapping")){
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contests = new String(ch,start,length).trim();
        if(tag!=null){  //处理为空的问题
            if(isMapping){  //操作servlet-mapping
                if(tag.equals("servlet-name")){
                    mapping.setName(contests);
                }else if(tag.equals("url-pattern")){
                    if(contests.length()>0){
                        //age后面会被 空字符串 覆盖，
                        mapping.addPattern(contests);
                    }
                }
            }else {  //操作servlet
                if(tag.equals("servlet-name")){
                    entity.setName(contests);
                }else if(tag.equals("servlet-class")){
                    if(contests.length()>0){
                        //age后面会被 空字符串 覆盖，
                        entity.setClz(contests);
                    }
                }
            }





        }
    }

    //解析结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName!=null){
            if(qName.equals("servlet")){
                entities.add(entity);
            }else if(qName.equals("servlet-mapping")){
                mappings.add(mapping);
            }
        }
        //将tag丢弃，防止赋空值
        tag = null;
    }

}
