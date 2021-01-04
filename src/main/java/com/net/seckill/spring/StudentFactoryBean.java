package com.net.seckill.spring;

import com.net.seckill.po.StudentService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/6/22
 */
@Component
public class StudentFactoryBean implements FactoryBean<StudentService> {

    @Override
    public StudentService getObject() throws Exception {
        StudentService studentService = new StudentService();
        
        check(studentService);
        
        return studentService;
    }

    private void check(StudentService studentService) {
        studentService.setName("李四");
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
    
    

}
