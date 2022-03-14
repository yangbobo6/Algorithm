package servlet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yangbo
 * @Date: 2022-03-13-20:54
 * @Description:
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
