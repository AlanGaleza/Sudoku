import services.UserService;

public class SudokuRunner {
    public static void main(String args[]) {
        boolean isGameFinished = false;
        UserService userService = new UserService();

        while(!isGameFinished) {
            if(!userService.introducer()) {
                isGameFinished = true;
            }
        }
    }
}
