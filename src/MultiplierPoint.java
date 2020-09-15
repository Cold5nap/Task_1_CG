public class MultiplierPoint {
    public double m_x;
    public double m_y;

    public MultiplierPoint(double multiplier_x, double multiplier_y) {
        this.m_x = multiplier_x;
        this.m_y = multiplier_y;
    }

    public MultiplierPoint(MultiplierPoint multiplierPoint) {
        this.m_x = multiplierPoint.m_x;
        this.m_y = multiplierPoint.m_y;
    }

    public double getM_x() {
        return m_x;
    }

    public void setM_x(double m_x) {
        this.m_x = m_x;
    }

    public double getM_y() {
        return m_y;
    }

    public void setM_y(double m_y) {
        this.m_y = m_y;
    }

    public double getXPart(MultiplierPoint multiplier2, double part) {
        return (m_x + multiplier2.m_x * part) / (1 + part);
    }

    public double getYPart(MultiplierPoint multiplier2, double part) {
        return (m_y + multiplier2.m_y * part) / (1 + part);
    }

    public MultiplierPoint getPart(MultiplierPoint multiplierPoint, double part) {
        return new MultiplierPoint(this.getXPart(multiplierPoint, part), this.getYPart(multiplierPoint, part));
    }
}
