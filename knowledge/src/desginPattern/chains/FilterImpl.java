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
    private Filter filter;


    @Override
    public void doFilter() {
        if (filterIndex<filters.size()){
            filters.get(filterIndex).next(this,filterIndex);
        }
    }

    public static void main(String[] args) {
        FilterImpl filter = new FilterImpl();
        Filter filter1 = new LoginFilter();
        Filter filter2 = new LoginFilter();

        filter.doFilter();
    }
}
