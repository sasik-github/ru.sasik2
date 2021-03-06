package ru.sasik.gui.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import ru.sasik.api.ConfigParams;

/**
 * Отвечает за построения осей координат
 * @author sasik
 *
 */
public final class OriginObject {
	
//	public static Integer CONVERTER = 70;
//
//	public static int X_ORIGIN = 2 * CONVERTER;
//
//	public static int Y_ORIGIN = 2 * CONVERTER;
//
//	public static int X_RADIUS = 3;
//
//	public static int Y_RADIUS = 3;
//
//	public static int ORIGIN_LENGTH = CONVERTER;
//
//	public static int ORIGIN_ARROW_10 = 10;
//
//	public static int ORIGIN_ARROW_5 = 5;
//
//	public static Color DATA_COLOR = Color.red;
//
//	public static Color ORIGIN_COLOR = Color.GREEN;
//
//	public static int Y_REVERSE = -1;
//
//	public static Double DX = 0.0;
//
//	public static Double DY = 0.0;
	
	public void draw(Graphics2D g2d) {
		
		g2d.setStroke(new BasicStroke());
		g2d.setColor(ConfigParams.ORIGIN_COLOR);
		// OX
		g2d.drawLine(ConfigParams.X_ORIGIN, ConfigParams.Y_ORIGIN, ConfigParams.X_ORIGIN + ConfigParams.ORIGIN_LENGTH, ConfigParams.Y_ORIGIN);
		g2d.drawLine(ConfigParams.X_ORIGIN + ConfigParams.ORIGIN_LENGTH, ConfigParams.Y_ORIGIN, ConfigParams.X_ORIGIN
				+ ConfigParams.ORIGIN_LENGTH - ConfigParams.ORIGIN_ARROW_10, ConfigParams.Y_ORIGIN + ConfigParams.ORIGIN_ARROW_5);
		g2d.drawLine(ConfigParams.X_ORIGIN + ConfigParams.ORIGIN_LENGTH, ConfigParams.Y_ORIGIN, ConfigParams.X_ORIGIN
				+ ConfigParams.ORIGIN_LENGTH - ConfigParams.ORIGIN_ARROW_10, ConfigParams.Y_ORIGIN - ConfigParams.ORIGIN_ARROW_5);
		// OY
		g2d.drawLine(ConfigParams.X_ORIGIN, ConfigParams.Y_ORIGIN, ConfigParams.X_ORIGIN, ConfigParams.Y_ORIGIN + ConfigParams.ORIGIN_LENGTH
				* ConfigParams.Y_REVERSE);
		g2d.drawLine(ConfigParams.X_ORIGIN, ConfigParams.Y_ORIGIN + ConfigParams.ORIGIN_LENGTH * ConfigParams.Y_REVERSE, ConfigParams.X_ORIGIN
				+ ConfigParams.ORIGIN_ARROW_5, ConfigParams.Y_ORIGIN + (ConfigParams.ORIGIN_LENGTH - ConfigParams.ORIGIN_ARROW_10)
				* ConfigParams.Y_REVERSE);
		g2d.drawLine(ConfigParams.X_ORIGIN, ConfigParams.Y_ORIGIN + ConfigParams.ORIGIN_LENGTH * ConfigParams.Y_REVERSE, ConfigParams.X_ORIGIN
				- ConfigParams.ORIGIN_ARROW_5, ConfigParams.Y_ORIGIN + (ConfigParams.ORIGIN_LENGTH - ConfigParams.ORIGIN_ARROW_10)
				* ConfigParams.Y_REVERSE);
	}
}
