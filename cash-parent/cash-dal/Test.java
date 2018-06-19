import java.net.URL; 
public class Test {

public static void main(String args[]) { 
        System.out.println("Hello World!"); 
URL url;
url=Thread.currentThread().getContextClassLoader().getResource("file:/Users/huang/work/cashtemplate/cash-parent/cash-dal/src/main/resources/init.properties");
url=Thread.currentThread().getContextClassLoader().getResource("./Test.class");
url=Test.class.getClassLoader().getResource("/Users/huang/work/cashtemplate/cash-parent/cash-dal/Test.class");
url=Test.class.getClassLoader().getResource("file://./");
System.out.println(url);
}
}
