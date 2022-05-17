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
public class HinhCau {
    private Point3D tam;
    private int bankinh;

    public HinhCau() {
    }

    public HinhCau(Point3D tam, int bankinh) {
        this.tam = tam;
        this.bankinh = bankinh;
    }
    public HinhCau(int x,int y,int z, int bankinh) {
        this.tam = new Point3D(x,y,z);
        this.bankinh = bankinh;
    }

    public Point3D getTam() {
        return tam;
    }

    public void setTam(Point3D tam) {
        this.tam = tam;
    }

    public int getBankinh() {
        return bankinh;
    }

    public void setBankinh(int bankinh) {
        this.bankinh = bankinh;
    }
    public void ve(Graphics g){
        Point tam2D = tam.to2D();
        CoBan.veHinhTronPoint(g, tam2D, bankinh, Color.red);
        CoBan.veHinhEclip(g, tam2D, bankinh, (int) (bankinh*Math.sqrt(2)/2), Color.red);
    }
}
