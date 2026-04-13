public class Player {

    static int playerX;
    static int playerY;

    static void move(String direction){
        switch(direction){
            case "W" -> {
                if(Maps.chosenMap[playerY-1][playerX].type.equals("wall")){
                    return;
                }
                else if(Maps.chosenMapBoxes[playerY-1][playerX].type.equals("box")){
                    if(!Maps.chosenMapBoxes[playerY-2][playerX].type.equals("box")){
                        if(!Maps.chosenMap[playerY-2][playerX].type.equals("wall")){
                            Maps.chosenMapBoxes[playerY-1][playerX].type = "null";
                            Maps.chosenMapBoxes[playerY-2][playerX].type = "box";
                            playerY--;
                        }
                        else{
                            return;
                        }
                    }
                }
                else{
                    playerY--;
                }
            }
            case "S" -> {
                if(Maps.chosenMap[playerY+1][playerX].type.equals("wall")){
                    return;
                }
                else if(Maps.chosenMapBoxes[playerY+1][playerX].type.equals("box")){
                    if(!Maps.chosenMapBoxes[playerY+2][playerX].type.equals("box")){
                        if(!Maps.chosenMap[playerY+2][playerX].type.equals("wall")){
                            Maps.chosenMapBoxes[playerY+1][playerX].type = "null";
                            Maps.chosenMapBoxes[playerY+2][playerX].type = "box";
                            playerY++;
                        }
                        else{
                            return;
                        }
                    }
                }
                else{
                    playerY++;
                }
            }
            case "A" -> {
                if(Maps.chosenMap[playerY][playerX-1].type.equals("wall")){
                    return;
                }
                else if(Maps.chosenMapBoxes[playerY][playerX-1].type.equals("box")){
                    if(!Maps.chosenMapBoxes[playerY][playerX-2].type.equals("box")){
                        if(!Maps.chosenMap[playerY][playerX-2].type.equals("wall")){
                            Maps.chosenMapBoxes[playerY][playerX-1].type = "null";
                            Maps.chosenMapBoxes[playerY][playerX-2].type = "box";
                            playerX--;
                        }
                        else{
                            return;
                        }
                    }
                }
                else{
                    playerX--;
                }
            }
            case "D" -> {
                if(Maps.chosenMap[playerY][playerX+1].type.equals("wall")){
                    return;
                }
                else if(Maps.chosenMapBoxes[playerY][playerX+1].type.equals("box")){
                    if(!Maps.chosenMapBoxes[playerY][playerX+2].type.equals("box")){
                        if(!Maps.chosenMap[playerY][playerX+2].type.equals("wall")){
                            Maps.chosenMapBoxes[playerY][playerX+1].type = "null";
                            Maps.chosenMapBoxes[playerY][playerX+2].type = "box";
                            playerX++;
                        }
                        else{
                            return;
                        }
                    }
                }
                else{
                    playerX++;
                }
            }
            case "RESTART" -> {
                Maps.playerPlaced = false;
                Maps.setMap(Main.map);
            }
            case "QUIT" -> {
                System.exit(0);
            }
        }
    }
}
