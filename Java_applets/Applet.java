import java.applet.*;
import java.awt.*;

public class Applet extends Applets{

    String msg="";
    public void init()
    {
        msg="Hello Geeks";
    }

    public void start()
    {
        msg=msg+",Welcome to GeeksForGeeks";
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 20);
    }
}