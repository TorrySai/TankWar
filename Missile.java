package tongzhao;

import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Rectangle;  

/**
 * @author Tongzhao Sai
 *
 *
 */
public class Missile {  
	  
    private int xPos = 0;  
    private int yPos = 0;  
    private int BulletSize = 7;  
    private Color color = Color.BLACK;  
    private int speedInX = 15;  
    private int speedInY = 15;  
    private Tank.Direction dir = Tank.Direction.STOP;  
    private TankClient tankClient = null;  
    private Tank tank = null;  
    private int attackDamage = 10;  
    private int bigAttackHurt = 100;  
      
    public Missile(int x, int y, Tank.Direction dir, Tank t, TankClient tc) {  
        this.xPos = x - BulletSize / 2;  
        this.yPos = y - BulletSize / 2;  
        this.dir = dir;  
        this.tankClient = tc;  
        this.tank = t;  
    }  
   
    public Missile(int x, int y, Tank.Direction dir, Tank t, TankClient tc,  
            int BulletSize) {  
        this.BulletSize = BulletSize;  
        this.xPos = x - BulletSize / 2;  
        this.yPos = y - BulletSize / 2;  
        this.dir = dir;  
        this.tankClient = tc;  
        this.tank = t;  
        this.attackDamage = bigAttackHurt;  
    }  
      
    public void draw(Graphics g) {  
        Color orgColor = g.getColor();  
        g.setColor(color);  
        g.fillOval(xPos, yPos, BulletSize, BulletSize);  
        g.setColor(orgColor);  
        move();  
    }  
      
    private void move() {  
        switch (dir) {  
        case U:  
            yPos -= speedInY;  
            break;  
        case D:  
            yPos += speedInY;  
            break;  
        case L:  
            xPos -= speedInX;  
            break;  
        case R:  
            xPos += speedInX;  
            break;  
        case LU:  
            xPos -= speedInX;  
            yPos -= speedInY;  
            break;  
        case RU:  
            xPos += speedInX;  
            yPos -= speedInY;  
            break;  
        case LD:  
            xPos -= speedInX;  
            yPos += speedInY;  
            break;  
        case RD:  
            xPos += speedInX;  
            yPos += speedInY;  
            break;  
        }  
        if (xPos + BulletSize / 2 < 0 || yPos + BulletSize / 2 < 0  
                || xPos + BulletSize / 2 > TankClient.GAME_WIDTH  
                || yPos + BulletSize / 2 > TankClient.GAME_HEIGHT)  
            tankClient.getMissiles().remove(this);  
    }  
    
    public boolean hitTank(Tank t) {  
        if (this.getRect().intersects(t.getRect())) {  
            if ((this.tank.isGood() && !t.isGood())  
                    || (!this.tank.isGood() && t.isGood()))  
                return true;  
        }  
        return false;  
    }  
       
    public boolean hitWall(Wall w) {  
        return this.getRect().intersects(w.getRect());  
    }  
      
    public Rectangle getRect() {  
        return new Rectangle(xPos, yPos, BulletSize, BulletSize);  
    }  
  
    public int getX() {  
        return xPos;  
    }  
  
    public void setX(int x) {  
        this.xPos = x;  
    }  
  
    public int getY() {  
        return yPos;  
    }  
  
    public void setY(int y) {  
        this.yPos = y;  
    }  
  
    public int getBulletSize() {  
        return BulletSize;  
    }  
  
    public void setBulletSize(int BulletSize) {  
        this.BulletSize = BulletSize;  
    }  
  
    public Color getColor() {  
        return color;  
    }  
  
    public void setColor(Color color) {  
        this.color = color;  
    }  
  
    public int getxSpeed() {  
        return speedInX;  
    }  
  
    public void setxSpeed(int xSpeed) {  
        this.speedInX = xSpeed;  
    }  
  
    public int getySpeed() {  
        return speedInY;  
    }  
  
    public void setySpeed(int ySpeed) {  
        this.speedInY = ySpeed;  
    }  
  
    public Tank.Direction getDir() {  
        return dir;  
    }  
  
    public void setDir(Tank.Direction dir) {  
        this.dir = dir;  
    }  
  
    public TankClient getTc() {  
        return tankClient;  
    }  
  
    public void setTc(TankClient tc) {  
        this.tankClient = tc;  
    }  
  
    public Tank getT() {  
        return tank;  
    }  
  
    public void setT(Tank t) {  
        this.tank = t;  
    }  
  
    public int getAttackHurt() {  
        return attackDamage;  
    }  
  
    public void setAttackHurt(int attackHurt) {  
        this.attackDamage = attackHurt;  
    }  
  
}  