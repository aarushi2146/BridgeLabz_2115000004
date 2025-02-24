
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}
class User {
    String role;
    User(String role) { this.role = role; }
    String getRole() { return role; }
}
class AdminActions {
    @RoleAllowed("ADMIN")
    void performAdminAction() { System.out.println("Admin action performed!"); }
    void performGeneralAction() { System.out.println("General action performed."); }
}
public class RoleMain {
    public static void main(String[] args) throws Exception {
        User admin = new User("ADMIN");
        User user = new User("USER");
        AdminActions actions = new AdminActions();
        executeMethod(admin, actions, "performAdminAction");
        executeMethod(user, actions, "performAdminAction");
        executeMethod(admin, actions, "performGeneralAction");
        executeMethod(user, actions, "performGeneralAction");
    }
    static void executeMethod(User user, AdminActions actions, String methodName) throws Exception {
        Method method = AdminActions.class.getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            if (method.getAnnotation(RoleAllowed.class).value().equals(user.getRole())) {
                method.invoke(actions);
            } else {
                System.out.println("Access Denied!");
            }
        } else {
            method.invoke(actions);
        }
    }
}






