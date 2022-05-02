import java.io.IOException;
import Vue.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Main {
	public static void main(String[] args) throws IOException {
            MenuPrincipal menu = new MenuPrincipal();
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - menu.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - menu.getHeight()) / 2);
            menu.setLocation(x, y);
            menu.setVisible(true);
	}
	
}
