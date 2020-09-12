import java.util.Scanner;

public class Run
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        //general var
        char[] coor={'%','A','B','C','D','E','F','G','H','I'};
        int block=0;
        int des=0;
        //player1 var
        int map[][]=new int [105][105];
        int ship[][]=new int [105][105];
        int shot[][]=new int [105][105];
        int hit1=0;
        int miss1=0;
        //player2 var
        int map2[][]=new int [105][105];
        int ship2[][]=new int [105][105];
        int shot2[][]=new int [105][105];
        int hit2=0;
        int miss2=0;
        
        
        //Started set
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                map[i][j]=0;
                ship[i][j]=0;
                map[i][j]=0;
                ship[i][j]=0;
            }
        }
        System.out.println("Players, please select the number of ships");
        int ShipNum=s.nextInt();

        for (int i=1;i<=ShipNum;i++) // the goal
        {
            des=des+i;
        }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //player1 started
        //place ship player1
        System.out.println("Player1's turned");
        for (int x=1;x<=ShipNum;x++)
        {
            if(x==1) //ship size = 1
            {
                System.out.print("Enter the position of your 1*");
                System.out.print(x);
                System.out.println(" ship (row and col)");
                int row1=s.nextInt();
                int col1=s.nextInt();
                for (int a=row1;a<=row1;a++)
                {
                    for (int b=col1;b<=col1;b++)
                    {
                        ship[a][b]=ship[a][b]+1;                       
                    }
                }
            }
            else //ship size > 1*1
            {
                do
                {
                    block=0;
                    System.out.print("Enter the position of your 1*");
                    System.out.print(x);
                    System.out.println(" ship (row and col)");
                    int row1=s.nextInt();
                    int col1=s.nextInt();
                    int re=0;
                    do
                    {
                    //ships can only extend to right or bot, (1=horizontal, 2=vertical)
                    System.out.println("Choose the type of your ship(1.Hor or 2.Ver)");
                    int type=s.nextInt();
                    if (type==1)
                    {
                        for (int a=row1;a<=row1;a++)
                        {
                            for (int b=col1;b<=col1+x-1;b++)
                            {
                                ship[a][b]=ship[a][b]+1;
                                if(ship[a][b]==2)
                                {
                                    block=1;
                                    System.out.println("Invalid Position, try again.");
                                    ship[a][b]=ship[a][b]-1;
                                }                      
                            }
                        }
                    }
                    else if (type==2)
                    {
                        for (int a=row1;a<=row1+x-1;a++)
                        {
                            for (int b=col1;b<=col1;b++)
                            {
                                ship[a][b]=ship[a][b]+1;
                                if(ship[a][b]==2)
                                {
                                    block=1;
                                    System.out.println("Invalid Position, try again.");
                                    ship[a][b]=ship[a][b]-1;
                                }                        
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid type, try again.");
                        re=1;
                    }
                    }while(re==1);
                }while(block==1);
            }
        }

        //print map for player
       	for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
                if (i==0&j!=0)
                {
                    System.out.print(coor[j]+"  ");
                }
                else if (j==0&&i!=0)
                {
                    System.out.print(i+"  ");
                }   
                else if(ship[i][j]==1)
                {
                    System.out.print("#  ");
                }
                else
                {
                System.out.print("0  ");
                }
 			
			}
			System.out.println();
		}
