import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage = "usage:\n ShowMethods qualified.class.name\n";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                System.out.println("-----------------------------------------------");
                for(Constructor constructor : constructors){
                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                }
            }
        } catch (ClassNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}