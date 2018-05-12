package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;
	private JLabel lblBecauseTheNight;
	private JButton btnStart;
	private JButton btnStop;
	private JLabel lblPattiSmith;
	private JLabel lblBruceSpringsteen;
	private JLabel lblBackVoice;
	private JButton btnStart_1;
	private JButton button;
	private JButton button_1;
	private JButton btnStop_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
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
	public GlavniProzor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(2, 100));
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textArea.setPreferredSize(new Dimension(4, 100));
		}
		return textArea;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblBecauseTheNight());
			panel.add(getBtnStart());
			panel.add(getBtnStop());
			panel.add(getLblPattiSmith());
			panel.add(getLblBruceSpringsteen());
			panel.add(getLblBackVoice());
			panel.add(getBtnStart_1());
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getBtnStop_1());
		}
		return panel;
	}
	private JLabel getLblBecauseTheNight() {
		if (lblBecauseTheNight == null) {
			lblBecauseTheNight = new JLabel("BECAUSE THE NIGHT");
			lblBecauseTheNight.setBounds(160, 13, 141, 16);
		}
		return lblBecauseTheNight;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("START");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnStart.setBounds(24, 46, 157, 39);
		}
		return btnStart;
	}
	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("STOP");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnStop.setBounds(261, 46, 157, 39);
		}
		return btnStop;
	}
	private JLabel getLblPattiSmith() {
		if (lblPattiSmith == null) {
			lblPattiSmith = new JLabel("Patti Smith");
			lblPattiSmith.setBounds(24, 149, 132, 16);
		}
		return lblPattiSmith;
	}
	private JLabel getLblBruceSpringsteen() {
		if (lblBruceSpringsteen == null) {
			lblBruceSpringsteen = new JLabel("Bruce Springsteen");
			lblBruceSpringsteen.setBounds(24, 178, 132, 16);
		}
		return lblBruceSpringsteen;
	}
	private JLabel getLblBackVoice() {
		if (lblBackVoice == null) {
			lblBackVoice = new JLabel("Back Voice");
			lblBackVoice.setBounds(24, 207, 132, 16);
		}
		return lblBackVoice;
	}
	private JButton getBtnStart_1() {
		if (btnStart_1 == null) {
			btnStart_1 = new JButton("Start");
			btnStart_1.setBounds(168, 145, 97, 25);
		}
		return btnStart_1;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Start");
			button.setBounds(168, 174, 97, 25);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Start");
			button_1.setBounds(168, 203, 97, 25);
		}
		return button_1;
	}
	private JButton getBtnStop_1() {
		if (btnStop_1 == null) {
			btnStop_1 = new JButton("STOP");
			btnStop_1.setBounds(302, 145, 116, 78);
		}
		return btnStop_1;
	}
}