//---------------------------------------------------------------------------------------------------------------------------
        //player2 started
        //place ship player2
        System.out.println("Player2's turned");
        for (int x=1;x<=ShipNum;x++)
        {
            if(x==1) //ship size = 1
            {
                System.out.print("Enter the position of your 1*");
                System.out.print(x);
                System.out.println(" ship (row and col)");
                int row2=s.nextInt();
                int col2=s.nextInt();
                for (int a=row2;a<=row2;a++)
                {
                    for (int b=col2;b<=col2;b++)
                    {
                        ship2[a][b]=ship2[a][b]+1;                       
                    }
                }
            }
            else //ship size > 1*1
            {
                do
                {
                    block=0;
                    System.out.print("Enter the position of your 1*");
                    System.out.print(x);
                    System.out.println(" ship (row and col)");
                    int row2=s.nextInt();
                    int col2=s.nextInt();
                    int re2=0;
                    do
                    {
                    //ships can only extend to right or bot, (1=horizontal, 2=vertical)
                    System.out.println("Choose the type of your ship(1.Hor or 2.Ver)");
                    int type2=s.nextInt();
                    if (type2==1)
                    {
                        for (int a=row2;a<=row2;a++)
                        {
                            for (int b=col2;b<=col2+x-1;b++)
                            {
                                ship2[a][b]=ship2[a][b]+1;
                                if(ship2[a][b]==2)
                                {
                                    block=1;
                                    System.out.println("Invalid Position, try again.");
                                    ship2[a][b]=ship2[a][b]-1;
                                }                      
                            }
                        }
                    }
                    else if (type2==2)
                    {
                        for (int a=row2;a<=row2+x-1;a++)
                        {
                            for (int b=col2;b<=col2;b++)
                            {
                                ship2[a][b]=ship2[a][b]+1;
                                if(ship2[a][b]==2)
                                {
                                    block=1;
                                    System.out.println("Invalid Position, try again.");
                                    ship2[a][b]=ship2[a][b]-1;
                                }                        
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid type, try again.");
                        re2=1;
                    }
                    }while(re2==1);
                }while(block==1);
            }
        }

        //print map for player
       	for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
                if (i==0&j!=0)
                {
                    System.out.print(coor[j]+"  ");
                }
                else if (j==0&&i!=0)
                {
                    System.out.print(i+"  ");
                }   
                else if(ship2[i][j]==1)
                {
                    System.out.print("#  ");
                }
                else
                {
                System.out.print("0  ");
                }
 			
			}
			System.out.println();
		}



    do
    {
//---------------------------------------------------------------------------------------------------------
    //player1's turned to shot
    //shot
    System.out.println("P1, Enter the position you want to shot (row and col) ");
    int p1r=s.nextInt(); //p1 shot row
    int p1c=s.nextInt(); //p1 shot col
    for (int x=p1r;x<=p1r;x++)
    {
        for (int y=p1c;y<=p1c;y++)
        {
            shot[x][y]=1;
        }
    }

        // print p2'map after attacked by p1
       	for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
                if (i==0&j!=0)
                {
                    System.out.print(coor[j]+"  ");
                }
                else if (j==0&&i!=0)
                {
                    System.out.print(i+"  ");
                }                
                else if(ship2[i][j]==1&shot[i][j]==1)
                {
                    hit1=hit1+1;
                    System.out.print("X  ");                    
                }
                else if(ship2[i][j]!=1&shot[i][j]==1)
                {
                    miss1=miss1+1;
                    System.out.print("*  ");                    
                }
                else
                {
                    System.out.print("0  ");
                }
 			
			}
			System.out.println();
		}
//----------------------------------------------------------------------------------------------------
    //player2's turned to shot
    //shot
    System.out.println("P2, enter the position you want to shot (row and col) ");
    int p2r=s.nextInt(); //p2 shot row
    int p2c=s.nextInt(); //p2 shot col
    for (int x=p2r;x<=p2r;x++)
    {
        for (int y=p2c;y<=p2c;y++)
        {
            shot2[x][y]=1;
        }
    }

        // print p1'map after attacked by p2
       	for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
                if (i==0&j!=0)
                {
                    System.out.print(coor[j]+"  ");
                }
                else if (j==0&&i!=0)
                {
                    System.out.print(i+"  ");
                }    
                
                else if(ship[i][j]==1 & shot2[i][j]==1)
                {
                    hit2=hit2+1; 
                    System.out.print("X  ");
                                     
                }
                else if(ship[i][j]!=1 & shot2[i][j]==1)
                {
                    miss2=miss2+1; 
                    System.out.print("*  ");
                       
                }
                else
                {
                    System.out.print("0  ");
                }
 			
			}
			System.out.println();
		}
        
        if(hit1==des)
        {
            System.out.println("Player1 wins, gameover.");
        }
        else if (hit2==des)
        {
            System.out.println("Player2 wins, gameover.");
        }
        else if (hit1==hit2&&hit1==des)
        {
            System.out.println("Draw");
        }

    }while(hit1!=des&&hit2!=des);

    System.out.println("Game Summary");
    System.out.println("Player1-----miss: "+ miss1 + "  hit: "+ hit1);
    System.out.println("Player2-----miss: "+ miss2 + "  hit: "+ hit2);

    } 
}


























