package com.yangbo.server;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-20:54
 * @Description:   xml文件的配置类
 */
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns = new HashSet<>();
    }

    public void addPattern(String pattern){
        this.patterns.add(pattern);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }
}
