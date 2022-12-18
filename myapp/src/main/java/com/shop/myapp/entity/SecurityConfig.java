package com.shop.myapp.entity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.shop.myapp.service.MemberService;

import lombok.RequiredArgsConstructor;

@SuppressWarnings("deprecation")
@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MemberService memberService;
    //규칙 설정 @param http @throws Exception
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers( "/member/login", "/member/signUp", "/member/join", "/member/login_denied", "/member/user_access", "/member/logout", "member/logout_result", "/member/**", "/resources/**").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
                // USER, ADMIN 접근 허용
                .antMatchers("/member/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
            .formLogin()
                .loginPage("/member/login")
                .loginProcessingUrl("/member/login_proc")
                .defaultSuccessUrl("/member/user_access")
                .failureUrl("/member/login_denied") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
                .permitAll()
                .and()//로그인 창
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .invalidateHttpSession(true)
        		.and()
        		.csrf().disable();
    }

    //로그인 인증 처리 메소드 @param auth @throws Exception
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
    }
}