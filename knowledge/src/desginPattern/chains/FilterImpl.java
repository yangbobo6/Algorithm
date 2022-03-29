package desginPattern.chains;

import java.util.List;

/**
 * @Author: yangbo
 * @Date: 2022-03-29-20:23
 * @Description:
 */
public class FilterImpl implements FilterChain {

    private List<Filter> filters;
    private int filterIndex = 0;

    @Override
    public void doFilter() {
        if (filterIndex<filters.size()){
            filters.get(filterIndex).next(this);
        }
    }
}
