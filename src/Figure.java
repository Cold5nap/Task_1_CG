public class Figure {
    private int x;
    private int y;
    private int w;
    private int h;

    public Figure(int x, int y,int width,int height) {
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
    }

    public int getX(double xMultiplier){
        return (int) (w * xMultiplier + x);
    }

    public int getY(double yMultiplier){
        return (int) (w * yMultiplier + x);
    }

    public int[] getXPoints(double[] xMultiplierPoints ){
        int [] createdXPoints = new int [xMultiplierPoints.length];
        for (int i =0;i<xMultiplierPoints.length;i++){
            createdXPoints[i]=(int)(w*xMultiplierPoints[i] + x);
        }
        return createdXPoints;
    }
    public int[] getYPoints(double[] yPoints ){
        int [] createdYPoints = new int [yPoints.length];
        for (int i =0;i<yPoints.length;i++){
            createdYPoints[i]=(int)(h*yPoints[i] + y);
        }
        return createdYPoints;
    }

    public void drawFigure(int widthScale, int heightScale) {

    }
}
