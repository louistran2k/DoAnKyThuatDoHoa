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
public class Oto {
    private ArrayList<Point> listPoint;
    private int banKinhbanh;

    public int getBanKinhbanh() {
        return banKinhbanh;
    }

    public void setBanKinhbanh(int banKinhbanh) {
        this.banKinhbanh = banKinhbanh;
    }
    
    public ArrayList<Point> getListPoint() {
        return listPoint;
    }

    public void setListPoint(ArrayList<Point> listPoint) {
        this.listPoint = listPoint;
    }
    
    
    public Oto() {
        listPoint = new ArrayList<>();
        banKinhbanh = 5;
        listPoint.add(new Point(20,30));
        listPoint.add(new Point(30,30));
        listPoint.add(new Point(40,30));
        
        listPoint.add(new Point(0,20));
        listPoint.add(new Point(10,20));
        listPoint.add(new Point(20,20));
        listPoint.add(new Point(30,20));
        listPoint.add(new Point(40,20));
        listPoint.add(new Point(50,20));
        listPoint.add(new Point(60,20));
        
        listPoint.add(new Point(0,10));
        listPoint.add(new Point(10,10));
        listPoint.add(new Point(15,8));
        listPoint.add(new Point(20,10));
        listPoint.add(new Point(40,10));
        listPoint.add(new Point(45,8));
        listPoint.add(new Point(50,10));
        listPoint.add(new Point(60,10));
        
        listPoint.add(new Point(12,5));
        listPoint.add(new Point(15,11));
        listPoint.add(new Point(18,5));
      
        listPoint.add(new Point(42,5));
        listPoint.add(new Point(45,11));
        listPoint.add(new Point(48,5));

    }
    public void ve(Graphics g,Color c){
        //Color c =Color.BLACK;
        CoBan.linePoint(g, listPoint.get(0), listPoint.get(2),c);
        CoBan.linePoint(g, listPoint.get(3), listPoint.get(9),c);
        CoBan.linePoint(g, listPoint.get(10), listPoint.get(11),c);
        CoBan.linePoint(g, listPoint.get(13), listPoint.get(14),c);
        CoBan.linePoint(g, listPoint.get(16), listPoint.get(17),c);

        CoBan.linePoint(g, listPoint.get(0), listPoint.get(4),c);
        CoBan.linePoint(g, listPoint.get(0), listPoint.get(5),c);
        CoBan.linePoint(g, listPoint.get(1), listPoint.get(6),c);
        CoBan.linePoint(g, listPoint.get(2), listPoint.get(7),c);
        CoBan.linePoint(g, listPoint.get(2), listPoint.get(8),c);

        CoBan.linePoint(g, listPoint.get(3), listPoint.get(10),c);
        CoBan.linePoint(g, listPoint.get(9), listPoint.get(17),c);

        CoBan.putPixel(g, (int)listPoint.get(12).getX(),(int) listPoint.get(12).getY(),c);
        CoBan.veHinhTronPoint(g, listPoint.get(12), banKinhbanh,c);
        CoBan.putPixel(g, (int)listPoint.get(15).getX(),(int) listPoint.get(15).getY(),c);
        CoBan.veHinhTronPoint(g, listPoint.get(15), banKinhbanh,c);

        CoBan.linePointThieuCham(g, listPoint.get(12), listPoint.get(18),c);
        CoBan.linePointThieuCham(g, listPoint.get(12), listPoint.get(19),c);
        CoBan.linePointThieuCham(g, listPoint.get(12), listPoint.get(20),c);

        CoBan.linePointThieuCham(g, listPoint.get(15), listPoint.get(21),c);
        CoBan.linePointThieuCham(g, listPoint.get(15), listPoint.get(22),c);
        CoBan.linePointThieuCham(g, listPoint.get(15), listPoint.get(23),c);
        
        
    }
    public void tinhTienXe(int x,int y){
        for(int i=0;i<listPoint.size();i++){
            Point p = listPoint.get(i);
            listPoint.set(i, CoBan.tinhTien(p,x,y));
        }
    }
    public void quayBanh(){
        for(int i=18;i<21;i++){
            Point p = listPoint.get(i);
            listPoint.set(i, CoBan.phepQuay(p, listPoint.get(12), 45));
        }
        for(int i=21;i<listPoint.size();i++){
            Point p = listPoint.get(i);
            listPoint.set(i, CoBan.phepQuay(p, listPoint.get(15), 45));
        }
    }
    public void doiXung(String truc){
        for(int i=0;i<listPoint.size();i++){
            Point p = listPoint.get(i);
            listPoint.set(i, CoBan.doiXung(p, truc));
        }
    }
    public void thuPhong(double x){
        for(int i=0;i<listPoint.size();i++){
            Point p = listPoint.get(i);
            listPoint.set(i, CoBan.thuPhongDiem(p, x));
        }
        banKinhbanh = CoBan.thuPhongSize(banKinhbanh, x);
    }
    public void quayXe(double goc){
        Point tam = new Point(0,0);
        for(int i=0; i<listPoint.size();i++){
            Point p = listPoint.get(i);
            listPoint.set(i, CoBan.phepQuay(p,tam, goc));
        }
    }
}
