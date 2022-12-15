public class Entity {
    private int posX, posY;
    public int getPosX() {
        return this.posX;
    }
    public int getPosY() {
        return this.posY;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void moveLeft() {
        if (posX > -60 && posX <= 150) {
            posX -= Settings.ENTITY_SPEED;
        }
    }
    public void moveRight() {
        if (posX >= -60 && posX < 150) {
            posX += Settings.ENTITY_SPEED;
        }
    }
    public Entity(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
}
