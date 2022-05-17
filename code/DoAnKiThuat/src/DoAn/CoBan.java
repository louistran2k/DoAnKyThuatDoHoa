/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.ArrayList;

/**
 *
 * @author rangc
 */
public class CoBan {

    static final int Width = 800;
    static final int Height = 650;
    static final int centerX = Width / 2;
    static final int centerY = Height / 2;
    static final int pixelSize = 5;
    static final int sizeUnit = 5;
    static final int spacing = 5;

    public static void drawCoordinateSys(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.lightGray);
        for (int i = 0; i <= Width + 25; i += spacing) {
            g2D.drawLine(i, 0, i, Height);
        }
        for (int i = 0; i <= Height + 25; i += spacing) {
            g2D.drawLine(0, i, Width, i);
        }
        g2D.setColor(Color.red);
        g2D.drawLine(0, centerY, Width, centerY);
        g2D.drawLine(centerX, 0, centerX, Height);
        g.drawLine(Width, centerY, Width-10, centerY-5);
        g.drawLine(Width, centerY, Width-10, centerY+5);
        g.drawString("x", Width-10, centerY+20);
        
        g.drawLine(centerX, 0, centerX-5, 10);
        g.drawLine(centerX, 0, centerX+5, 10);
        g.drawString("y", centerX+10, 10);

    }

    public static void drawCoordinateSys3D(Graphics g) {
        g.setColor(Color.lightGray);
        for(int i=0 ; i<=Width ; i+=spacing) {
            g.drawLine(i, 0, i, Height);
        }
        for(int i=0 ; i<=Height ; i+=spacing) {
            g.drawLine(0, i, Width, i);
        }   
        
        g.setColor(Color.red);
        g.drawLine(centerX, centerY, Width, centerY);
        g.drawLine(Width, centerY, Width-10, centerY-5);
        g.drawLine(Width, centerY, Width-10, centerY+5);
        g.drawString("x", Width-10, centerY+20);
        
        g.drawLine(centerX, centerY, centerX, 0);
        g.drawLine(centerX, 0, centerX-5, 10);
        g.drawLine(centerX, 0, centerX+5, 10);
        g.drawString("z", centerX+10, 10);
        
        int a = centerX - centerY;
        g.drawLine(centerX, centerY, a, Height);
        g.drawLine(3+a, Height-10, a, Height);
        g.drawLine(10+a, Height-2, a, Height);
        g.drawString("y", a + 20, Height);
    }

    public static void putPixel(Graphics g, int x, int y, Color c) {
        int realX = 0, realY = 0;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(c);
        realX = x * 5;
        realY = y * 5;
        g2D.fillRect(centerX + realX - 2, centerY - realY - 2, pixelSize, pixelSize);
    }

    public static void putPixelPoint(Graphics g, Point p, Color c) {
        int realX = 0, realY = 0;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(c);
        realX = (int) p.getX() * 5;
        realY = (int) p.getY() * 5;
        g2D.fillRect(centerX + realX - 2, centerY - realY - 2, pixelSize, pixelSize);
    }

    public static void put8Pixel(Graphics g, int xc, int yc, int x, int y, Color c) {
        putPixel(g, x + xc, y + yc, c);
        putPixel(g, x + xc, -y + yc, c);
        putPixel(g, -x + xc, y + yc, c);
        putPixel(g, -x + xc, -y + yc, c);
        putPixel(g, y + xc, x + yc, c);
        putPixel(g, y + xc, -x + yc, c);
        putPixel(g, -y + xc, x + yc, c);
        putPixel(g, -y + xc, -x + yc, c);
    }

    public static void put4Pixel(Graphics g, int xc, int yc, int x, int y, Color c) {
        putPixel(g, x + xc, y + yc, c);
        //    putPixel(g, x + xc, -y + yc,c);
        putPixel(g, -x + xc, y + yc, c);
        //   putPixel(g, -x + xc, -y + yc,c);
        putPixel(g, y + xc, x + yc, c);
        // putPixel(g, y + xc, -x + yc,c);
        putPixel(g, -y + xc, x + yc, c);
        // putPixel(g, -y + xc, -x + yc,c);
    }

    public static void put4PixelEclipNua(Graphics g, int xc, int yc, int x, int y, Color c,int count) {
        if(count%2==0){
            putPixel(g, xc + x, yc + y, c);
            putPixel(g, xc - x, yc + y, c);
        }
        
        putPixel(g, xc + x, yc - y, c);
        putPixel(g, xc - x, yc - y, c);
    }

    public static void veHinhHCN() {
    }

    public static void veHinhTron(Graphics g, int xc, int yc, int r, Color c) {
        int x = 0, y = r;
        int f = 1 - r;

        put8Pixel(g, xc, yc, x, y, c);

        while (x < y) {
            if (f < 0) {
                f += (x << 1) + 3;
            } else {
                y--;
                f += ((x - y) << 1) + 5;
            }
            x++;
            put8Pixel(g, xc, yc, x, y, c);

        }
    }

    public static void veNuaHinhTron(Graphics g, int xc, int yc, int r, Color c) {
        int x = 0, y = r;
        int f = 1 - r;

        put4Pixel(g, xc, yc, x, y, c);

        while (x < y) {
            if (f < 0) {
                f += (x << 1) + 3;
            } else {
                y--;
                f += ((x - y) << 1) + 5;
            }
            x++;
            put4Pixel(g, xc, yc, x, y, c);

        }
    }

    public static void veHinhEclip(Graphics g,Point tam , int a, int b, Color c) {
        int xc = (int) tam.getX();
        int yc = (int) tam.getY();
        int x, y, fx, fy, a2, b2, p;
        x = 0;
        y = b;
        a2 = a * a;
        b2 = b * b;
        fx = 0;
        fy = 2 * a2 * y;
        int count =0;
        put4PixelEclipNua(g,xc, yc, x, y, c,count);
        p = (int) Math.round(b2 - (a2 * b) + (0.25 * a2));//p=b2 - a2*b +a2/4
        while (fx < fy) {
            count++;
            x++;
            fx += 2 * b2;
            if (p < 0) {
                p += b2 * (2 * x + 3);//p=p + b2*(2x +3)
            } else {
                y--;
                p += b2 * (2 * x + 3) + a2 * (2 - 2 * y);//p=p +b2(2x +3) +a2(2-2y)
                fy -= 2 * a2;
            }
            put4PixelEclipNua(g,xc, yc, x, y, c,count);
        }
        p = (int) Math.round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);
        //
        while (y > 0) {
            count++;
            y--;
            fy -= 2 * a2;
            if (p >= 0) {
                p += a2 * (3 - 2 * y); //p=p +a2(3-2y)
            } else {
                x++;
                fx += 2 * b2;
                p += b2 * (2 * x + 2) + a2 * (3 - 2 * y);//p=p+ b2(2x +2) + a2(3-2y)
            }
            put4PixelEclipNua(g,xc, yc, x, y, c,count);
        }
    }

    //midPoint
    public static void line(Graphics g, int x1, int y1, int x2, int y2, Color c) {
        int x_unit = 1, Dx = x2 - x1, Dy = y2 - y1;
        int x = x1;
        float y = y1;
        float y_unit = 1;
        if (Dx < 0) {
            x_unit = -1;
        }
        if (Dy < 0) {
            y_unit = -1;
        }
        if (x1 == x2) // duong thang dung
        {
            while (y != y2) {
                y += y_unit;
                putPixel(g, x, Math.round(y), c);
            }
        } else if (y1 == y2) // duong ngang
        {
            while (x != x2) {
                x += x_unit;
                putPixel(g, x, Math.round(y), c);
            }
        } else if (x1 != x2 && y1 != y2)// duong xien
        {
            float m = (float) Math.abs(Dy) / Math.abs(Dx);
            x_unit = 1;
            y_unit = m;
            x = x1;
            y = y1;

            if (Dx < 0) {
                x_unit = -1;        // ve x giam
            }
            if (Dy < 0) {
                y_unit = -m;        // ve y giam
            }
            putPixel(g, x, Math.round(y), c);
            while (x != x2) {
                x += x_unit;
                y += y_unit;
                putPixel(g, x, Math.round(y), c);
            }
        }
    }

    public static void linePoint(Graphics g, Point p1, Point p2, Color c) {
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();
        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();

        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
//        p = 2 * Dy - Dx;
        x = x1;
        y = y1;
         //ve diem pixel dau tien
        putPixel(g, x, y, c);
        int x_unit = 1, y_unit = 1;

        
        putPixel(g, x, y, c);
        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                
                putPixel(g, x, y, c);
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                
                putPixel(g, x, y, c);
            }
        }

    }
    
    public static void linePointThieuCham(Graphics g, Point p1, Point p2, Color c) {
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();
        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();
        float dist = ((Math.abs(x1 - x2) > Math.abs(y1 - y2)) ? Math.abs(x1 - x2) : Math.abs(y1 - y2));
        float now_x = x1, now_y = y1;
        int push_x, push_y;
        int push = 0, next = 0;
        putPixel(g, x1, y1, c);
        for (int i = 0; i < dist; i++) {

            push_x = Math.round(now_x);
            push_y = Math.round(now_y);
            putPixel(g, push_x, push_y, c);
            now_x += (x2 - x1) / dist;
            now_y += (y2 - y1) / dist;

        }
    }
    
    public static void lineDashPoint(Graphics g, Point p1, Point p2, Color c) {
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();
        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();
        int dem=0;

        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
//        p = 2 * Dy - Dx;
        x = x1;
        y = y1;
         //ve diem pixel dau tien
        putPixel(g, x, y, c);
        int x_unit = 1, y_unit = 1;

        
        putPixel(g, x, y, c);
        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                dem++;
                if(dem%2==0)
                putPixel(g, x, y, c);
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                dem++;
                if(dem%2==0)
                putPixel(g, x, y, c);
            }
        }

    }
    
    public static void veHinhTronPoint(Graphics g, Point p, int r, Color c) {
        int xc = (int) p.getX();
        int yc = (int) p.getY();
        int x = 0, y = r;
        int f = 1 - r;

        put8Pixel(g, xc, yc, x, y, c);

        while (x < y) {
            if (f < 0) {
                f += (x << 1) + 3;
            } else {
                y--;
                f += ((x - y) << 1) + 5;
            }
            x++;
            put8Pixel(g, xc, yc, x, y, c);

        }
    }

    public static Point nhanMT(int matran[][], int mang[]) {
        int mangtam[] = new int[3];
        int dem = 0;
        for (int i = 0; i < 3; i++) {
            mangtam[i] = mang[0] * matran[0][dem] + mang[1] * matran[1][dem] + mang[2] * matran[2][dem];
            dem++;
        }

        Point pt = new Point(mangtam[0], mangtam[1]);
        return pt;
    }

    public static double[] nhan2MaTran(double mt1[], double[][] mt2) {
        double[] result = new double[3];

        for (int i = 0; i < mt1.length; i++) {
            double sum = 0;
            for (int j = 0; j < mt2[i].length; j++) {
                sum += (mt1[j] * mt2[j][i]);
            }

            result[i] = sum;
        }

        return result;
    }

    public static Point tinhTien(Point p, int xDonVi, int yDonVi) {
        int[] matran1 = {(int) p.getX(), (int) p.getY(), 1};
        // khởi tạo ma trận tịnh tiến
        int[][] matran2 = {{1, 0, 0},
        {0, 1, 0},
        {xDonVi, yDonVi, 1}};

        return nhanMT(matran2, matran1);
    }

    public static void tinhTienXe(ArrayList<Point> lp, int x, int y) {
        for (int i = 0; i < lp.size(); i++) {
            Point p = lp.get(i);

            lp.set(i, tinhTien(p, x, y));
        }
    }

    public static Point phepQuay(Point p, Point tam, double goc) {
        int x = (int) p.getX();
        int y = (int) p.getY();
        int x1 = (int) tam.getX();
        int y1 = (int) tam.getY();
        goc = Math.toRadians(goc);
//        double[] mt1 = {x,y,1};
//        double[][] mt2 = {{1,0,0},{0,1,0},{-x1, -y1,1}};
//        double[][] mt3 = {{Math.cos(goc),Math.sin(goc), 0}, {-Math.sin(goc), Math.cos(goc), 0}, {0,0,1}};
//        double[][] mt4 = {{1,0,0},{0,1,0},{x1, y1, 1}};
//        double[] mt5 = nhan2MaTran(nhan2MaTran(nhan2MaTran(mt1, mt2), mt3), mt4);
//        int x2 = (int) Math.round(mt5[0] * 10) / 10;
//        int y2 = (int) Math.round(mt5[1] * 10 / 10);
        int x2 = (int) (Math.round((x - x1) * Math.cos(goc) - (y - y1) * Math.sin(goc)) + x1);
        int y2 = (int) (Math.round((x - x1) * Math.sin(goc) + (y - y1) * Math.cos(goc)) + y1);
        Point kq = new Point(x2, y2);
        return kq;
    }
    public static Point doiXung(Point p,String truc){
        if(truc.equals("Ox")){
            return new Point((int)p.getX(),(int)-p.getY());
        }
        if(truc.equals("O")){
            return new Point((int)-p.getX(),(int)-p.getY());
        }
        return new Point((int)-p.getX(),(int)p.getY());
    }
    public static Point thuPhongDiem(Point p,double x){
        return new Point((int)(p.getX()*x),(int)(p.getY()*x));
    }
    public static int thuPhongSize(int r,double x){
        return (int)(r*x);
    }
    public static Point chuyenVeToaDoMay(Point p){
        return new Point((int) (p.getX()*5+centerX-2),(int)(centerY-(p.getY()*5)-2));
    }
}
