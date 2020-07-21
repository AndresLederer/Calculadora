package CalculadoraPackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculadoraLayout extends JFrame implements Calcular{
	//defino enum con los 4 tipos de operacions que hara la calculadora
	enum Operacion{
		SUMA,RESTA,MULTI,DIV,IGUAL,AC;
	}
	//el atributo ultimaOperacion guardará cual fue el ultimo boton que se presiono
	//inicialmente toma el valor AC
	private Operacion ultimaOperacion = Operacion.AC;
	
	//serial version uid
	private static final long serialVersionUID = 1L;
	//contenedor
	private Container contentPane;
	//panel principal (index)
	private JPanel panelCalc;
	//visor principal
	private JTextArea visor;
	//visores para propinas
	private JTextArea totalTips;
	private JTextField cantPersonasTips;
	private JTextField porcentajeTips;
	private JTextField propinaTotal;
	private JTextField propinaPorPersona;
	//jlabels para propinas
	private JLabel totalTipsJLabel;
	private JLabel cantPersonasJLabel;
	private JLabel porcentajeTipsJLabel;
	private JLabel propinaTotalJLabel;
	private JLabel propinaPorPersonaJLabel;
	
	
	//numero Alpha
	private double nAlpha;
	
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
		cargarPanelLight();
	}
	
	//crea JPanel index
	private void cargarPanelLight() {
		panelCalc = new JPanel();
		panelCalc.setLayout(null);
		panelCalc.setBackground(bgColor);
		
		//cargo componentes al panel
		cargarVisor();
		cargarBotones();
		cargarRadioBotones();
		//componentes para "propinas"
		cargarVisoresTipsPanel();
		cargarEtiquetasTipsPanel();
		
		contentPane.add(panelCalc);
	}
	
	private void cargarVisor() {
		visor = new JTextArea();
		visor.setBounds(41,30,318,132);
		visor.setEditable(false);
		visor.setFont(visorFont);
		visor.setVisible(true);
		
		//agrego el visor al panel
		panelCalc.add(visor);
	}	
	
	//instancio todos los botones
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
		
		JButton bMenos = new JButton("(-)");
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
		
		JButton bTips = new JButton("TIPS");
		bTips.setBounds(298,527,61,43);
		bTips.setBackground(secondaryButtonColor);
		bTips.setFont(new Font("arial",Font.BOLD,12));
		bTips.setHorizontalAlignment(SwingConstants.CENTER);
		
		//agrego botones al panel
		panelCalc.add(b0);
		panelCalc.add(b1);
		panelCalc.add(b2);
		panelCalc.add(b3);
		panelCalc.add(b4);
		panelCalc.add(b5);
		panelCalc.add(b6);
		panelCalc.add(b7);
		panelCalc.add(b8);
		panelCalc.add(b9);
		panelCalc.add(bMenos);
		panelCalc.add(bPunto);
		panelCalc.add(bDiv);
		panelCalc.add(bMulti);
		panelCalc.add(bResta);
		panelCalc.add(bSuma);
		panelCalc.add(bClear);
		panelCalc.add(bIgual);
		panelCalc.add(bTips);
		
		//agrego action listener de para cada boton numerico
		ActionListener bMenosActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("-");
			}
		};
		ActionListener bPuntoActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append(".");
			}
		};
		ActionListener b0ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("0");
			}
		};
		ActionListener b1ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("1");
			}
		};
		ActionListener b2ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("2");
			}
		};
		ActionListener b3ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("3");
			}
		};
		ActionListener b4ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("4");
			}
		};
		ActionListener b5ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("5");
			}
		};
		ActionListener b6ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("6");
			}
		};
		ActionListener b7ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("7");
			}
		};
		ActionListener b8ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("8");
			}
		};
		ActionListener b9ActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visor.append("9");
			}
		};
		//agrego action listeners a los botones principales
		bMenos.addActionListener(bMenosActionListener);
		bPunto.addActionListener(bPuntoActionListener);
		b0.addActionListener(b0ActionListener);
		b1.addActionListener(b1ActionListener);
		b2.addActionListener(b2ActionListener);
		b3.addActionListener(b3ActionListener);
		b4.addActionListener(b4ActionListener);
		b5.addActionListener(b5ActionListener);
		b6.addActionListener(b6ActionListener);
		b7.addActionListener(b7ActionListener);
		b8.addActionListener(b8ActionListener);
		b9.addActionListener(b9ActionListener);
		
		
		//agrego action listener para cada boton de operaciones (=,-,/,x,AC,=)
		ActionListener bClearActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!visorVacio()) visor.setText("");
				nAlpha = 0;
				ultimaOperacion = Operacion.AC;
			}
		};
		bClear.addActionListener(bClearActionListener);
		
		ActionListener bSumaActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					if(!visorVacio()) {
						if(ultimaOperacion != Operacion.IGUAL)
							nAlpha += Double.parseDouble(visor.getText());
						ultimaOperacion = Operacion.SUMA;
						visor.setText("");
					}
				}catch (NumberFormatException nfe) {
					System.out.println("number format exception en suma");
					displaySyntaxError();
				}
			}
		};
		bSuma.addActionListener(bSumaActionListener);
		
		ActionListener bRestActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!visorVacio()) {
						if(ultimaOperacion == Operacion.AC || ultimaOperacion == Operacion.IGUAL) {
							nAlpha = Double.parseDouble(visor.getText());
						}else {
							nAlpha -= Double.parseDouble(visor.getText());
						}
						ultimaOperacion = Operacion.RESTA;
						visor.setText("");
					}
				}catch (NumberFormatException nfe){
					System.out.println("number format exception en resta");
					displaySyntaxError();
				}
			}
		};
		bResta.addActionListener(bRestActionListener);
		
		ActionListener bDivActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!visorVacio()) {
						if(ultimaOperacion == Operacion.AC || ultimaOperacion == Operacion.IGUAL) {
							nAlpha = Double.parseDouble(visor.getText());
						}else {
							nAlpha /= Double.parseDouble(visor.getText());
						}
						ultimaOperacion = Operacion.DIV;
						visor.setText("");
					}
				}catch (NumberFormatException nfe) {
					System.out.println("number format exception en division");
					displaySyntaxError();
				}
			}
		};
		bDiv.addActionListener(bDivActionListener);
		
		ActionListener bMultiActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!visorVacio()) {
						if(ultimaOperacion == Operacion.AC || ultimaOperacion == Operacion.IGUAL)
							nAlpha = Double.parseDouble(visor.getText());
						else
							nAlpha *= Double.parseDouble(visor.getText());
						ultimaOperacion = Operacion.MULTI;
						visor.setText("");
					}
				}catch (NumberFormatException nfe){
					System.out.println("number format exception en multiplicacion");
					displaySyntaxError();
				}
			}
		};
		bMulti.addActionListener(bMultiActionListener);
		
		ActionListener bIgualActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					switch (ultimaOperacion) {
					case SUMA: 
						nAlpha += Double.parseDouble(visor.getText());
						break;
					case RESTA:
						nAlpha -= Double.parseDouble(visor.getText());
						break;
					case DIV:
						nAlpha /= Double.parseDouble(visor.getText());
						break;
					case MULTI:
						nAlpha *= Double.parseDouble(visor.getText());
						break;
					default:
						break;
					}
					
					if(ultimaOperacion != Operacion.AC) {
						visor.setText(String.format("%.2f",nAlpha));
						ultimaOperacion = Operacion.IGUAL;
					}
				}catch (NumberFormatException fne) {
					System.out.println("number format exception en igual");
					displaySyntaxError();
				}
			}
		};
		bIgual.addActionListener(bIgualActionListener);
		
		//el boton TIPS cambia de un formato de visor a otro
		//cambia la visibilidad de los jtextfields,jtextarea y jlabels
		ActionListener tipsActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(visor.isVisible()) {
					//oculto el visor standar y cambio el txt del btn a "StandardCalc"
					visor.setVisible(false);
					bTips.setText("SC");
					//muestro todos los visores de TIPS
					totalTips.setVisible(true);
					cantPersonasTips.setVisible(true);
					porcentajeTips.setVisible(true);
					propinaTotal.setVisible(true);
					propinaPorPersona.setVisible(true);
					//muestros los txt JLabel (UI)
					totalTipsJLabel.setVisible(true);
				}else {
					//oculto todos los visores de TIPS
					totalTips.setVisible(false);
					cantPersonasTips.setVisible(false);
					porcentajeTips.setVisible(false);
					propinaTotal.setVisible(false);
					propinaPorPersona.setVisible(false);
					//oculto todas las txt JLabel (UI)
					totalTipsJLabel.setVisible(false);
					//hago visible el visor de StandardCalc y cambio el txt del btn
					visor.setVisible(true);
					bTips.setText("TIPS");
				}
			}
		};
		bTips.addActionListener(tipsActionListener);
	}
		
	//devuelve true si el visor esta vacio
	private boolean visorVacio() {
		if(visor.getText().equals(""))
			return true;
		else 			
			return false;
	}
	
	//muestra en el visor un mensaje de error
	private void displaySyntaxError() {
		visor.setText("Syntax Error");
	}

	private void cargarRadioBotones() {
		//instancio los radio buttons
		JRadioButton rbLight = new JRadioButton("Light",false);
		rbLight.setBounds(100,580,90,15);
		rbLight.setBackground(bgColor);
		rbLight.setOpaque(true);
		rbLight.setForeground(Color.white);
		
		JRadioButton rbDark = new JRadioButton("Dark",true);
		rbDark.setBounds(210,580,90,15);
		rbDark.setBackground(bgColor);
		rbDark.setOpaque(true);
		rbDark.setForeground(Color.white);
		
		//agrupo los radio buttons
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(rbLight);
		radioButtonGroup.add(rbDark);
		
		panelCalc.add(rbLight);
		panelCalc.add(rbDark);
		
		//agrego action listener y eventos  los radio buttons
		ActionListener rbLightListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 panelCalc.setBackground(lightBgColor);
				 rbLight.setBackground(lightBgColor);
				 rbDark.setBackground(lightBgColor);
				 rbLight.setForeground(Color.black);
				 rbDark.setForeground(Color.black);
			}
		};
		rbLight.addActionListener(rbLightListener);
		
		ActionListener rbDarListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelCalc.setBackground(bgColor);
				rbLight.setBackground(bgColor);
				rbDark.setBackground(bgColor);
				rbLight.setForeground(Color.white);
				rbDark.setForeground(Color.white);
			}
		};
		rbDark.addActionListener(rbDarListener);
	}
	
	//carga todos los visores del panel de propinas
	private void cargarVisoresTipsPanel() {
		//indica el monto total a pagar (SIN PROPINA)
		totalTips= new JTextArea("200");
		totalTips.setBounds(41,30,318,50);
		totalTips.setEditable(false);
		totalTips.setFont(visorFont);
		totalTips.setVisible(false);
		
		//indica la cantidad de personas (clientes)
		cantPersonasTips = new JTextField("5");
		cantPersonasTips.setBounds(41,101,150,20);
		cantPersonasTips.setEditable(false);
		cantPersonasTips.setFont(tipsVisorFont);
		cantPersonasTips.setVisible(false);
		
		//indica el porcentaje que se quiere dejar de propina (de 0 a 100)
		porcentajeTips = new JTextField();
		porcentajeTips.setBounds(209,101,150,20);
		porcentajeTips.setEditable(false);
		porcentajeTips.setFont(tipsVisorFont);
		porcentajeTips.setVisible(false);
		
		//indica la propina total a pagar POR SOBRE el total
		propinaTotal = new JTextField();
		propinaTotal.setBounds(41,142,150,20);
		propinaTotal.setEditable(false);
		propinaTotal.setFont(tipsVisorFont);
		propinaTotal.setVisible(false);
		
		//indica la cantidad de propina que debe poner cada persona (cliente)
		propinaPorPersona = new JTextField();
		propinaPorPersona.setBounds(209,142,150,20);
		propinaPorPersona.setFont(tipsVisorFont);
		propinaPorPersona.setEditable(false);
		propinaPorPersona.setVisible(false);
		
		panelCalc.add(totalTips);
		panelCalc.add(cantPersonasTips);
		panelCalc.add(porcentajeTips);
		panelCalc.add(propinaTotal);
		panelCalc.add(propinaPorPersona);
		
	}
	
	//construye las label (txt) del panel de propinas
	private void cargarEtiquetasTipsPanel() {
		totalTipsJLabel = new JLabel("Total sin propina");
		totalTipsJLabel.setBounds(41,10,150,15);
		totalTipsJLabel.setFont(textLabelFont);
		totalTipsJLabel.setForeground(Color.white);
		totalTipsJLabel.setVisible(false);
		
		panelCalc.add(totalTipsJLabel);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
