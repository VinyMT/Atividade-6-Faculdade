package view;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.entities.Manutencao;
import model.entities.Veiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrotaView {

	private JFrame frame;
	private JTextField tfPlaca;
	private JTextField tfModelo;
	private JTextField tfData;
	private JTextField tfNManutencao;
	private JTextField tfDescricao;
	private JTextField tfPreco;
	private JTextField tfTempoParado;
	private JTextField tfPlacaConsulta;
	private JTextField tfDescricaoConsulta;
	private JTextField tfPlacaConsulta_1;
	private JTextField tfPlacaConsulta_2;
	private JTextField tfPlacaConsulta_3;
	private JTextField tfPlaca1;
	private JTextField tfPlaca2;
	private HashMap<String, Veiculo> frota = new HashMap<>();
	private JTextField tfPlacaManutencao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrotaView window = new FrotaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrotaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 977, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfPlaca = new JTextField();
		tfPlaca.setBounds(10, 31, 298, 20);
		frame.getContentPane().add(tfPlaca);
		tfPlaca.setColumns(10);
		
		tfModelo = new JTextField();
		tfModelo.setColumns(10);
		tfModelo.setBounds(10, 85, 298, 20);
		frame.getContentPane().add(tfModelo);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(10, 144, 298, 20);
		frame.getContentPane().add(tfData);
		
		tfNManutencao = new JTextField();
		tfNManutencao.setColumns(10);
		tfNManutencao.setBounds(10, 253, 298, 20);
		frame.getContentPane().add(tfNManutencao);
		
		tfDescricao = new JTextField();
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(10, 309, 298, 20);
		frame.getContentPane().add(tfDescricao);
		
		tfPreco = new JTextField();
		tfPreco.setColumns(10);
		tfPreco.setBounds(10, 365, 298, 20);
		frame.getContentPane().add(tfPreco);
		
		JLabel lblNumeroManutencao = new JLabel("N\u00FAmero da manuten\u00E7\u00E3o");
		lblNumeroManutencao.setBounds(10, 228, 174, 14);
		frame.getContentPane().add(lblNumeroManutencao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setBounds(10, 284, 174, 14);
		frame.getContentPane().add(lblDescricao);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(10, 340, 174, 14);
		frame.getContentPane().add(lblPreco);
		
		tfTempoParado = new JTextField();
		tfTempoParado.setColumns(10);
		tfTempoParado.setBounds(10, 421, 298, 20);
		frame.getContentPane().add(tfTempoParado);
		
		JLabel lblTempoParado = new JLabel("Tempo Parado");
		lblTempoParado.setBounds(10, 396, 174, 14);
		frame.getContentPane().add(lblTempoParado);
		
		JButton btnCadastrarManutencao = new JButton("Cadastrar Manutencao");
		btnCadastrarManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manutencao m = new Manutencao(Integer.parseInt(tfNManutencao.getText())
						, Float.parseFloat(tfPreco.getText())
						, tfDescricao.getText()
						, Integer.parseInt(tfTempoParado.getText()));
				
				frota.get(tfPlacaManutencao.getText()).addManutencao(m);
			}
		});
		btnCadastrarManutencao.setBounds(10, 513, 174, 40);
		frame.getContentPane().add(btnCadastrarManutencao);
		
		JButton btnCadastrarVeculo = new JButton("Cadastrar Ve\u00EDculo");
		btnCadastrarVeculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Veiculo v;
				try {
					v = new Veiculo(tfPlaca.getText(), tfModelo.getText(), sdf.parse(tfData.getText()));
					if(!frota.containsKey(v.getPlaca())) {
						frota.put(v.getPlaca(), v);
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCadastrarVeculo.setBounds(10, 175, 159, 42);
		frame.getContentPane().add(btnCadastrarVeculo);
		
		JLabel lblData = new JLabel("Data de aquisi\u00E7\u00E3o (dd/MM/yyyy)");
		lblData.setBounds(10, 119, 241, 14);
		frame.getContentPane().add(lblData);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 60, 241, 14);
		frame.getContentPane().add(lblModelo);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(10, 11, 241, 14);
		frame.getContentPane().add(lblPlaca);
		
		tfPlacaConsulta = new JTextField();
		tfPlacaConsulta.setBounds(731, 442, 220, 20);
		frame.getContentPane().add(tfPlacaConsulta);
		tfPlacaConsulta.setColumns(10);
		
		JLabel lblPlacaConsulta = new JLabel("Placa para consulta");
		lblPlacaConsulta.setBounds(731, 424, 196, 14);
		frame.getContentPane().add(lblPlacaConsulta);
		
		JButton btnMesmoServico = new JButton("Consultar quantidade de vezes");
		btnMesmoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, frota.get(tfPlacaConsulta.getText()).getQtdServico(tfDescricaoConsulta.getText()));
			}
		});
		btnMesmoServico.setBounds(610, 469, 220, 23);
		frame.getContentPane().add(btnMesmoServico);
		
		JButton btnIndiceDeSucateamento = new JButton("Indice de Sucateamento");
		btnIndiceDeSucateamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, frota.get(tfPlacaConsulta_1.getText()).indiceDeSucateamento());
			}
		});
		btnIndiceDeSucateamento.setBounds(610, 392, 220, 23);
		frame.getContentPane().add(btnIndiceDeSucateamento);
		
		JButton btnCustoMedioDiario = new JButton("Custo medio di\u00E1rio por manuten\u00E7\u00E3o");
		btnCustoMedioDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Manutencao m : frota.get(tfPlacaConsulta_2.getText()).getManutencoes()) {
					JOptionPane.showMessageDialog(null,"Custo médio Diario: R$ " + m.getCustoMedioDiario());
				}
			}
		});
		btnCustoMedioDiario.setBounds(577, 308, 288, 23);
		frame.getContentPane().add(btnCustoMedioDiario);
		
		JButton btnCustoMedioManutencao = new JButton("Custo m\u00E9dio das manuten\u00E7\u00F5es desse ve\u00EDculo");
		btnCustoMedioManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Custo médio manutenções: " + frota.get(tfPlacaConsulta_3.getText()).getCustoMedio());
			}
		});
		btnCustoMedioManutencao.setBounds(548, 224, 337, 23);
		frame.getContentPane().add(btnCustoMedioManutencao);
		
		tfDescricaoConsulta = new JTextField();
		tfDescricaoConsulta.setBounds(479, 442, 220, 20);
		frame.getContentPane().add(tfDescricaoConsulta);
		tfDescricaoConsulta.setColumns(10);
		
		JLabel lblDescricaoParaConsulta = new JLabel("Descri\u00E7\u00E3o para consulta");
		lblDescricaoParaConsulta.setBounds(479, 424, 196, 14);
		frame.getContentPane().add(lblDescricaoParaConsulta);
		
		tfPlacaConsulta_1 = new JTextField();
		tfPlacaConsulta_1.setBounds(577, 365, 288, 20);
		frame.getContentPane().add(tfPlacaConsulta_1);
		tfPlacaConsulta_1.setColumns(10);
		
		JLabel lblPlacaConsulta_1 = new JLabel("Placa para consulta");
		lblPlacaConsulta_1.setBounds(577, 340, 144, 14);
		frame.getContentPane().add(lblPlacaConsulta_1);
		
		tfPlacaConsulta_2 = new JTextField();
		tfPlacaConsulta_2.setColumns(10);
		tfPlacaConsulta_2.setBounds(577, 281, 288, 20);
		frame.getContentPane().add(tfPlacaConsulta_2);
		
		JLabel lblPlacaConsulta_2 = new JLabel("Placa para consulta");
		lblPlacaConsulta_2.setBounds(577, 256, 189, 14);
		frame.getContentPane().add(lblPlacaConsulta_2);
		
		tfPlacaConsulta_3 = new JTextField();
		tfPlacaConsulta_3.setColumns(10);
		tfPlacaConsulta_3.setBounds(577, 186, 288, 20);
		frame.getContentPane().add(tfPlacaConsulta_3);
		
		JLabel lblPlacaConsulta_3 = new JLabel("Placa para consulta");
		lblPlacaConsulta_3.setBounds(577, 161, 189, 14);
		frame.getContentPane().add(lblPlacaConsulta_3);
		
		tfPlaca1 = new JTextField();
		tfPlaca1.setColumns(10);
		tfPlaca1.setBounds(501, 85, 220, 20);
		frame.getContentPane().add(tfPlaca1);
		
		JLabel lblPlaca1 = new JLabel("Placa 1");
		lblPlaca1.setBounds(501, 60, 196, 14);
		frame.getContentPane().add(lblPlaca1);
		
		tfPlaca2 = new JTextField();
		tfPlaca2.setColumns(10);
		tfPlaca2.setBounds(731, 85, 220, 20);
		frame.getContentPane().add(tfPlaca2);
		
		JLabel lblPlaca2 = new JLabel("Placa 2");
		lblPlaca2.setBounds(731, 60, 196, 14);
		frame.getContentPane().add(lblPlaca2);
		
		JButton btnCompararIndiceDe = new JButton("Comparar indice de sucateamento");
		btnCompararIndiceDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, frota.get(tfPlaca1.getText()).comparaVeiculo(frota.get(tfPlaca2.getText())));
			}
		});
		btnCompararIndiceDe.setBounds(585, 115, 269, 23);
		frame.getContentPane().add(btnCompararIndiceDe);
		
		tfPlacaManutencao = new JTextField();
		tfPlacaManutencao.setBounds(10, 470, 298, 20);
		frame.getContentPane().add(tfPlacaManutencao);
		tfPlacaManutencao.setColumns(10);
		
		JLabel lblPlacaManutencao = new JLabel("Placa");
		lblPlacaManutencao.setBounds(10, 445, 46, 14);
		frame.getContentPane().add(lblPlacaManutencao);
	}
}
