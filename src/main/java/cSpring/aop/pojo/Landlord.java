package cSpring.aop.pojo;

import org.springframework.stereotype.Component;

/**
 * <pre>
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2019/12/29 17:48
 */
@Component("landlord")
public class Landlord {

    public void service(){
        System.out.println("签合同");
        System.out.println("收房租");
    }
}
