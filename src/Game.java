import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);

    public Boolean checkFields(char[][] a, int i, int j) {
        return a[i][j] == '-';
    }

    public void getAllFields(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void initializeZone(char[][] gameZone) {
        for (int i = 0; i < gameZone.length; i++) {
            for (int j = 0; j < gameZone[i].length; j++) {
                gameZone[i][j] = '-';
            }
        }
    }

    public int takeXfield() {
        System.out.print("Введите номер строки: ");
        return sc.nextInt() - 1;
    }

    public int takeYfield() {
        System.out.print("Введите номер столбца: ");
        return sc.nextInt() - 1;
    }

    public void initializePlayer(Players p, int id, int previousCommand) {
        p.setName(id);
        p.setCommand(id, previousCommand);
    }

    public void takeStep(char[][] a, Players p) {
        char command = (p.getCommand() == 1) ? 'X' : 'O';
        getAllFields(a);
        System.out.println("Игрок " + p.getName() + " Ваш ход. Выберите поле в которое хотите сделать ход");

        int x = takeXfield();
        int y = takeYfield();

        while (!checkFields(a, x, y)) {
            System.out.println("Поле занято. Займите другое");
            x = takeXfield();
            y = takeYfield();
        }

        a[x][y] = command;
    }

    public boolean checkWinner(char[][] a) {
        // Проверка строк и столбцов
        for (int i = 0; i < 3; i++) {
            if (a[i][0] == a[i][1] && a[i][1] == a[i][2] && a[i][0] != '-') {
                return true;
            }
            if (a[0][i] == a[1][i] && a[1][i] == a[2][i] && a[0][i] != '-') {
                return true;
            }
        }
        // Проверка диагоналей
        if (a[0][0] == a[1][1] && a[1][1] == a[2][2] && a[0][0] != '-') {
            return true;
        }
        if (a[0][2] == a[1][1] && a[1][1] == a[2][0] && a[0][2] != '-') {
            return true;
        }
        return false;
    }

    public boolean checkDraw(char[][] a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == '-') {
                    return false; // Если есть хотя бы одно пустое поле, это не ничья
                }
            }
        }
        return true; // Все поля заполнены
    }
}
