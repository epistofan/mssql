import com.example.mssql.SecurityFilters.AuthFilter;
import com.example.mssql.SecurityFilters.CustomFilter2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebConfig {

    @Bean
    public FilterRegistrationBean authFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new AuthFilter ());
        filterRegBean.addUrlPatterns("/*");
        filterRegBean.setEnabled(Boolean.TRUE);
        filterRegBean.setName("Meu Filter1");
        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE -2);
        return filterRegBean;


    }


    @Bean
    public FilterRegistrationBean customFilter2() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new CustomFilter2());
        filterRegBean.addUrlPatterns("/index/*");
        filterRegBean.setEnabled(Boolean.TRUE);
        filterRegBean.setName("Meu Filter");
        filterRegBean.setOrder(Ordered.LOWEST_PRECEDENCE - 1);
        return filterRegBean;


    }
}