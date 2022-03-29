package desginPattern.chains;

/**
 * @Author: yangbo
 * @Date: 2022-03-29-20:40
 * @Description:
 */
public interface Filter {
    public void next(FilterChain filterChain);
}
