public class Maps {

    static Tile[][] chosenMap;
    static Tile[][] chosenMapBoxes;

    static int[][] map1Data = {{0,0,1,1,1,1,1,0},
                               {1,1,1,0,0,0,1,0},
                               {1,3,2,0,0,0,1,0},
                               {1,1,1,0,0,3,1,0},
                               {1,3,1,1,0,0,1,0},
                               {1,0,1,0,3,0,1,1},
                               {1,0,0,3,0,0,3,1},
                               {1,0,0,0,3,0,0,1},
                               {1,1,1,1,1,1,1,1}};

    static int[][] map1Boxes = {{5,5,5,5,5,5,5,5},
                                {5,5,5,5,5,5,5,5},
                                {5,5,5,4,5,5,5,5},
                                {5,5,5,5,4,5,5,5},
                                {5,5,5,5,4,5,5,5},
                                {5,5,5,5,5,5,5,5},
                                {5,4,5,4,4,4,5,5},
                                {5,5,5,5,5,5,5,5},
                                {5,5,5,5,5,5,5,5}};
    static boolean playerPlaced = false;
    static boolean boxesPlaced = false;

    static void setMap(int map){
        if(map == 1){
            chosenMap = new Tile[9][8];
            chosenMapBoxes = new Tile[9][8];

            for(int y = 0; y < chosenMap.length; y++){
                for(int x = 0; x < chosenMap[y].length; x++){
                    chosenMap[y][x] = new Tile(map1Data[y][x]);
                    chosenMapBoxes[y][x] = new Tile(map1Boxes[y][x]);
                }
            }
            return;
        }
    }

    static void render(){
        if(!playerPlaced){
            for(int y = 0; y < chosenMap.length; y++){
                for(int x = 0; x < chosenMap[y].length; x++){
                    Tile current = chosenMap[y][x];

                    if(current.type.equals("player")){
                        Player.playerX = x;
                        Player.playerY = y;

                        current.type = "void";

                        playerPlaced = true;
                        break;
                    }
                }
            }
        }

        int plrX = Player.playerX;
        int plrY = Player.playerY;

        for(int y = 0; y < chosenMap.length; y++){
            for(int x = 0; x < chosenMap[y].length; x++){
                Tile current = chosenMap[y][x];

                if(plrX == x && plrY == y){
                    System.out.print(Tile.emojis[2]);
                    continue;
                }
                if(chosenMapBoxes[y][x].type.equals("box")){
                    System.out.print(Tile.emojis[4]);
                    continue;
                }
                else{
                    switch(current.type){
                        case "void" -> System.out.print(Tile.emojis[0]);
                        case "wall" -> System.out.print(Tile.emojis[1]);
                        case "mark" -> System.out.print(Tile.emojis[3]);
                    }
                }
            }
            System.out.println();
        }
    }
}
