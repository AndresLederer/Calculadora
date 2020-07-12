package CalculadoraPackage;

import java.awt.Color;
import java.awt.Font;

public interface Calcular {
	//paleta de color dark
	public Color bgColor = new Color(24, 29, 39);
	
	//paleta de color light
	public Color lightBgColor = new Color(133, 133, 140);
	
	//paleta de colores de botones
	public Color primaryButtonColor = new Color(255, 200, 87); //109, 142, 160
	public Color secondaryButtonColor = new Color(199, 130, 131);
		
	//fuentes de layout
	public Font visorFont = new Font("arial",Font.ITALIC,40);
	public Font primaryButtonsFont = new Font("arial",Font.PLAIN,20);
	public Font secondaryButtonsFont = new Font("arial",Font.BOLD,20);
}
