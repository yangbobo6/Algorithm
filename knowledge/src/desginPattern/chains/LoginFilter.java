package desginPattern.chains;

/**
 * @Author: yangbo
 * @Date: 2022-03-29-20:41
 * @Description:
 */
public class LoginFilter implements Filter{


    @Override
    public void next(FilterChain filterChain,int index) {
        System.out.println("chainIndex"+index+"正在处理");
        filterChain.doFilter();
    }
}
