package org.example.springboot;

import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/api/**").authenticated() // 设置需要认证的API路径
//                .anyRequest().permitAll() // 其他路径允许访问
//                .and()
//                .formLogin()
//                .loginPage("/login") // 登录页的路径
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//}
