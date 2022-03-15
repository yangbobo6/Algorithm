package com.yangbo.server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器 -----专门解析xml文件   获取标签，标签里面的内容等信息
 */

public class WebHandler extends DefaultHandler {

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
        System.out.println("--开始解析");
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
