import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authorization {

    private static boolean checkLogin(String string) throws WrongLoginException {
        String valid = "^[a-z0-9_-]{3,20}$";
        Pattern pattern = Pattern.compile(valid, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new WrongLoginException("Вы ввели неверный логин или количество символов больше 20");
        }
        return matcher.matches();
    }

    private static boolean checkPassword(String string) throws WrongPasswordException {
        String valid = "^[a-z0-9_-]{3,19}$";
        Pattern pattern = Pattern.compile(valid, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new WrongPasswordException("Содержатся недопустимые символы или количество символов больше 20");
        }
        return matcher.matches();
    }

    private static boolean getCheckPasswords(String n, String m) throws WrongPasswordException {
        if (!n.equals(m)) {
            throw new WrongPasswordException("Пароли не совпадают, попробуйте снова");
        }
        return n.equals(m);
    }

    public static void getAuthorization(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password);
            getCheckPasswords(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
       }finally {
            System.out.println("Работа метода getAuthorization завершена");
        }
    }
}
//                                     ====Альтернативное решение====
//    public static void getAuthorisation(String login, String password, String confirmPassword) {
//        if (checkLogin(login)) {
//            throw new WrongLoginException("Вы ввели неверный логин или количество символов больше 20");
//        }
//        if (checkPassword(password)) {
//            throw new WrongPasswordException("Содержатся недопустимые символы или количество символов больше 20");
//        } else if (!getCheckPasswords(password, confirmPassword)) {
//            throw new WrongPasswordException("Пароли не совпадают, попробуйте снова");
//        }
//    }