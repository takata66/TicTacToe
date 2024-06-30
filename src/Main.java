public class Main {
    public static void main(String[] args) {
        char[][] gameZone = new char[3][3];
        boolean win = false;
        boolean draw = false;
        Players player1 = new Players(1);
        Players player2 = new Players(2);

        Game game = new Game();

        game.initializePlayer(player1, 1, -1);  // Первый игрок выбирает команду без предыдущей команды
        game.initializePlayer(player2, 2, player1.getCommand());  // Второй игрок получает команду на основе первого

        game.initializeZone(gameZone);
        Players currentPlayer = player1;

        while (!win && !draw) {
            game.takeStep(gameZone, currentPlayer);
            win = game.checkWinner(gameZone);
            draw = game.checkDraw(gameZone);

            // Переключаем текущего игрока
            if (!win && !draw) {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }

        if (win) {
            System.out.println("Победитель: " + currentPlayer.getName());
        } else if (draw) {
            System.out.println("Игра закончилась ничьей.");
        }
    }
}
