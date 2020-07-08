package CalculadoraPackage;

import java.awt.Container;
import javax.swing.*;

public class CalculadoraLayout extends JFrame implements Calcular{
	//serial version uid
	private static final long serialVersionUID = 1L;
	//contenedor
	private Container contentPane;
	//panel principal (index)
	private JPanel panelCalc;
	
	//constructor
	public CalculadoraLayout() {
		//defino atributos del JFrame
		setTitle("ITS Calculadora");
		setSize(400,640);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = getContentPane();
		//cargo panel index
		cargarPanel();
	}
	
	//crea JPanel index
	private void cargarPanel() {
		panelCalc = new JPanel();
		panelCalc.setLayout(null);
		panelCalc.setBackground(bgColor);
		//cargo componentes al panel
		cargarVisor();
		cargarBotones();
		
		contentPane.add(panelCalc);
	}
	
	private void cargarVisor() {
		JTextArea visor = new JTextArea();
		visor.setBounds(41,30,318,132);
		visor.setEditable(false);
		visor.setFont(visorFont);
		//agrego el visor al panel
		panelCalc.add(visor);
	}	
	
	private void cargarBotones() {
		JButton b7 = new JButton("7");
		b7.setBounds(41,190,61,60);
		b7.setBackground(primaryButtonColor);
		b7.setFont(primaryButtonsFont);
		b7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b8 = new JButton("8");
		b8.setBounds(127,190,61,60);
		b8.setBackground(primaryButtonColor);
		b8.setFont(primaryButtonsFont);
		b8.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b9 = new JButton("9");
		b9.setBounds(213,190,61,60);
		b9.setBackground(primaryButtonColor);
		b9.setFont(primaryButtonsFont);
		b9.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b4 = new JButton("4");
		b4.setBounds(41,276,61,60);
		b4.setBackground(primaryButtonColor);
		b4.setFont(primaryButtonsFont);
		b4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b5 = new JButton("5");
		b5.setBounds(127,276,61,60);
		b5.setBackground(primaryButtonColor);
		b5.setFont(primaryButtonsFont);
		b5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b6 = new JButton("6");
		b6.setBounds(213,276,61,60);
		b6.setBackground(primaryButtonColor);
		b6.setFont(primaryButtonsFont);
		b6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b1 = new JButton("1");
		b1.setBounds(41,362,61,60);
		b1.setBackground(primaryButtonColor);
		b1.setFont(primaryButtonsFont);
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b2 = new JButton("2");
		b2.setBounds(127,362,61,60);
		b2.setBackground(primaryButtonColor);
		b2.setFont(primaryButtonsFont);
		b2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b3 = new JButton("3");
		b3.setBounds(213,362,61,60);
		b3.setBackground(primaryButtonColor);
		b3.setFont(primaryButtonsFont);
		b3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bMenos = new JButton("-");
		bMenos.setBounds(41,449,61,60);
		bMenos.setBackground(primaryButtonColor);
		bMenos.setFont(primaryButtonsFont);
		bMenos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton b0 = new JButton("0");
		b0.setBounds(127,449,61,60);
		b0.setBackground(primaryButtonColor);
		b0.setFont(primaryButtonsFont);
		b0.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bPunto = new JButton(".");
		bPunto.setBounds(213,449,61,60);
		bPunto.setBackground(primaryButtonColor);
		bPunto.setFont(primaryButtonsFont);
		bPunto.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bDiv = new JButton("/");
		bDiv.setBounds(298,190,61,60);
		bDiv.setBackground(secondaryButtonColor);
		bDiv.setFont(secondaryButtonsFont);
		bDiv.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bMulti= new JButton("x");
		bMulti.setBounds(298,276,61,60);
		bMulti.setBackground(secondaryButtonColor);
		bMulti.setFont(secondaryButtonsFont);
		bMulti.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bResta = new JButton("-");
		bResta.setBounds(298,362,61,60);
		bResta.setBackground(secondaryButtonColor);
		bResta.setFont(secondaryButtonsFont);
		bResta.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bSuma = new JButton("+");
		bSuma.setBounds(298,449,61,60);
		bSuma.setBackground(secondaryButtonColor);
		bSuma.setFont(secondaryButtonsFont);
		bSuma.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bClear = new JButton("AC");
		bClear.setBounds(41,527,101,43);
		bClear.setBackground(secondaryButtonColor);
		bClear.setFont(secondaryButtonsFont);
		bClear.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton bIgual = new JButton("=");
		bIgual.setBounds(173,527,101,43);
		bIgual.setBackground(secondaryButtonColor);
		bIgual.setFont(secondaryButtonsFont);
		bIgual.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		//agrego boton al panel
		panelCalc.add(b7);
		panelCalc.add(b8);
		panelCalc.add(b9);
		panelCalc.add(b4);
		panelCalc.add(b5);
		panelCalc.add(b6);
		panelCalc.add(b1);
		panelCalc.add(b2);
		panelCalc.add(b3);
		panelCalc.add(bMenos);
		panelCalc.add(b0);
		panelCalc.add(bPunto);
		panelCalc.add(bDiv);
		panelCalc.add(bMulti);
		panelCalc.add(bResta);
		panelCalc.add(bSuma);
		panelCalc.add(bClear);
		panelCalc.add(bIgual);
	}
}
