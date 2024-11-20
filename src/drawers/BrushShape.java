package drawers;

import java.awt.*;
import java.util.ArrayList;

public class BrushShape extends Shape{
    private final ArrayList<Point> points = new ArrayList<>();

    @Override
    public void set(int x1, int y1, int x2, int y2) {
        super.set(x1, y1, x2, y2);
        points.add(new Point(x2, y2));
    }

    @Override
    public void show(Graphics2D g, boolean isMark, boolean isHighLighted) {
        g.setColor(isHighLighted ? Color.GREEN : borderColor);
        new StrokeSetter(g, thickness, isMark, 10);

        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            System.out.println(p1.getX() + " / " + p1.getY());
            Point p2 = points.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    @Override
    public String getType() {
        return "Brush";
    }
}
