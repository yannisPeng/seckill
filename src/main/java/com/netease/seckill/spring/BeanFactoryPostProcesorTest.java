package com.netease.seckill.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import java.util.Set;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/9/10
 */
public class BeanFactoryPostProcesorTest implements BeanFactoryPostProcessor {

    private Set<String> attrs;

    public BeanFactoryPostProcesorTest(Set<String> attrs) {
        attrs.add("a");
        attrs.add("b");
        attrs.add("c");
        this.attrs = attrs;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        for (String name : definitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            StringValueResolver valueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String s) {
                    return "******";
                }
            };
            BeanDefinitionVisitor definitionVisitor = new BeanDefinitionVisitor(valueResolver);
            definitionVisitor.visitBeanDefinition(beanDefinition);
        }
    }

    public void setAttrs(Set<String> attrs) {
        this.attrs.clear();
        for (String str : attrs) {
            this.attrs.add(str.toUpperCase());
        }
    }

}
