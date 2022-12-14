package org.battleship;

public class Battleship {
    public static void main(String[] args) {

        Game game = new Game();
        game.playGame();

//        Display monitor = new Display();
//        Board board1 = new Board();
//        Input reader = new Input();
//
//        Player player1 = new Player(1);
//
//        Ship podwodna = new Ship(ShipType.SUBMARINE);
//        Ship kuter = new Ship(ShipType.CRUISER);
//
////        player1.addToPlayerShipList(podwodna, kuter);
//
//
//
//        List<Square> cords = new ArrayList<>();
//        cords.add(new Square(1, 6, SquareStatus.SHIP));
//        cords.add(new Square(1, 7, SquareStatus.SHIP));
//        kuter.setCoordsOfShip(cords);
//        board1.addShipToBoard(kuter);
//        Square test = new Square(1,8, SquareStatus.SHIP);
//        System.out.println(board1.areFieldsAroundEmpty(test));
//        kuter.setCoordsOfShip(cords);
//
//        board1.addShipToBoard(kuter);
//
//        monitor.displayBoard(board1);
    }
}