import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
   Member mem= (Member) ctx.getBean("member");

        System.out.println(mem);  Member mem2= (Member) ctx.getBean("member");

        System.out.println(mem2);
    }
}
