package com.example.ultimatetictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
 

@SuppressWarnings("unused")
public class MainActivity extends  Activity {
	public final static String TEXT="com.example.ultimatetictactoe";
	GridView gridView;
	int toggle = 0;
	int row_prev = 0;
	int column_prev = 0;
	int board_number = 0;
	int board_played = 0;
	int rd = 0;
	int cd = 0;
	int r_played = 0;
	int c_played = 0;
	int win_game = 0;
	int[][] array_overall = new int[3][3]; 
	static final String[] status = new String[] { 
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ", 
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " ",
			" ", " ", " ", " ", " "," "};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.activity_main);
 
		gridView = (GridView) findViewById(R.id.board);
 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.grid, status);
 
		gridView.setAdapter(adapter);
 
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
				int position, long id) {
				check_win();
				
				if(win_game == 1)
				{
					Intent intent = new Intent(MainActivity.this,Win.class);
					intent.putExtra(TEXT,"X has won the game");
					startActivity(intent);
				}
				
				if(win_game == 2)
				{
					Intent intent = new Intent(MainActivity.this,Win.class);
					intent.putExtra(TEXT,"O has won the game");
					startActivity(intent);
					
				}
				
				if(win_game ==3)
				{
					Intent intent = new Intent(MainActivity.this,Win.class);
					intent.putExtra(TEXT,"Game drawn");
					startActivity(intent);
				}
				if(board_number == 0)
				{
					if(status[position]!=" ")
					{
						Context context = getApplicationContext();
						CharSequence text = "Position already occupied!";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
						
					}
					
					else
					{
				
					if(toggle == 0)
				
					{
						TextView text = (TextView) v.findViewById(R.id.table);
						text.setTextColor(Color.rgb(255, 0, 0));
						text.setText("X");
					status[position] = " "+ 0;
					}
			   
					if(toggle == 1)
					{
						TextView text = (TextView) v.findViewById(R.id.table);
						text.setTextColor(Color.rgb(0, 255, 0));
								text.setText("O");
				   status[position] = " " + 1;
					}
					if(toggle == 1)
						toggle = 0;
					else
						toggle = 1;
					}
				row_prev = position/9;
				column_prev = position - (row_prev * 9);
				int pos_r = row_prev % 3;
				int pos_c = column_prev % 3;
				if(pos_r == 0 && pos_c == 0)
					board_number = 1;
				else if(pos_r ==0 && pos_c == 1)
					board_number = 2;
				else if(pos_r == 0 && pos_c == 2)
					board_number = 3;
				else if(pos_r == 1 && pos_c == 0)
					board_number = 4;
				else if(pos_r == 1 && pos_c == 1)
					board_number = 5;
				else if(pos_r == 1 && pos_c == 2)
					board_number = 6;
				else if(pos_r == 2 && pos_c == 0)
					board_number = 7;
				else if(pos_r == 2 && pos_c == 1)
					board_number = 8;
				else
					board_number = 9;
				
				
					
				Context context = getApplicationContext();
				CharSequence text = "User to play on Board number:"+board_number;
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();

					
				}
				
				
				
				else
				{
					
				
				rd = position / 9;
				cd = position - (rd * 9);
				r_played = rd/3;
				c_played = cd/3;
				if(r_played == 0 && c_played == 0)
					board_played = 1;
				else if(r_played ==0 && c_played == 1)
					board_played = 2;
				else if(r_played == 0 && c_played == 2)
					board_played = 3;
				else if(r_played == 1 && c_played == 0)
					board_played = 4;
				else if(r_played == 1 && c_played == 1)
					board_played = 5;
				else if(r_played == 1 && c_played == 2)
					board_played = 6;
				else if(r_played == 2 && c_played == 0)
					board_played = 7;
				else if(r_played == 2 && c_played == 1)
					board_played = 8;
				else
					board_played = 9;
				
				
				if(board_number != board_played)
				{
					Context context = getApplicationContext();
					CharSequence text = "Play only on Board number:"+board_number;
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();

				}
				
				
				else
				{
					if(status[position]!=" ")
					{
						Context context = getApplicationContext();
						CharSequence text = "Position already occupied!";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
						
					}
					
					else
					{
				
					if(toggle == 0)
				
					{
						TextView text = (TextView) v.findViewById(R.id.table);
						text.setTextColor(Color.rgb(255, 0, 0));
						text.setText("X");
					status[position] = " " + 0;
					}
			   
					if(toggle == 1)
					{
						TextView text = (TextView) v.findViewById(R.id.table);
						text.setTextColor(Color.rgb(0, 255, 0));
						text.setText("O");
				   
				   status[position] = " " + 1;
					}
					if(toggle == 1)
						toggle = 0;
					else
						toggle = 1;
					}
				row_prev = position/9;
				column_prev = position - (row_prev * 9);
				int pos_r = row_prev % 3;
				int pos_c = column_prev % 3;
				if(pos_r == 0 && pos_c == 0)
					board_number = 1;
				else if(pos_r ==0 && pos_c == 1)
					board_number = 2;
				else if(pos_r == 0 && pos_c == 2)
					board_number = 3;
				else if(pos_r == 1 && pos_c == 0)
					board_number = 4;
				else if(pos_r == 1 && pos_c == 1)
					board_number = 5;
				else if(pos_r == 1 && pos_c == 2)
					board_number = 6;
				else if(pos_r == 2 && pos_c == 0)
					board_number = 7;
				else if(pos_r == 2 && pos_c == 1)
					board_number = 8;
				else
					board_number = 9;
				
				int row = (board_number-1)/3;
				int column = (board_number-1) - (row * 3) ;
				
				if(array_overall[row][column] != 0)
				{
					board_number = 0;
					Context context = getApplicationContext();
					CharSequence text = "Play on any board";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();

				}
				
				
					
				Context context = getApplicationContext();
				String text = new String();
				if(toggle == 0)
					text = "User X to play on Board number:"+board_number;
				if(toggle == 1)
					text = "User O to play on Board number:"+board_number;
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				if(array_overall[0][0] == 0)
					check_board1();
				if(array_overall[0][1] == 0)
					check_board2();
				if(array_overall[0][2] == 0)
					check_board3();
				if(array_overall[1][0] == 0)
					check_board4();
				if(array_overall[1][1] == 0)
					check_board5();
				if(array_overall[1][2] == 0)
					check_board6();
				if(array_overall[2][0] == 0)
					check_board7();
				if(array_overall[2][1] == 0)
					check_board8();
				if(array_overall[2][2] == 0)
					check_board9();
				check_win();
				
				 row = (board_number-1)/3;
				 column = (board_number-1) - (row * 3) ;
				
				if(array_overall[row][column] != 0)
				{
					board_number = 0;
					Context context1 = getApplicationContext();
					CharSequence text1 = "Play on any board";
					int duration1 = Toast.LENGTH_SHORT;

					Toast toast1 = Toast.makeText(context1, text1, duration1);
					toast1.show();

				}
				
				if(win_game == 1)
				{
					Intent intent = new Intent(MainActivity.this,Win.class);
					intent.putExtra(TEXT,"X has won the game");
					startActivity(intent);
				}
				
				if(win_game == 2)
				{
					Intent intent = new Intent(MainActivity.this,Win.class);
					intent.putExtra(TEXT,"O has won the game");
					startActivity(intent);
					
				}
				
				if(win_game ==3)
				{
					Intent intent = new Intent(MainActivity.this,Win.class);
					intent.putExtra(TEXT,"Game drawn");
					startActivity(intent);
				}
				
				
				
			}}}
		});
 
	}
	
	void check_board1()
	{
		String[][] array_board = new String[3][3];
		array_board[0][0] = status[0];
		array_board[0][1] = status[1];
		array_board[0][1] = status[2];
		array_board[1][0] = status[9];
		array_board[1][1] = status[10];
		array_board[1][2] = status[11];
		array_board[2][0] = status[18];
		array_board[2][1] = status[19];
		array_board[2][2] = status[20];
		int win;
		win = 0;
		int condition=0;
		
		if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=1;
			}

		else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
		{
			win = 1;
			condition=2;
		}
		
		else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
		{
			win = 1;
			condition=3;
		}
		
		else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=4;
		}
		
		else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
		{
			win = 1;
			condition=5;
		}
		
		else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=6;
		}
		else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=7;
		}
		else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=8;
		}
		else
		{
			win = 0;
			condition = 0;
		}
		
		if(win == 1)
		{
			if((condition==1)&&(array_board[0][0]==" " +0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==1)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			if((condition==8)&&(array_board[0][2]==" " + 0))
			{
				array_overall[0][0] = 1;
			}
			
			if((condition==8)&&(array_board[0][2]==" " + 1))
			{
				array_overall[0][0] = 2;
			}
			
		}
		
		else
		{
			if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
				array_overall[0][0] = 3;
		}
		
	}
	
	void check_board2()
	{
		String[][] array_board = new String[3][3];
		array_board[0][0] = status[3];
		array_board[0][1] = status[4];
		array_board[0][1] = status[5];
		array_board[1][0] = status[12];
		array_board[1][1] = status[13];
		array_board[1][2] = status[14];
		array_board[2][0] = status[21];
		array_board[2][1] = status[22];
		array_board[2][2] = status[23];
		int win;
		win = 0;
		int condition=0;
		
		if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=1;
			}

		else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
		{
			win = 1;
			condition=2;
		}
		
		else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
		{
			win = 1;
			condition=3;
		}
		
		else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=4;
		}
		
		else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
		{
			win = 1;
			condition=5;
		}
		
		else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=6;
		}
		else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=7;
		}
		else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=8;
		}
		if(win == 1)
		{
			if((condition==1)&&(array_board[0][0]==" "+ 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==1)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			if((condition==8)&&(array_board[0][2]==" " + 0))
			{
				array_overall[0][1] = 1;
			}
			
			if((condition==8)&&(array_board[0][2]==" " + 1))
			{
				array_overall[0][1] = 2;
			}
			
		}
		
		else
		{
			if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
				array_overall[0][1] = 3;
		}
		
		
	}
 
	void check_board3()
	{
		String[][] array_board = new String[3][3];
		array_board[0][0] = status[6];
		array_board[0][1] = status[7];
		array_board[0][1] = status[8];
		array_board[1][0] = status[15];
		array_board[1][1] = status[16];
		array_board[1][2] = status[17];
		array_board[2][0] = status[24];
		array_board[2][1] = status[25];
		array_board[2][2] = status[26];
		int win;
		win=0;
		int condition=0;
		
		if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=1;
			}

		else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
		{
			win = 1;
			condition=2;
		}
		
		else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
		{
			win = 1;
			condition=3;
		}
		
		else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=4;
		}
		
		else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
		{
			win = 1;
			condition=5;
		}
		
		else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=6;
		}
		else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=7;
		}
		else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=8;
		}
		if(win == 1)
		{
			if((condition==1)&&(array_board[0][0]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==1)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			if((condition==8)&&(array_board[0][2]==" " + 0))
			{
				array_overall[0][2] = 1;
			}
			
			if((condition==8)&&(array_board[0][2]==" " + 1))
			{
				array_overall[0][2] = 2;
			}
			
		}
		
		else
		{
			if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
				array_overall[0][2] = 3;
		}
		
		
	}


	void check_board4()
	{
		String[][] array_board = new String[3][3];
		array_board[0][0] = status[27];
		array_board[0][1] = status[28];
		array_board[0][1] = status[29];
		array_board[1][0] = status[36];
		array_board[1][1] = status[37];
		array_board[1][2] = status[38];
		array_board[2][0] = status[45];
		array_board[2][1] = status[46];
		array_board[2][2] = status[47];
		int win;
		win = 0;
		int condition=0;
		
		if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=1;
			}

		else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
		{
			win = 1;
			condition=2;
		}
		
		else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
		{
			win = 1;
			condition=3;
		}
		
		else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=4;
		}
		
		else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
		{
			win = 1;
			condition=5;
		}
		
		else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=6;
		}
		else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=7;
		}
		else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=8;
		}
		if(win == 1)
		{
			if((condition==1)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==1)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			if((condition==8)&&(array_board[0][2]==" " + 0))
			{
				array_overall[1][0] = 1;
			}
			
			if((condition==8)&&(array_board[0][2]==" " + 1))
			{
				array_overall[1][0] = 2;
			}
			
		}		
		else
		{
			if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
				array_overall[1][0] = 3;
		}
		
		
	}
	
	
	void check_board5()
	{
		String[][] array_board = new String[3][3];
		array_board[0][0] = status[30];
		array_board[0][1] = status[31];
		array_board[0][1] = status[32];
		array_board[1][0] = status[39];
		array_board[1][1] = status[40];
		array_board[1][2] = status[41];
		array_board[2][0] = status[48];
		array_board[2][1] = status[49];
		array_board[2][2] = status[50];
		int win;
		win = 0;
		int condition=0;
		
		if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=1;
			}

		else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
		{
			win = 1;
			condition=2;
		}
		
		else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
		{
			win = 1;
			condition=3;
		}
		
		else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=4;
		}
		
		else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
		{
			win = 1;
			condition=5;
		}
		
		else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=6;
		}
		else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=7;
		}
		else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=8;
		}
		
		if(win == 1)
		{
			if((condition==1)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==1)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			if((condition==8)&&(array_board[0][2]==" " + 0))
			{
				array_overall[1][1] = 1;
			}
			
			if((condition==8)&&(array_board[0][2]==" " + 1))
			{
				array_overall[1][1] = 2;
			}
			
		}
		
		else
		{
			if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
				array_overall[1][1] = 3;
		}
		
		
	}

	
	void check_board6()
	{
		String[][] array_board = new String[3][3];
		array_board[0][0] = status[33];
		array_board[0][1] = status[34];
		array_board[0][1] = status[35];
		array_board[1][0] = status[42];
		array_board[1][1] = status[43];
		array_board[1][2] = status[44];
		array_board[2][0] = status[51];
		array_board[2][1] = status[52];
		array_board[2][2] = status[53];
		int win;
		win = 0;
		int condition=0;
		
		if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=1;
			}

		else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
		{
			win = 1;
			condition=2;
		}
		
		else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
		{
			win = 1;
			condition=3;
		}
		
		else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=4;
		}
		
		else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
		{
			win = 1;
			condition=5;
		}
		
		else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=6;
		}
		else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
		{
			win = 1;
			condition=7;
		}
		else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
		{
			win = 1;
			condition=8;
		}
		if(win == 1)
		{
			if((condition==1)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==1)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==2)&&(array_board[1][0]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==3)&&(array_board[2][0]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==4)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==5)&&(array_board[0][1]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==6)&&(array_board[0][2]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==7)&&(array_board[0][0]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			if((condition==8)&&(array_board[0][2]==" " + 0))
			{
				array_overall[1][2] = 1;
			}
			
			if((condition==8)&&(array_board[0][2]==" " + 1))
			{
				array_overall[1][2] = 2;
			}
			
		}
		else
		{
			if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
				array_overall[1][2] = 3;
		}
	}
		
		
		void check_board7()
		{
			String[][] array_board = new String[3][3];
			array_board[0][0] = status[54];
			array_board[0][1] = status[55];
			array_board[0][1] = status[56];
			array_board[1][0] = status[63];
			array_board[1][1] = status[64];
			array_board[1][2] = status[65];
			array_board[2][0] = status[72];
			array_board[2][1] = status[73];
			array_board[2][2] = status[74];
			int win = 0;
			int condition=0;
			
			if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
				{
					win = 1;
					condition=1;
				}

			else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
			{
				win = 1;
				condition=2;
			}
			
			else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
			{
				win = 1;
				condition=3;
			}
			
			else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=4;
			}
			
			else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
			{
				win = 1;
				condition=5;
			}
			
			else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
			{
				win = 1;
				condition=6;
			}
			else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=7;
			}
			else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
			{
				win = 1;
				condition=8;
			}
			
			if(win == 1)
			{
				if((condition==1)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==1)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				
				if((condition==2)&&(array_board[1][0]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==2)&&(array_board[1][0]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				
				if((condition==3)&&(array_board[2][0]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==3)&&(array_board[2][0]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				
				if((condition==4)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==4)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				
				if((condition==5)&&(array_board[0][1]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==5)&&(array_board[0][1]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				
				if((condition==6)&&(array_board[0][2]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==6)&&(array_board[0][2]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				
				if((condition==7)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==7)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				if((condition==8)&&(array_board[0][2]==" " + 0))
				{
					array_overall[2][0] = 1;
				}
				
				if((condition==8)&&(array_board[0][2]==" " + 1))
				{
					array_overall[2][0] = 2;
				}
				
			}
			
			else
			{
				if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
					array_overall[2][0] = 3;
			}
			
	}
		
		
		void check_board8()
		{
			String[][] array_board = new String[3][3];
			array_board[0][0] = status[57];
			array_board[0][1] = status[58];
			array_board[0][1] = status[59];
			array_board[1][0] = status[66];
			array_board[1][1] = status[67];
			array_board[1][2] = status[68];
			array_board[2][0] = status[75];
			array_board[2][1] = status[76];
			array_board[2][2] = status[77];
			int win = 0;
			int condition=0;
			
			if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
				{
					win = 1;
					condition=1;
				}

			else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
			{
				win = 1;
				condition=2;
			}
			
			else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
			{
				win = 1;
				condition=3;
			}
			
			else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=4;
			}
			
			else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
			{
				win = 1;
				condition=5;
			}
			
			else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
			{
				win = 1;
				condition=6;
			}
			else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=7;
			}
			else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
			{
				win = 1;
				condition=8;
			}
			if(win == 1)
			{
				if((condition==1)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==1)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				
				if((condition==2)&&(array_board[1][0]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==2)&&(array_board[1][0]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				
				if((condition==3)&&(array_board[2][0]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==3)&&(array_board[2][0]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				
				if((condition==4)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==4)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				
				if((condition==5)&&(array_board[0][1]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==5)&&(array_board[0][1]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				
				if((condition==6)&&(array_board[0][2]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==6)&&(array_board[0][2]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				
				if((condition==7)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==7)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				if((condition==8)&&(array_board[0][2]==" " + 0))
				{
					array_overall[2][1] = 1;
				}
				
				if((condition==8)&&(array_board[0][2]==" " + 1))
				{
					array_overall[2][1] = 2;
				}
				
			}
			else
			{
				if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
					array_overall[2][1] = 3;
			}
			
	}
		
		void check_board9()
		{
			String[][] array_board = new String[3][3];
			array_board[0][0] = status[60];
			array_board[0][1] = status[61];
			array_board[0][1] = status[62];
			array_board[1][0] = status[69];
			array_board[1][1] = status[70];
			array_board[1][2] = status[71];
			array_board[2][0] = status[78];
			array_board[2][1] = status[79];
			array_board[2][2] = status[80];
			int win = 0;
			int condition=0;
			
			if((array_board[0][0] == array_board[0][1])&&(array_board[0][1] == array_board[0][2])&&(array_board[0][0]!=" "))
				{
					win = 1;
					condition=1;
				}

			else if ((array_board[1][0] == array_board[1][1])&&(array_board[1][1] == array_board[1][2])&&(array_board[1][0]!=" "))
			{
				win = 1;
				condition=2;
			}
			
			else if ((array_board[2][0] == array_board[2][1])&&(array_board[2][1] == array_board[2][2])&&(array_board[2][0]!=" "))
			{
				win = 1;
				condition=3;
			}
			
			else if ((array_board[0][0] == array_board[1][0])&&(array_board[1][0] == array_board[2][0])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=4;
			}
			
			else if ((array_board[0][1] == array_board[1][1])&&(array_board[1][1] == array_board[2][1])&&(array_board[0][1]!=" "))
			{
				win = 1;
				condition=5;
			}
			
			else if ((array_board[0][2] == array_board[1][2])&&(array_board[1][2] == array_board[2][2])&&(array_board[0][2]!=" "))
			{
				win = 1;
				condition=6;
			}
			else if ((array_board[0][0] == array_board[1][1])&&(array_board[1][1] == array_board[2][2])&&(array_board[0][0]!=" "))
			{
				win = 1;
				condition=7;
			}
			else if ((array_board[0][2] == array_board[1][1])&&(array_board[1][1] == array_board[2][0])&&(array_board[0][2]!=" "))
			{
				win = 1;
				condition=8;
			}
			if(win == 1)
			{
				if((condition==1)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==1)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				
				if((condition==2)&&(array_board[1][0]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==2)&&(array_board[1][0]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				
				if((condition==3)&&(array_board[2][0]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==3)&&(array_board[2][0]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				
				if((condition==4)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==4)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				
				if((condition==5)&&(array_board[0][1]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==5)&&(array_board[0][1]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				
				if((condition==6)&&(array_board[0][2]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==6)&&(array_board[0][2]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				
				if((condition==7)&&(array_board[0][0]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==7)&&(array_board[0][0]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				if((condition==8)&&(array_board[0][2]==" " + 0))
				{
					array_overall[2][2] = 1;
				}
				
				if((condition==8)&&(array_board[0][2]==" " + 1))
				{
					array_overall[2][2] = 2;
				}
				
			}
			else
			{
				if((array_board[0][0]!=" ")&&(array_board[0][1]!=" ")&&(array_board[0][2]!=" ")&&(array_board[1][0]!=" ")&&(array_board[1][1]!=" ")&&(array_board[1][2]!=" ")&&(array_board[2][0]!=" ")&&(array_board[2][1]!=" ")&&(array_board[2][2]!=" "))
					array_overall[2][2] = 3;
			}
			
	}
		
		void check_win()
		{
			if((array_overall[0][0]==1)&&(array_overall[0][1]==1)&&(array_overall[0][2]==1))
				win_game = 1;
			if((array_overall[0][0]==2)&&(array_overall[0][1]==2)&&(array_overall[0][2]==2))
				win_game = 2;
			if((array_overall[1][0]==1)&&(array_overall[1][1]==1)&&(array_overall[1][2]==1))
				win_game = 1;
			if((array_overall[1][0]==2)&&(array_overall[1][1]==2)&&(array_overall[1][2]==2))
				win_game = 2;
			if((array_overall[2][0]==1)&&(array_overall[2][1]==1)&&(array_overall[2][2]==1))
				win_game = 1;
			if((array_overall[2][0]==2)&&(array_overall[2][1]==2)&&(array_overall[2][2]==2))
				win_game = 2;
			if((array_overall[0][0]==1)&&(array_overall[1][0]==1)&&(array_overall[2][0]==1))
				win_game = 1;
			if((array_overall[0][0]==2)&&(array_overall[1][0]==2)&&(array_overall[2][0]==2))
				win_game = 2;
			if((array_overall[0][1]==1)&&(array_overall[1][1]==1)&&(array_overall[2][1]==1))
				win_game = 1;
			if((array_overall[0][1]==2)&&(array_overall[1][1]==2)&&(array_overall[2][1]==2))
				win_game = 2;
			if((array_overall[0][2]==1)&&(array_overall[1][2]==1)&&(array_overall[2][2]==1))
				win_game = 1;
			if((array_overall[0][2]==2)&&(array_overall[1][2]==2)&&(array_overall[2][2]==2))
				win_game = 2;
			if((array_overall[0][0]==1)&&(array_overall[1][1]==1)&&(array_overall[2][2]==1))
				win_game = 1;
			if((array_overall[0][0]==2)&&(array_overall[1][1]==2)&&(array_overall[2][2]==2))
				win_game = 2;
			if((array_overall[0][2]==1)&&(array_overall[1][1]==1)&&(array_overall[2][0]==1))
				win_game = 1;
			if((array_overall[0][2]==2)&&(array_overall[1][1]==2)&&(array_overall[2][0]==2))
				win_game = 2;
			
			int empty;
			empty = 0;
			for(int i=0;i<81;i++)
			{
				if(status[i] == " ")
					empty = 1;
			}
			if(empty == 0)
				win_game = 3;
				
			
			
			
			
		}
		
		
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
