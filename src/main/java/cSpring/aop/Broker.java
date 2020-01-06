package cSpring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2019/12/29 17:50
 */
@Component
@Aspect
public class Broker {

    @Before("execution(* cSpring.aop.pojo.Landlord.service())")
    public void before(){
        System.out.println("带租客看房");
        System.out.println("谈价格");
    }

    @After("execution(* cSpring.aop.pojo.Landlord.service())")
    public void after(){
        System.out.println("交钥匙");
    }
}
