public class Tile {

    String type;
    boolean canCollide;

    static String[] emojis = {"⬛", "🧱", "👨", "⭕", "📦"};

    public Tile(int data){
        if(data == 0){
            type = "void";
            canCollide = false;
        }
        if(data == 1){
            type = "wall";
            canCollide = true;
        }
        if(data == 2){
            type = "player";
            canCollide = false;
        }
        if(data == 3){
            type = "mark";
            canCollide = false;
        }
        if(data == 4){
            type = "box";
            canCollide = false;
        }
        if(data == 5){
            type = "null";
            canCollide = false;
        }
    }
}
