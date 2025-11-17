package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controlador.logica_ventana;
import controlador.Idiomas;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import java.awt.Color;

public class ventana extends JFrame {

	public JPanel contentPane;
	public JTextField txt_nombres;
	public JTextField txt_telefono;
	public JTextField txt_email;
	public JTextField txt_buscar;
	public JCheckBox chb_favorito;
	public JComboBox cmb_categoria;
	public JButton btn_add;
	public JButton btn_modificar;
	public JButton btn_eliminar;

	public JTabbedPane tabbedPane;
	public JTable tabla_contactos;
	public DefaultTableModel modeloTabla;
	public JProgressBar barraProgreso;

	public JLabel lbl_total_contactos;
	public JLabel lbl_total_favoritos;
	public JLabel lbl_total_familia;
	public JLabel lbl_total_amigos;
	public JLabel lbl_total_trabajo;
	public JButton btn_exportar;
	public JComboBox cmb_idioma;
	public JLabel lbl_etiqueta1;
	public JLabel lbl_etiqueta2;
	public JLabel lbl_etiqueta3;
	public JLabel lbl_etiqueta4;
	public JLabel lbl_idioma_label;
	public JLabel lbl_titulo_stats;
	public JLabel lbl_stats_1;
	public JLabel lbl_stats_2;
	public JLabel lbl_stats_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                ventana frame = new ventana();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}

	/**
	 * Create the frame.
	 */
	public ventana() {
		setTitle(Idiomas.obtener("ventana.titulo"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(100, 100, 1026, 748);
		setMinimumSize(new java.awt.Dimension(800, 600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		// ======================== PANEL CONTACTOS ========================
		JPanel panelContactos = new JPanel();
		panelContactos.setLayout(new BorderLayout());
		panelContactos.setBackground(Color.WHITE);

		// Panel de Entrada (Norte)
		JPanel panelEntrada = new JPanel();
		panelEntrada.setBackground(new Color(77, 82, 100));
		panelEntrada.setLayout(new GridBagLayout());
		GridBagConstraints gbc;

		lbl_etiqueta1 = new JLabel(Idiomas.obtener("label.nombres"));
		lbl_etiqueta1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_etiqueta1.setForeground(Color.WHITE);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(15, 15, 10, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEntrada.add(lbl_etiqueta1, gbc);

		txt_nombres = new JTextField();
		txt_nombres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_nombres.setColumns(30);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(15, 5, 10, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		panelEntrada.add(txt_nombres, gbc);

		lbl_etiqueta2 = new JLabel(Idiomas.obtener("label.telefono"));
		lbl_etiqueta2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_etiqueta2.setForeground(Color.WHITE);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 15, 10, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEntrada.add(lbl_etiqueta2, gbc);

		txt_telefono = new JTextField();
		txt_telefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_telefono.setColumns(30);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 5, 10, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		panelEntrada.add(txt_telefono, gbc);

		lbl_etiqueta3 = new JLabel(Idiomas.obtener("label.email"));
		lbl_etiqueta3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_etiqueta3.setForeground(Color.WHITE);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 15, 10, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEntrada.add(lbl_etiqueta3, gbc);

		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_email.setColumns(30);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 5, 10, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		panelEntrada.add(txt_email, gbc);

		// Favorito y Categoría
		chb_favorito = new JCheckBox(Idiomas.obtener("label.favorito"));
		chb_favorito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chb_favorito.setForeground(Color.WHITE);
		chb_favorito.setBackground(new Color(77, 82, 100));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(5, 15, 15, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEntrada.add(chb_favorito, gbc);

		cmb_categoria = new JComboBox();
		cmb_categoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(5, 5, 15, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		panelEntrada.add(cmb_categoria, gbc);

		// Idioma (arriba a la derecha)
		lbl_idioma_label = new JLabel("IDIOMA:");
		lbl_idioma_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_idioma_label.setForeground(Color.WHITE);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.insets = new Insets(15, 10, 10, 5);
		gbc.anchor = GridBagConstraints.WEST;
		panelEntrada.add(lbl_idioma_label, gbc);

		cmb_idioma = new JComboBox();
		cmb_idioma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmb_idioma.addItem("Espanol");
		cmb_idioma.addItem("English");
		cmb_idioma.addItem("Francais");
		cmb_idioma.setSelectedIndex(0);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 10, 10, 15);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.3;
		panelEntrada.add(cmb_idioma, gbc);

		// Botones de acción (debajo del formulario - se adaptan al tamaño)
		btn_add = new JButton(Idiomas.obtener("btn.agregar"));
		btn_add.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_add.setBackground(new Color(52, 232, 86));
		btn_add.setForeground(Color.WHITE);
		btn_add.setFocusPainted(false);
		btn_add.setOpaque(true);
		btn_add.setBorderPainted(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(20, 15, 15, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.33;
		panelEntrada.add(btn_add, gbc);

		btn_modificar = new JButton(Idiomas.obtener("btn.modificar"));
		btn_modificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_modificar.setBackground(new Color(52, 84, 232));
		btn_modificar.setForeground(Color.WHITE);
		btn_modificar.setFocusPainted(false);
		btn_modificar.setOpaque(true);
		btn_modificar.setBorderPainted(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(20, 5, 15, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.33;
		panelEntrada.add(btn_modificar, gbc);

		btn_eliminar = new JButton(Idiomas.obtener("btn.eliminar"));
		btn_eliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_eliminar.setBackground(new Color(227, 51, 82));
		btn_eliminar.setForeground(Color.WHITE);
		btn_eliminar.setFocusPainted(false);
		btn_eliminar.setOpaque(true);
		btn_eliminar.setBorderPainted(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.insets = new Insets(20, 5, 15, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.33;
		panelEntrada.add(btn_eliminar, gbc);

		String[] categorias = {Idiomas.obtener("categoria.elija"), Idiomas.obtener("categoria.familia"), Idiomas.obtener("categoria.amigos"), Idiomas.obtener("categoria.trabajo")};
		for (String categoria : categorias) {
		    cmb_categoria.addItem(categoria);
		}

		// Panel Búsqueda
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.WHITE);
		panelBusqueda.setLayout(new BorderLayout());
		panelBusqueda.setBorder(new EmptyBorder(10, 10, 10, 10));

		lbl_etiqueta4 = new JLabel(Idiomas.obtener("label.buscar"));
		lbl_etiqueta4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_etiqueta4.setForeground(new Color(52, 84, 232));
		panelBusqueda.add(lbl_etiqueta4, BorderLayout.WEST);

		JPanel panelBuscadorCampo = new JPanel();
		panelBuscadorCampo.setBackground(Color.WHITE);
		panelBuscadorCampo.setLayout(new BorderLayout(5, 0));

		txt_buscar = new JTextField();
		txt_buscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelBuscadorCampo.add(txt_buscar, BorderLayout.CENTER);

		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_buscar.setBackground(new Color(253, 142, 41));
		btn_buscar.setForeground(Color.WHITE);
		btn_buscar.setFocusPainted(false);
		btn_buscar.setOpaque(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setPreferredSize(new java.awt.Dimension(50, 31));
		panelBuscadorCampo.add(btn_buscar, BorderLayout.EAST);

		panelBusqueda.add(panelBuscadorCampo, BorderLayout.CENTER);

		// Panel Superior que contiene ENTRADA y BÚSQUEDA
		JPanel panelSuperior = new JPanel(new BorderLayout());
		panelSuperior.setBackground(Color.WHITE);
		panelSuperior.add(panelEntrada, BorderLayout.NORTH);
		panelSuperior.add(panelBusqueda, BorderLayout.SOUTH);

		panelContactos.add(panelSuperior, BorderLayout.NORTH);

		// Tabla (Centro)
		String[] columnas = {Idiomas.obtener("tabla.nombre"), Idiomas.obtener("tabla.telefono"), Idiomas.obtener("tabla.email"), Idiomas.obtener("tabla.categoria"), Idiomas.obtener("tabla.favorito")};
		modeloTabla = new DefaultTableModel(columnas, 0);
		tabla_contactos = new JTable(modeloTabla);
		tabla_contactos.setAutoCreateRowSorter(true);
		tabla_contactos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tabla_contactos.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		tabla_contactos.setRowHeight(25);

		JScrollPane scrollTabla = new JScrollPane(tabla_contactos);
		JPanel panelTabla = new JPanel(new BorderLayout());
		panelTabla.setBorder(new EmptyBorder(5, 10, 5, 10));
		panelTabla.add(scrollTabla, BorderLayout.CENTER);

		panelContactos.add(panelTabla, BorderLayout.CENTER);

		// Barra de Progreso (Sur)
		barraProgreso = new JProgressBar();
		barraProgreso.setStringPainted(true);
		barraProgreso.setVisible(false);
		JPanel panelProgreso = new JPanel(new BorderLayout());
		panelProgreso.setBorder(new EmptyBorder(5, 10, 10, 10));
		panelProgreso.add(barraProgreso, BorderLayout.CENTER);
		panelContactos.add(panelProgreso, BorderLayout.SOUTH);

		tabbedPane.addTab(Idiomas.obtener("pestana.contactos"), panelContactos);

		// ======================== PANEL ESTADÍSTICAS ========================
		JPanel panelEstadisticas = new JPanel();
		panelEstadisticas.setBackground(Color.WHITE);
		panelEstadisticas.setLayout(new GridBagLayout());

		lbl_titulo_stats = new JLabel(Idiomas.obtener("titulo.estadisticas"));
		lbl_titulo_stats.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_titulo_stats.setForeground(new Color(52, 84, 232));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 0, 30, 0);
		panelEstadisticas.add(lbl_titulo_stats, gbc);

		lbl_stats_1 = new JLabel(Idiomas.obtener("label.total.contactos"));
		lbl_stats_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 50, 10, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEstadisticas.add(lbl_stats_1, gbc);

		lbl_total_contactos = new JLabel("0");
		lbl_total_contactos.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbl_total_contactos.setForeground(new Color(52, 84, 232));
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(10, 10, 10, 50);
		gbc.anchor = GridBagConstraints.WEST;
		panelEstadisticas.add(lbl_total_contactos, gbc);

		lbl_stats_2 = new JLabel(Idiomas.obtener("label.total.favoritos"));
		lbl_stats_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 50, 10, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEstadisticas.add(lbl_stats_2, gbc);

		lbl_total_favoritos = new JLabel("0");
		lbl_total_favoritos.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbl_total_favoritos.setForeground(new Color(52, 232, 86));
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(10, 10, 10, 50);
		gbc.anchor = GridBagConstraints.WEST;
		panelEstadisticas.add(lbl_total_favoritos, gbc);

		lbl_stats_3 = new JLabel(Idiomas.obtener("label.categoria.info"));
		lbl_stats_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_stats_3.setForeground(new Color(253, 142, 41));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 0, 15, 0);
		panelEstadisticas.add(lbl_stats_3, gbc);

		lbl_total_familia = new JLabel(Idiomas.obtener("label.familia") + " 0");
		lbl_total_familia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 80, 5, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEstadisticas.add(lbl_total_familia, gbc);

		lbl_total_amigos = new JLabel(Idiomas.obtener("label.amigos") + " 0");
		lbl_total_amigos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 80, 5, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEstadisticas.add(lbl_total_amigos, gbc);

		lbl_total_trabajo = new JLabel(Idiomas.obtener("label.trabajo") + " 0");
		lbl_total_trabajo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 80, 30, 10);
		gbc.anchor = GridBagConstraints.WEST;
		panelEstadisticas.add(lbl_total_trabajo, gbc);

		btn_exportar = new JButton(Idiomas.obtener("btn.exportar"));
		btn_exportar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_exportar.setBackground(new Color(52, 84, 232));
		btn_exportar.setForeground(Color.WHITE);
		btn_exportar.setFocusPainted(false);
		btn_exportar.setOpaque(true);
		btn_exportar.setBorderPainted(false);
		btn_exportar.setPreferredSize(new java.awt.Dimension(180, 40));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10, 0, 20, 0);
		panelEstadisticas.add(btn_exportar, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.weighty = 1.0;
		panelEstadisticas.add(new JPanel(), gbc);

		tabbedPane.addTab(Idiomas.obtener("pestana.estadisticas"), panelEstadisticas);

		logica_ventana lv=new logica_ventana(this);
	}
}
