package innerClass;

/**
 * Created by hujb4 on 2016/11/29.
 */
public class Test {

    public static String print(Bird bird){
        System.out.println("I Can Fly");
        return "";
    }

    public static void main(String[] args) {
        print(new Bird() {
            @Override
            public String fly(Object var) {
                System.out.println("Inner");
                System.out.println(var);
                if(var instanceof String){
                    System.out.println("String");
                }else if(var instanceof Test) {
                    System.out.println("Test");
                }
                return "1000";
            }
        });
    }
}
