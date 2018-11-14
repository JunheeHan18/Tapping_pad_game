package Tappingpad;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
/*
 * ∆–µÂ ∞‘¿”
 * class : mainJFrame / Timer
 * function : gameStart, gameEnd, seeRanking, Exit, timer, run 
 */
class mainFrame extends JFrame implements ActionListener {
	
	// title element
	public JLabel titleLabel = new JLabel("Tapping-pad Game");
	public JButton startButton = new JButton("Game Start");
	public JButton seeRankingButton = new JButton("See Ranking");
	public JButton exitButton = new JButton("Exit");
	public Font titleFont = new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 30);
	public Font textFont = new Font("∏º¿∫∞ÌµÒ",Font.BOLD, 20);
 	
	// game element
	static int score = 0;
	static int ran = (int)(Math.random()*9);
	String[] numbers = {"1","2","3","4","5","6","7","8","9"};
	public static JLabel timeLabel = new JLabel();
	public static JLabel scoreLabel = new JLabel("score : "+Integer.toString(score));
	public static JButton[] gameButton = new JButton[9];
	
	//  game end element
	public static JLabel gameEndLabel = new JLabel("Game Over!!");
	public static JLabel gameEndScoreLabel = new JLabel();
	public static JButton restartButton = new JButton("Restart");
	public static JButton goTitleButton = new JButton("Go Title");
	
	// seeRanking element
	public static JLabel rankingLabel = new JLabel("Ranking");
	public static JLabel ranking[] = new JLabel[3];
	public static String scores;
	public static FileWriter out = null;
	public static FileReader in = null;
	
	public mainFrame() {
		setSize(400, 440);
		setLocation(100,100); 
		setTitle("Tapping-pad game"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
//		
//		title element setting
//		 
		titleLabel.setBounds(60, 20, 280, 100);
		titleLabel.setFont(titleFont);
		startButton.setBounds(120, 150, 160, 40);
		startButton.setFont(textFont);
		startButton.setBackground(Color.LIGHT_GRAY);
		startButton.addActionListener(this);
		seeRankingButton.setBounds(120, 210, 160, 40);
		seeRankingButton.setFont(textFont);
		seeRankingButton.setBackground(Color.LIGHT_GRAY);
		seeRankingButton.addActionListener(this);
		exitButton.setBounds(120, 270, 160, 40);
		exitButton.setFont(textFont);
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setRolloverIcon(null);
		exitButton.addActionListener(this);
		
//		
//		game element setting
//		
		scoreLabel.setBounds(5, 387, 70, 10);
		timeLabel.setBounds((ran%3)*128+53,(ran/3)*128+61,70,10);
		for(int i = 0;i<9;i++) {
			gameButton[i] = new JButton(numbers[i]);
			gameButton[i].setBounds(((i%3))*128+1, (i/3)*128+1, 128, 128);
			gameButton[i].setBackground(Color.WHITE);
			gameButton[i].setForeground(Color.WHITE);
			gameButton[i].addActionListener(this);
		}
		gameButton[ran].setBackground(Color.BLACK);
		gameButton[ran].setForeground(Color.BLACK);

//		
//		game end element setting
//		 
		gameEndLabel.setBounds(105, 100, 200, 100);
		gameEndLabel.setFont(titleFont);
		gameEndScoreLabel.setBounds(145, 160, 200, 50);
		gameEndScoreLabel.setFont(textFont);
		
		restartButton.setBounds(55, 250, 120, 35);
		restartButton.setFont(textFont);
		restartButton.setBackground(Color.LIGHT_GRAY);
		goTitleButton.setBounds(210, 250, 120, 35);
		goTitleButton.setFont(textFont);
		goTitleButton.setBackground(Color.LIGHT_GRAY);
		restartButton.addActionListener(this);
		goTitleButton.addActionListener(this);
		
//		
//		add element
//		
		add(titleLabel); 
		add(startButton); 
		add(seeRankingButton); 
		add(exitButton);
		add(scoreLabel);
		add(timeLabel);
		add(gameEndLabel);
		add(gameEndScoreLabel);
		add(restartButton);
		add(goTitleButton);
		for(int i = 0;i<9;i++) {
			add(gameButton[i]);
		}
		
//		
//		default display setting
//		
		scoreLabel.setVisible(false);
		timeLabel.setVisible(false);
		gameEndLabel.setVisible(false);
		gameEndScoreLabel.setVisible(false);
		restartButton.setVisible(false);
		goTitleButton.setVisible(false);
		for(int i = 0;i<9;i++) {
			gameButton[i].setVisible(false);
		}
		
		setVisible(true);
	}
	
	public void gameStart() {
		titleLabel.setVisible(false);
		startButton.setVisible(false);
		seeRankingButton.setVisible(false);
		exitButton.setVisible(false);
		for(int i = 0;i<9;i++) {
			gameButton[i].setVisible(true);
		}
		scoreLabel.setVisible(true);
		timeLabel.setVisible(true);

		Timer.flag = true ;
	}
	
	public void seeRanking() {
		try {
			
			in = new FileReader("Ranking.txt");			
            System.out.print(in.read());
            in.close();	
		} catch (IOException e) {}
	}
	
	public static void gameEnd() {
		gameEndScoreLabel.setText("score : "+Integer.toString(score));
		try {
			char ch =' ';
			out = new FileWriter("Ranking.txt");	
			for(int i = 0;ch == -1;i++) {
			//	ch = String.format("%d",score)[i]

			}
			String.format("%d",score);
			while ((ch = (char)in.read()) != -1) {
			//	Str += ch;
			}
			scores = String.valueOf(in.read());
			System.out.println(scores);
            in.close();	
            
		} catch (IOException e) {
			
		}
		try {	
			out = new FileWriter("Ranking.txt"); 
	        out.write(scores + score);
			out.close();
		} catch (IOException e) {}
		
		score = 0;
		Timer.TimeValue = 5.00;
		Timer.elapsedTime = Timer.TimeValue;
		Timer.flag = false ;
		for(int i = 0;i<9;i++) {
			gameButton[i].setVisible(false);
		}
		scoreLabel.setVisible(false);
		timeLabel.setVisible(false);
		gameEndLabel.setVisible(true);
		gameEndScoreLabel.setVisible(true);
		restartButton.setVisible(true);
		goTitleButton.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Game Start button activation
		if(e.getActionCommand().equals("Game Start")){
			gameStart();
		}
		// See Ranking button activation
		else if(e.getActionCommand().equals("See Ranking")){
			seeRanking();
		}
		// Exit button activation
		else if(e.getActionCommand().equals("Exit")){
			System.exit(0);
		}
		// Restart button activation
		else if(e.getActionCommand().equals("Restart")){
			gameEndLabel.setVisible(false);
			gameEndScoreLabel.setVisible(false);
			restartButton.setVisible(false);
			goTitleButton.setVisible(false);
			
			for(int i = 0;i<9;i++) {
				gameButton[i].setVisible(true);
			}
			scoreLabel.setVisible(true);
			timeLabel.setVisible(true);
			Timer.flag = true ;
		}
		// Go Title button activation
		else if(e.getActionCommand().equals("Go Title")){
			gameEndLabel.setVisible(false);
			gameEndScoreLabel.setVisible(false);
			restartButton.setVisible(false);
			goTitleButton.setVisible(false);
			
			titleLabel.setVisible(true);
			startButton.setVisible(true);
			seeRankingButton.setVisible(true);
			exitButton.setVisible(true);	
		}
		// Game button activation
		else {
			// Game Button number check
			int i;
			for(i=0 ; i<gameButton.length ; i++) {
				if(e.getActionCommand().equals(gameButton[i].getActionCommand())) {
					break;
				}
			}
			// Game Button activation setting
			if(i == ran){
				Timer.flag = false ;
				score++;
				scoreLabel.setText("score : "+Integer.toString(score));
				gameButton[i].setBackground(Color.WHITE);
				gameButton[i].setForeground(Color.WHITE);
				ran = (int)(Math.random()*9);
				timeLabel.setBounds((ran%3)*128+53,(ran/3)*128+61,70,10);
				gameButton[ran].setForeground(Color.BLACK);
				gameButton[ran].setBackground(Color.BLACK);
				Timer.elapsedTime = Timer.TimeValue;
				if(Timer.TimeValue>0.5) {
					Timer.TimeValue -= 0.1;
				}
				Timer.flag = true ;
			}
		}
	}
}

class Timer extends Thread {
	public static double TimeValue = 5.00;
	public static double elapsedTime = TimeValue;
	public static Boolean flag = false;
	
	public Timer(){
		start();
	}
	public void run() {
		while(true) {
			if(flag) {
				elapsedTime -= 0.01;
				mainFrame.timeLabel.setText(String.format("%.2f", elapsedTime));
				mainFrame.timeLabel.setForeground(Color.WHITE);
				if(elapsedTime < 0) {
					mainFrame.gameEnd();
				}
			}try {
				sleep(10);
			}catch (InterruptedException e) {
				System.out.println("InterruptedException!");
			}
			
		}			
	}
}

public class _1 {
	public static void main(String[] args) {
		new mainFrame();
		new Timer();
	}

}
