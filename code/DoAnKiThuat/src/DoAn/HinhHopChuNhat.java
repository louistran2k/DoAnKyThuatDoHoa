/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author rangc
 */
public class HinhHopChuNhat {
    private Point3D tam;
    private int rong;
    private int dai;
    private int cao;

    public HinhHopChuNhat() {
    }

    public HinhHopChuNhat(Point3D tam, int rong, int dai, int cao) {
        this.tam = tam;
        this.rong = rong;
        this.dai = dai;
        this.cao = cao;
    }
    public HinhHopChuNhat(int x,int y,int z, int rong, int dai, int cao) {
        this.tam = new Point3D(x,y,z);
        this.rong = rong;
        this.dai = dai;
        this.cao = cao;
    }

    public Point3D getTam() {
        return tam;
    }

    public void setTam(Point3D tam) {
        this.tam = tam;
    }

    public int getRong() {
        return rong;
    }

    public void setRong(int rong) {
        this.rong = rong;
    }

    public int getDai() {
        return dai;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public int getCao() {
        return cao;
    }

    public void setCao(int cao) {
        this.cao = cao;
    }
    public Point3D getA(){
        return tam;
    }
    public Point3D getB(){
        return new Point3D(tam.getX(),tam.getY()+rong,tam.getZ());
    }
    public Point3D getC(){
        return new Point3D(tam.getX()+dai,tam.getY()+rong,tam.getZ());
    }
    public Point3D getD(){
        return new Point3D(tam.getX()+dai,tam.getY(),tam.getZ());
    }
    public Point3D getA1(){
        return new Point3D(tam.getX(),tam.getY(),tam.getZ()+cao);
    }
    public Point3D getB1(){
        return new Point3D(tam.getX(),tam.getY()+rong,tam.getZ()+cao);
    }
    public Point3D getC1(){
        return new Point3D(tam.getX()+dai,tam.getY()+rong,tam.getZ()+cao);
    }
    public Point3D getD1(){
        return new Point3D(tam.getX()+dai,tam.getY(),tam.getZ()+cao);
    }
    
    public void ve(Graphics g){
        Point3D dinhB3D = new Point3D(tam.getX(),tam.getY()+rong,tam.getZ());
        Point3D dinhD3D = new Point3D(tam.getX()+dai,tam.getY(),tam.getZ());
        Point3D dinhC3D = new Point3D(tam.getX()+dai,tam.getY()+rong,tam.getZ());
        
        Point3D dinh1A3D = new Point3D(tam.getX(),tam.getY(),tam.getZ()+cao);
        Point3D dinh1B3D = new Point3D(tam.getX(),tam.getY()+rong,tam.getZ()+cao);
        Point3D dinh1D3D = new Point3D(tam.getX()+dai,tam.getY(),tam.getZ()+cao);
        Point3D dinh1C3D = new Point3D(tam.getX()+dai,tam.getY()+rong,tam.getZ()+cao);
        
        Point dinhA2D = tam.to2D();
        Point dinhB2D = dinhB3D.to2D();
        Point dinhC2D = dinhC3D.to2D();
        Point dinhD2D = dinhD3D.to2D();
        
        Point dinh1A2D = dinh1A3D.to2D();
        Point dinh1B2D = dinh1B3D.to2D();
        Point dinh1C2D = dinh1C3D.to2D();
        Point dinh1D2D = dinh1D3D.to2D();
        
        CoBan.linePoint(g, dinhB2D, dinhC2D, Color.red);
        CoBan.linePoint(g, dinhC2D, dinhD2D, Color.red);
        CoBan.linePoint(g, dinhB2D, dinh1B2D, Color.red);
        CoBan.linePoint(g, dinhC2D, dinh1C2D, Color.red);
        CoBan.linePoint(g, dinhD2D, dinh1D2D, Color.red);
        
        CoBan.linePoint(g, dinh1B2D, dinh1C2D, Color.red);
        CoBan.linePoint(g, dinh1B2D, dinh1A2D, Color.red);
        CoBan.linePoint(g, dinh1C2D, dinh1D2D, Color.red);
        CoBan.linePoint(g, dinh1A2D, dinh1D2D, Color.red);
        
        CoBan.lineDashPoint(g, dinhA2D, dinhB2D, Color.red);
        CoBan.lineDashPoint(g, dinhA2D, dinhD2D, Color.red);
        CoBan.lineDashPoint(g, dinhA2D, dinh1A2D, Color.red);
        
        Point A = CoBan.chuyenVeToaDoMay(dinhA2D);
        Point B = CoBan.chuyenVeToaDoMay(dinhB2D);
        Point C = CoBan.chuyenVeToaDoMay(dinhC2D);
        Point D = CoBan.chuyenVeToaDoMay(dinhD2D);
        Point E = CoBan.chuyenVeToaDoMay(dinh1A2D);
        Point F = CoBan.chuyenVeToaDoMay(dinh1B2D);
        Point G = CoBan.chuyenVeToaDoMay(dinh1C2D);
        Point H = CoBan.chuyenVeToaDoMay(dinh1D2D);
        
        g.drawString("A", (int)A.getX()+15,(int) A.getY()+15);
        g.drawString("B", (int)B.getX()+15,(int) B.getY()+15);
        g.drawString("C", (int)C.getX()+15,(int) C.getY()+15);
        g.drawString("D", (int)D.getX()+15,(int) D.getY()+15);
        g.drawString("E", (int)E.getX()+15,(int) E.getY()+15);
        g.drawString("F", (int)F.getX()+15,(int) F.getY()+15);
        g.drawString("G", (int)G.getX()+15,(int) G.getY()+15);
        g.drawString("H", (int)H.getX()+15,(int) H.getY()+15);
        
        
    }
}
