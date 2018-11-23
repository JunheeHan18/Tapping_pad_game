package tapping_pad;

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

/*
 *   Pad click Game! 
 * class : mainClass, mainFrame, Timer 
 * function : mainFrame - 	gameStart, 
 * 						-	gameEnd
 * 						-	seeRanking
 * 						-	Exit
 * 
 *			  Timer		-	run 
 */

@SuppressWarnings("serial")
class mainFrame extends JFrame implements ActionListener {
	
	// title element
	public JLabel titleLabel = new JLabel("Tapping-pad Game");
	public JButton startButton = new JButton("Game Start");
	public JButton seeRankingButton = new JButton("See Ranking");
	public JButton exitButton = new JButton("Exit");
	public Font titleFont = new Font("¸¼Àº°íµñ", Font.BOLD, 30);
	public Font textFont = new Font("¸¼Àº°íµñ",Font.BOLD, 20);
 	
	// game element
	static int score = 0;
	static int ran = (int)(Math.random()*9);
	String[] numbers = {"1","2","3","4","5","6","7","8","9"};
	public static JLabel timeLabel = new JLabel();
	public static JLabel scoreLabel = new JLabel("score : "+Integer.toString(score));
	public static JButton[] gameButton = new JButton[9];
	
	// see ranking element
	String strBuffer = null;
	int intBuffer;
	String[] strAryBuffer = null;
	int[] rankNum  = {0, 0, 0};
	public static JLabel seeRankingLabel = new JLabel("Ranking");
	public static JLabel[] rankingLabel = new JLabel[3];
	
	//  game end element
	public static JLabel gameEndLabel = new JLabel("Game Over!!");
	public static JLabel gameEndScoreLabel = new JLabel();
	public static JButton restartButton = new JButton("Restart");
	public static JButton goTitleButton = new JButton("Go Title");
	
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
//		see ranking element setting
//		
		seeRankingLabel.setBounds(140,50,150,50);
		seeRankingLabel.setFont(titleFont);
		for(int i=0 ; i<3 ; i++ ) {
			rankingLabel[i] = new JLabel();
			rankingLabel[i].setBounds(160, 130+i*40, 150, 30);
			rankingLabel[i].setFont(textFont);
		}
		
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
		add(seeRankingLabel);
		for(int i=0;i<3;i++) {
			add(rankingLabel[i]);
		}
		add(gameEndLabel);
		add(gameEndScoreLabel);
		add(restartButton);
		add(goTitleButton);
		for(int i=0;i<9;i++) {
			add(gameButton[i]);
		}
		
//		
//		default display setting
//		
		scoreLabel.setVisible(false);
		timeLabel.setVisible(false);
		seeRankingLabel.setVisible(false);
		for(int i=0;i<3;i++) {
			rankingLabel[i].setVisible(false);
		}
		gameEndLabel.setVisible(false);
		gameEndScoreLabel.setVisible(false);
		restartButton.setVisible(false);
		goTitleButton.setVisible(false);
		for(int i=0;i<9;i++) {
			gameButton[i].setVisible(false);
		}
		
		setVisible(true);
	}
	
//	
//	gameStart Button
//	
	public void gameStart() {
		// Display setting
		titleLabel.setVisible(false);
		startButton.setVisible(false);
		seeRankingButton.setVisible(false);
		exitButton.setVisible(false);
		for(int i = 0;i<9;i++) {
			gameButton[i].setVisible(true);
		}
		scoreLabel.setVisible(true);
		timeLabel.setVisible(true);
		
		// Timer start
		Timer.timerFlag = true ;
	}
	
//	
//	seeRanking Button
//	
	public void seeRanking() {
		// Display setting
		titleLabel.setVisible(false);
		startButton.setVisible(false);
		seeRankingButton.setVisible(false);
		exitButton.setVisible(false);
		
		// Bring ranking file data
		try {
			in = new FileReader("Ranking.txt");	
			strBuffer = "";
			while((intBuffer = in.read()) != -1)
				strBuffer += (char)intBuffer;
            in.close();	
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
		strAryBuffer = strBuffer.split(" ");
		
		// Max value sorting
		for(int i=0;i<strAryBuffer.length;i++) {
			if(rankNum[0] < Integer.parseInt(strAryBuffer[i]))
				rankNum[0] = Integer.parseInt(strAryBuffer[i]);
		}
		for(int i=0;i<strAryBuffer.length;i++) {
			if(rankNum[1] < Integer.parseInt(strAryBuffer[i]) && rankNum[0] > Integer.parseInt(strAryBuffer[i])) 
				rankNum[1] = Integer.parseInt(strAryBuffer[i]);
		}
		for(int i=0;i<strAryBuffer.length;i++) {
			if(rankNum[2] < Integer.parseInt(strAryBuffer[i]) && rankNum[1] > Integer.parseInt(strAryBuffer[i])) 
				rankNum[2] = Integer.parseInt(strAryBuffer[i]);
		}
		
		rankingLabel[0].setText("1st  : "+Integer.toString(rankNum[0]));
		rankingLabel[1].setText("2nd : "+Integer.toString(rankNum[1]));
		rankingLabel[2].setText("3rd  : "+Integer.toString(rankNum[2]));
		
		// Display setting
		seeRankingLabel.setVisible(true);
		for(int i=0;i<3;i++) {
			rankingLabel[i].setVisible(true);
		}
		goTitleButton.setBounds(140, 270, 120, 35);
		goTitleButton.setVisible(true);
	}
	
//	
//	gameEnd function
//	
	public static void gameEnd() {
		
		gameEndScoreLabel.setText("score : "+Integer.toString(score));
		
		// Save game result
		try {
			out = new FileWriter("Ranking.txt", true);	
			out.write(Integer.toString(score)+" ");
            out.close();	
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
		// Data initialization
		score = 0;
		Timer.TimeValue = 5.00;
		Timer.elapsedTime = Timer.TimeValue;
		Timer.timerFlag = false ;
		
		// Display setting
		for(int i = 0;i<9;i++) {
			gameButton[i].setVisible(false);
		}
		scoreLabel.setVisible(false);
		timeLabel.setVisible(false);
		gameEndLabel.setVisible(true);
		gameEndScoreLabel.setVisible(true);
		restartButton.setVisible(true);
		goTitleButton.setBounds(210, 250, 120, 35);
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
			// Display setting
			gameEndLabel.setVisible(false);
			gameEndScoreLabel.setVisible(false);
			restartButton.setVisible(false);
			goTitleButton.setVisible(false);
			for(int i = 0;i<9;i++) {
				gameButton[i].setVisible(true);
			}
			scoreLabel.setVisible(true);
			timeLabel.setVisible(true);
			// Timer Start
			Timer.timerFlag = true ;
		}
		// Go Title button activation
		else if(e.getActionCommand().equals("Go Title")){
			// Display setting
			seeRankingLabel.setVisible(false);
			for(int i=0;i<3;i++) {
				rankingLabel[i].setVisible(false);
			}
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
				Timer.timerFlag = false ;
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
				Timer.timerFlag = true ;
			}
		}
	}
}

class Timer extends Thread {
	public static double TimeValue = 5.00;
	public static double elapsedTime = TimeValue;
	public static Boolean timerFlag = false;
	
	public Timer(){
		start();
	}
	public void run() {
		while(true) {
			if(timerFlag) {
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
