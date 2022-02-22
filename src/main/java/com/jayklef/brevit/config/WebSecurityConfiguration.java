package com.jayklef.brevit.config;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebAnnotationSet {
}
