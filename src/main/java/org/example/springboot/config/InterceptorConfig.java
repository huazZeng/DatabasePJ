package org.example.springboot.config;

import org.example.springboot.interceptor.CatererInterceptor;
import org.example.springboot.interceptor.LoginInterceptor;
import org.example.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private static final String[] all = {
//            "/springboot/book/**",
//            "/springboot/catererComment/**",
//            "/springboot/caterer/**",
//            "/springboot/collect/**",
//            "/springboot/foodComment/**",
//            "/springboot/food/**",
//            "/springboot/messages/**",
//            "/springboot/orderFood/**",
//            "/springboot/price/**",
            "/springboot/**"

    };

    // 与登录和注册相关的界面和请求
    public static final String[] aboutLogin = {
            "/springboot/user/login",
            "/springboot/user/register",
            "/springboot/caterer/login"

//            "/springboot/**"
    };

    public static final String[] aboutUser = {
//            "/springboot/user/login",
            "/springboot/user/**",
            "/springboot/caterer/login",
            "/springboot/user/update",
            "/springboot/user/login",
            "/springboot/user/get-my",
            "/springboot/user/book",
            "/springboot/caterer/login",
            "/springboot/caterer/findInterested",
            "/springboot/caterer/findDetailById",
            "/springboot/catererComment/findDetailById",
            "/springboot/food/searchInterestedFoodsInCaterer",
            "/springboot/food/findDetailById",
            "/springboot/orders/**",
            "/springboot/foodCollect/**",
            "/springboot/catererCollect/**",
            "/springboot/messages/find-my",
            "/springboot/catererComment/**",
            "/springboot/foodComment/**",


//            "/springboot/**"

    };

    public static final String[] aboutCaterer= {
//            "/springboot/user/login",
//            "/springboot/user/register",
            "/springboot/caterer/login",
            "/springboot/caterer/find-my",
            "/springboot/caterer/insert",
            "/springboot/caterer/change-price",
            "/springboot/caterer/completeOrder",
            "/springboot/caterer/change-type",
            "/springboot/caterer/findMyOrder",
            "/springboot/user/login",

//            "/springboot/**"
    };



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(all)
                .excludePathPatterns(aboutLogin);

        registry.addInterceptor(new CatererInterceptor())
                .addPathPatterns(all)
                .excludePathPatterns(aboutCaterer);

        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns(all)
                .excludePathPatterns(aboutUser);


    }
}
