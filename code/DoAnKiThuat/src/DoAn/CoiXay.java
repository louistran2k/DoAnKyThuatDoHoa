/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
/**
 *
 * @author rangc
 */
public class CoiXay {
    private ArrayList<Point> tru;
    private ArrayList<Point> canh;
    public CoiXay(){
        tru = new ArrayList<>();
        tru.add(new Point(35,30));
        tru.add(new Point(30,30));
        tru.add(new Point(40,30));
        tru.add(new Point(30,25));
        tru.add(new Point(40,25));
        tru.add(new Point(30,0));
        tru.add(new Point(40,0)); 
        
        tru.add(new Point(35,33));
        
        canh = new ArrayList<>();
        canh.add(new Point(35,33));
        
        canh.add(new Point(35,48));
        canh.add(new Point(40,48));
        canh.add(new Point(40,38));
        canh.add(new Point(35,38));
        
        canh.add(new Point(50,33));
        canh.add(new Point(50,28));
        canh.add(new Point(40,28));
        canh.add(new Point(40,33));
        
        canh.add(new Point(30,38));
        canh.add(new Point(20,38));
        canh.add(new Point(20,33));
        canh.add(new Point(30,33));
        
        canh.add(new Point(30,28));
        canh.add(new Point(35,28));
        canh.add(new Point(30,18));
        canh.add(new Point(35,18));
    }

    public ArrayList<Point> getTru() {
        return tru;
    }

    public void setTru(ArrayList<Point> tru) {
        this.tru = tru;
    }

    public ArrayList<Point> getCanh() {
        return canh;
    }

    public void setCanh(ArrayList<Point> canh) {
        this.canh = canh;
    }

    public void veTru(Graphics g){
        Color c = Color.BLACK;
        CoBan.linePoint(g,tru.get(1),tru.get(2),c);
        CoBan.linePoint(g,tru.get(1),tru.get(3),c);
        CoBan.linePoint(g,tru.get(2),tru.get(4),c);
        CoBan.linePoint(g,tru.get(3),tru.get(4),c);
        CoBan.linePoint(g,tru.get(3),tru.get(5),c);
        CoBan.linePoint(g,tru.get(4),tru.get(6),c);
        CoBan.linePoint(g,tru.get(5),tru.get(6),c);
        CoBan.veNuaHinhTron(g, (int)tru.get(0).getX(), (int)tru.get(0).getY(), 5, c);
        CoBan.putPixelPoint(g, tru.get(7), c);
//        g.setColor(Color.PINK);
//        //g.fillOval(30*5+400-2+5, 325-30*5-2+5, 30, 20);
//        Point p = CoBan.chuyenVeToaDoMay(tru.get(1));
//        Point p2 = CoBan.chuyenVeToaDoMay(tru.get(3));
//        g.fillRect((int)p.getX()+5,(int) p.getY()+5, 45, 20);
//        g.fillRect((int)p2.getX()+5,(int) p2.getY()+5, 45, 120);
    }
    public void veCanh(Graphics g){
        Color c = Color.RED;
        CoBan.linePoint(g,canh.get(1),canh.get(16),c);
        CoBan.linePoint(g,canh.get(5),canh.get(11),c);
        CoBan.linePoint(g,canh.get(2),canh.get(3),c);
        CoBan.linePoint(g,canh.get(6),canh.get(7),c);
        CoBan.linePoint(g,canh.get(13),canh.get(15),c);
        CoBan.linePoint(g,canh.get(9),canh.get(10),c);
        CoBan.linePoint(g,canh.get(1),canh.get(2),c);
        CoBan.linePoint(g,canh.get(3),canh.get(4),c);
        CoBan.linePoint(g,canh.get(5),canh.get(6),c);
        CoBan.linePoint(g,canh.get(7),canh.get(8),c);
        CoBan.linePoint(g,canh.get(13),canh.get(14),c);
        CoBan.linePoint(g,canh.get(15),canh.get(16),c);
        CoBan.linePoint(g,canh.get(9),canh.get(12),c);
        CoBan.linePoint(g,canh.get(10),canh.get(11),c);
    }
    public void quayCanh(){
        for(int i=1;i<canh.size();i++){
            Point p = canh.get(i);
            canh.set(i, CoBan.phepQuay(p,canh.get(0),45));
        }
    }
    public void doiXung(String truc){
        for(int i=0;i<tru.size();i++){
            Point p = tru.get(i);
            tru.set(i, CoBan.doiXung(p, truc));
        }
        for(int i=0;i<canh.size();i++){
            Point p = canh.get(i);
            canh.set(i, CoBan.doiXung(p, truc));
        }
    }
}
