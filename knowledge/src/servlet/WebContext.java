package servlet;

import java.util.HashMap;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-21:31
 * @Description:    相当于一个工具类  通过url中的地址定位到 类名称
 */
public class WebContext {
    private List<Entity> entities = null;
    private List<Mapping> mappings = null;

    //key --> servlet-name  value-->class 存储用
    private HashMap<String,String> entityMap = new HashMap<>();
    //key --> url-pattern  value --> servlet-name  存储用
    private HashMap<String,String> mappingMap = new HashMap<>();

    public WebContext(List<Entity> entities, List<Mapping> mappings) {
        this.entities = entities;
        this.mappings = mappings;

        //将entityList转成对应的Map   使用方便
        for (Entity entity:entities
             ) {
            entityMap.put(entity.getName(),entity.getClz() );
        }
        //将map对应的list转化为map
        for (Mapping mapping:mappings
             ) {
            for (String pattern:mapping.getPatterns()
                 ) {
                mappingMap.put(pattern,mapping.getName());
            }
        }
    }

    //根据url-pattern 去找 servlet name  通过url定位到类，只需要此方法就行
    public String getClz(String pattern){
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }

}
