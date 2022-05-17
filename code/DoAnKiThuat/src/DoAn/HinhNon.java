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
public class HinhNon {
    private Point3D tam;
    private int banKinh;
    private int chieuCao;

    public HinhNon() {
    }

    public HinhNon(Point3D tam, int banKinh, int chieuCao) {
        this.tam = tam;
        this.banKinh = banKinh;
        this.chieuCao = chieuCao;
    }
    public HinhNon(int x,int y,int z, int banKinh, int chieuCao) {
        this.tam = new Point3D(x,y,z);
        this.banKinh = banKinh;
        this.chieuCao = chieuCao;
    }
    public Point3D getTam() {
        return tam;
    }

    public void setTam(Point3D tam) {
        this.tam = tam;
    }

    public int getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(int banKinh) {
        this.banKinh = banKinh;
    }

    public int getDuongCao() {
        return chieuCao;
    }

    public void setDuongCao(int chieuCao) {
        this.chieuCao = chieuCao;
    }
    
    public Point3D getDinh(){
        return new Point3D(tam.getX(),tam.getY(),tam.getZ()+chieuCao) ;
    }
    public Point3D getA1(){
        return new Point3D(tam.getX()-banKinh,tam.getY(),tam.getZ()) ;
    }
    public Point3D getB1(){
        return new Point3D(tam.getX()+banKinh,tam.getY(),tam.getZ()) ;
    }
    public void ve(Graphics g){
        Point3D dinh3D = new Point3D(tam.getX(),tam.getY(),tam.getZ()+chieuCao) ;
        Point3D a13D = new Point3D(tam.getX()-banKinh,tam.getY(),tam.getZ()) ;
        Point3D b13D = new Point3D(tam.getX()+banKinh,tam.getY(),tam.getZ()) ;
        
        Point tam2D = tam.to2D();
        Point dinh2D = dinh3D.to2D();
        Point a12D = a13D.to2D();
        Point b12D = b13D.to2D();
        CoBan.veHinhEclip(g,tam2D , banKinh, (int) (banKinh*Math.sqrt(2)/2), Color.red);
        CoBan.linePoint(g, dinh2D, a12D, Color.red);
        CoBan.linePoint(g, dinh2D, b12D, Color.red);
       // CoBan.lineDashPoint(g, tam2D, dinh2D, Color.red);
    }    
}
