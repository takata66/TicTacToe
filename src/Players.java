import java.util.Scanner;

public class Players {
    private String name;
    private int command;
    private int id;
    Scanner sc = new Scanner(System.in);

    public Players(int id) {
        this.id = id;
    }

    public void setName(int id) {
        System.out.print("Игрок " + id + " , введите ваше имя: ");
        name = sc.nextLine();
    }

    public void setCommand(int id, int previousCommand) {
        if (id == 1) {
            System.out.print("Игрок " + id + " , выберите комманду Крестики(1), Нолики(0): ");
            command = sc.nextInt();
        } else {
            command = (previousCommand == 1) ? 0 : 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getCommand() {
        return command;
    }

    public String toString() {
        return "Игрок " + id + " Имя: " + name + " Команда: " + command;
    }
}
