import javax.swing.*;
import java.awt.*;

public class Canvas extends JComponent {
    /*Метод, перерисовывающий элемент внутри окна
     *при обновлении*/
    public void paintComponent(Graphics g) {
        //super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(5));

        Figure figure = new Figure(33, 33, 300, 300);

        double part1 = 0.6, part2 = 0.4;
        // (0,0) - starting point for Multiplier point
        MultiplierPoint a = new MultiplierPoint(0.2, 0.2),
                b = new MultiplierPoint(0.3, 1),
                c = new MultiplierPoint(0.8, 0.7),
                d = new MultiplierPoint(b.getPart(c, part2)),
                f = new MultiplierPoint(0.8, 1.5),
                abPart = new MultiplierPoint(a.getPart(b, part2)),
                adPart = new MultiplierPoint(a.getPart(d, part1)),
                acPart = new MultiplierPoint(a.getPart(c, part2)),
                cfPart = new MultiplierPoint(c.getPart(f, part1)),// was 0.8, 1
                dfPart = new MultiplierPoint(d.getPart(f, part1)),
                fdPart = new MultiplierPoint(f.getPart(dfPart, part2 + 0.1)),
                efPart = new MultiplierPoint(f.getPart(c, part2 - 0.3)),
                b_cfPart = new MultiplierPoint(b.getPart(cfPart, part1));

        //узнать как сделать точку b_cfPart

        //ear of fox
        g2d.drawPolygon(figure.getXPoints(new double[]{a.m_x, d.m_x}), figure.getYPoints(new double[]{a.m_y, d.m_y}), 2);
        g2d.drawPolygon(figure.getXPoints(new double[]{a.m_x, b.m_x, c.m_x}), figure.getYPoints(new double[]{a.m_y, b.m_y, c.m_y}), 3);//median
        g2d.drawLine(figure.getX(abPart.m_x), figure.getY(abPart.m_y), figure.getX(adPart.m_x), figure.getY(adPart.m_y));
        g2d.drawLine(figure.getX(adPart.m_x), figure.getY(adPart.m_y), figure.getX(acPart.m_x), figure.getY(acPart.m_y));
        g2d.drawLine(figure.getX(adPart.m_x), figure.getY(adPart.m_y), figure.getX(b.m_x), figure.getY(b.m_y));
        g2d.drawLine(figure.getX(adPart.m_x), figure.getY(adPart.m_y), figure.getX(c.m_x), figure.getY(c.m_y));
        //muzzle of fox
        g2d.drawPolygon(figure.getXPoints(new double[]{f.m_x, b.m_x, c.m_x}), figure.getYPoints(new double[]{f.m_y, b.m_y, c.m_y}), 3);
        g2d.drawLine(figure.getX(d.m_x), figure.getY(d.m_y), figure.getX(f.m_x), figure.getY(f.m_y));
        g2d.drawLine(figure.getX(b_cfPart.m_x), figure.getY(b_cfPart.m_y), figure.getX(cfPart.m_x), figure.getX(cfPart.m_y));
        g2d.drawLine(figure.getX(b.m_x), figure.getY(b.m_y), figure.getX(b_cfPart.m_x), figure.getX(b_cfPart.m_y));
        g2d.drawLine(figure.getX(d.m_x), figure.getY(d.m_y), figure.getX(cfPart.m_x), figure.getX(cfPart.m_y));
        g2d.drawLine(figure.getX(fdPart.m_x), figure.getY(fdPart.m_y), figure.getX(efPart.m_x), figure.getX(efPart.m_y));

        //paint fox

        Polygon p1 = new Polygon(figure.getXPoints(new double[]{a.m_x, abPart.m_x, adPart.m_x}), figure.getYPoints(new double[]{a.m_y, abPart.m_y, adPart.m_y}), 3);
        Polygon p2 = new Polygon(figure.getXPoints(new double[]{a.m_x, adPart.m_x, acPart.m_x}), figure.getYPoints(new double[]{a.m_y, adPart.m_y, acPart.m_y}), 3);
        Polygon p3 = new Polygon(figure.getXPoints(new double[]{abPart.m_x, adPart.m_x, b.m_x}), figure.getYPoints(new double[]{abPart.m_y, adPart.m_y, b.m_y}), 3);
        Polygon p4 = new Polygon(figure.getXPoints(new double[]{d.m_x, adPart.m_x, b.m_x}), figure.getYPoints(new double[]{d.m_y, adPart.m_y, b.m_y}), 3);
        Polygon p5 = new Polygon(figure.getXPoints(new double[]{d.m_x, adPart.m_x, c.m_x}), figure.getYPoints(new double[]{d.m_y, adPart.m_y, c.m_y}), 3);
        Polygon p6 = new Polygon(figure.getXPoints(new double[]{acPart.m_x, adPart.m_x, c.m_x}), figure.getYPoints(new double[]{acPart.m_y, adPart.m_y, c.m_y}), 3);
        Polygon p7 = new Polygon(figure.getXPoints(new double[]{d.m_x, b.m_x, b_cfPart.m_x}), figure.getYPoints(new double[]{d.m_y, b.m_y, b_cfPart.m_y}), 3);
        Polygon p8 = new Polygon(figure.getXPoints(new double[]{d.m_x, c.m_x, cfPart.m_x}), figure.getYPoints(new double[]{d.m_y, c.m_y, cfPart.m_y}), 3);
        Polygon p9 = new Polygon(figure.getXPoints(new double[]{b.m_x, b_cfPart.m_x, f.m_x}), figure.getYPoints(new double[]{b.m_y, b_cfPart.m_y, f.m_y}), 3);
        Polygon p10 = new Polygon(figure.getXPoints(new double[]{cfPart.m_x, b_cfPart.m_x, f.m_x}), figure.getYPoints(new double[]{cfPart.m_y, b_cfPart.m_y, f.m_y}), 3);
        Polygon p11 = new Polygon(figure.getXPoints(new double[]{efPart.m_x, fdPart.m_x, f.m_x}), figure.getYPoints(new double[]{efPart.m_y, fdPart.m_y, f.m_y}), 3);

        g2d.setBackground(Color.lightGray);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p1);
        g2d.setColor(Color.pink);
        g2d.fillPolygon(p2);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p3);
        g2d.setColor(Color.pink);
        g2d.fillPolygon(p4);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p5);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p6);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p7);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p8);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p9);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p10);
        g2d.setColor(Color.darkGray);
        g2d.fillPolygon(p11);

        g2d.setColor(Color.darkGray);

        //draw symmetry part of fox
        a.setM_x(1.4);
        b.setM_x(1.3);
        d.setM_x(b.getPart(c, part2).m_x);
        abPart.setM_x(a.getPart(b, part2).m_x);
        acPart.setM_x(a.getPart(c, part2).m_x);
        adPart.setM_x(a.getPart(d, part1).m_x);
        cfPart.setM_x(c.getPart(f, part1).m_x);
        dfPart.setM_x(d.getPart(f, part1).m_x);
        fdPart.setM_x(f.getPart(dfPart, part2 + 0.1).m_x);
        efPart.setM_x(f.getPart(c, part2 - 0.3).m_x);
        b_cfPart.setM_x(b.getPart(cfPart, part1).m_x);

        //test1
        //ear of fox
        g2d.drawPolygon(figure.getXPoints(new double[]{a.m_x, b.m_x, c.m_x}), figure.getYPoints(new double[]{a.m_y, b.m_y, c.m_y}), 3);
        g2d.drawPolygon(figure.getXPoints(new double[]{a.m_x, d.m_x}), figure.getYPoints(new double[]{a.m_y, d.m_y}), 2);//median
        g2d.drawLine(figure.getX(abPart.m_x), figure.getY(abPart.m_y), figure.getX(adPart.m_x), figure.getY(adPart.m_y));
        g2d.drawLine(figure.getX(adPart.m_x), figure.getY(adPart.m_y), figure.getX(acPart.m_x), figure.getY(acPart.m_y));
        g2d.drawLine(figure.getX(adPart.m_x), figure.getY(adPart.m_y), figure.getX(b.m_x), figure.getY(b.m_y));
        g2d.drawLine(figure.getX(adPart.m_x), figure.getY(adPart.m_y), figure.getX(c.m_x), figure.getY(c.m_y));
        //muzzle of fox
        g2d.drawPolygon(figure.getXPoints(new double[]{f.m_x, b.m_x, c.m_x}), figure.getYPoints(new double[]{f.m_y, b.m_y, c.m_y}), 3);
        g2d.drawLine(figure.getX(d.m_x), figure.getY(d.m_y), figure.getX(f.m_x), figure.getY(f.m_y));
        g2d.drawLine(figure.getX(b.m_x), figure.getY(b.m_y), figure.getX(cfPart.m_x), figure.getX(cfPart.m_y));
        g2d.drawLine(figure.getX(d.m_x), figure.getY(d.m_y), figure.getX(cfPart.m_x), figure.getX(cfPart.m_y));
        g2d.drawLine(figure.getX(fdPart.m_x), figure.getY(fdPart.m_y), figure.getX(efPart.m_x), figure.getX(efPart.m_y));

        //paint symmetry part of fox

        Polygon p_s1 = new Polygon(figure.getXPoints(new double[]{a.m_x, abPart.m_x, adPart.m_x}), figure.getYPoints(new double[]{a.m_y, abPart.m_y, adPart.m_y}), 3);
        Polygon p_s2 = new Polygon(figure.getXPoints(new double[]{a.m_x, adPart.m_x, acPart.m_x}), figure.getYPoints(new double[]{a.m_y, adPart.m_y, acPart.m_y}), 3);
        Polygon p_s3 = new Polygon(figure.getXPoints(new double[]{abPart.m_x, adPart.m_x, b.m_x}), figure.getYPoints(new double[]{abPart.m_y, adPart.m_y, b.m_y}), 3);
        Polygon p_s4 = new Polygon(figure.getXPoints(new double[]{d.m_x, adPart.m_x, b.m_x}), figure.getYPoints(new double[]{d.m_y, adPart.m_y, b.m_y}), 3);
        Polygon p_s5 = new Polygon(figure.getXPoints(new double[]{d.m_x, adPart.m_x, c.m_x}), figure.getYPoints(new double[]{d.m_y, adPart.m_y, c.m_y}), 3);
        Polygon p_s6 = new Polygon(figure.getXPoints(new double[]{acPart.m_x, adPart.m_x, c.m_x}), figure.getYPoints(new double[]{acPart.m_y, adPart.m_y, c.m_y}), 3);
        Polygon p_s7 = new Polygon(figure.getXPoints(new double[]{d.m_x, b.m_x, b_cfPart.m_x}), figure.getYPoints(new double[]{d.m_y, b.m_y, b_cfPart.m_y}), 3);
        Polygon p_s8 = new Polygon(figure.getXPoints(new double[]{d.m_x, c.m_x, cfPart.m_x}), figure.getYPoints(new double[]{d.m_y, c.m_y, cfPart.m_y}), 3);
        Polygon p_s9 = new Polygon(figure.getXPoints(new double[]{b.m_x, b_cfPart.m_x, f.m_x}), figure.getYPoints(new double[]{b.m_y, b_cfPart.m_y, f.m_y}), 3);
        Polygon p_s10 = new Polygon(figure.getXPoints(new double[]{cfPart.m_x, b_cfPart.m_x, f.m_x}), figure.getYPoints(new double[]{cfPart.m_y, b_cfPart.m_y, f.m_y}), 3);
        Polygon p_s11 = new Polygon(figure.getXPoints(new double[]{efPart.m_x, fdPart.m_x, f.m_x}), figure.getYPoints(new double[]{efPart.m_y, fdPart.m_y, f.m_y}), 3);

        g2d.setBackground(Color.lightGray);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p_s1);
        g2d.setColor(Color.pink);
        g2d.fillPolygon(p_s2);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p_s3);
        g2d.setColor(Color.pink);
        g2d.fillPolygon(p_s4);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p_s5);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p_s6);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p_s7);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p_s8);
        g2d.setColor(Color.orange);
        g2d.fillPolygon(p_s9);
        g2d.setColor(Color.yellow);
        g2d.fillPolygon(p_s10);
        g2d.setColor(Color.darkGray);
        g2d.fillPolygon(p_s11);
        super.repaint();
    }
}
