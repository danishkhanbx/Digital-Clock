package DigitalClock;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;

public class Clock extends JFrame
{
	
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;	
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;	
	String time;
	String day;
	String date;
	
	Clock()
	{
		this.setTitle("Digital Clock");        // Frame Title
		this.setSize(350, 200);
		super.setLocation(700,10);           // Window coordinates
		this.setLayout(new FlowLayout());
		this.setResizable(false);          // cannot minimize or maximize
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		timeLabel = new JLabel();	
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayFormat = new SimpleDateFormat("EEEE");
		dayLabel = new JLabel();	
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
		
		dateFormat = new SimpleDateFormat("MMMM dd, Y");
		dateLabel = new JLabel();	
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,35));
		
		this.add(timeLabel);  // adding the explicit labels in the GUI window
		this.add(dayLabel);
		this.add(dateLabel);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTime();  // calling the function
	}
	
	public void setTime()
	{
		while(true)                                                         // till I don't stop it
		{
			time = timeFormat.format(Calendar.getInstance().getTime());    // extracting info from base calendar
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			try                                                   // reassuring that time will increase only by 1 second by making the operation goto sleep
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
				
			}
		}
	}
	
}