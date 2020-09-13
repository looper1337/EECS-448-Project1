import java.util.Scanner;

public class Run
{
    /**
     * This is the main function and it does a lot. 
     * The first thing it does is sets up all of our variables and then asks how many ships there should be. 
     * Then it asks where the ships should be located and takes in input from the players. Since the columns
     * are chars, it then calls our second function(chartonum) that converts the char to an int. It also asks
     * if the player would like ships to be horizontal or vertical if there is more than one ship. This function also handles
     * error handling for incorrect player input.
     * It does these things for both players and also handles printing the maps. It also allows for the players to guess
     * positions for the enemy and handles printing game data for when the game is ended.
     * @param String[] args
     * @return It is void so returns nothing!
     */
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        //general var
        char[] coor={'%','A','B','C','D','E','F','G','H','I'};
        int block=0;
        int des=0;
        int ShipNum=0;
        //player1 var
        
        int ship[][]=new int [105][105];
        int shot[][]=new int [105][105];
        int p1hit=0;
        int p1miss=0;
        int row1=0;
        char string1;
        int col1=0;
        //player2 var
        
        int ship2[][]=new int [105][105];
        int shot2[][]=new int [105][105];
        int p2hit=0;
        int p2miss=0;
        int row2=0;
        char string2;
        int col2=0;
        
        
        //Started set
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                ship[i][j]=0;
                ship2[i][j]=0;
                shot[i][j]=0;
                shot2[i][j]=0;
            }
        }
        do
        {
        System.out.println("Players, please select the number of ships(1-5)");
        ShipNum=s.nextInt();
        if (ShipNum<1||ShipNum>5)
        {
            System.out.println("Invalid number, try again");
        }
        }while(ShipNum<1||ShipNum>5);

        for (int d=1;d<=ShipNum;d++) // the goal
        {
            des=des+d;
        }
//-----------------------------------------------------------------------------------------------------------------
        //player1 started
        //place ship player1
        System.out.println("Player 1's turn");
        for (int x=1;x<=ShipNum;x++)
        {
            if(x==1) //ship size = 1
            {
                do
                {
                    System.out.print("Enter the position of your 1*");
                    System.out.print(x);
                    System.out.println(" ship (row(1-9) and col(A-I))");
                    row1=s.nextInt();
                    string1=s.next().charAt(0);
                    col1 = chartonum(string1);
                    if(row1<1||row1>9||col1<1||col1>9)
                    {
                        System.out.println("Invalid Position, try again.");
                    }
                    else
                    {
                        for (int a=row1;a<=row1;a++)
                        {
                            for (int b=col1;b<=col1;b++)
                            {
                                ship[a][b]=ship[a][b]+1;                       
                            }
                        }
                    }
                }while (row1<1||row1>9||col1<1||col1>9);
            }
            
            else //ship size > 1*1
            {
                do
                {
                    do
                    {
                        block=0;
                        System.out.print("Enter the position of your 1*");
                        System.out.print(x);
                        System.out.println(" ship (row(1-9) and col(A-I))");
                        row1=s.nextInt();
                        string1=s.next().charAt(0);
                        col1 = chartonum(string1);
                        int re=0;
                        if(row1<1||row1>9||col1<1||col1>9)
                        {
                            System.out.println("Invalid Position, try again.");
                        }
                        else 
                        {
                            do
                            {
                            re=0;
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
                                        if (ship[a][b-1]==1&&ship[a][b]==2)  //example: 3 ships, 1*1 in (3,3), 1*2 in (3,1),(3,2),if placed 1*3 ship in (3,2)
                                        {
                                            block=1;
                                            ship[a][b]=ship[a][b]-1;
                                            ship[a][b-1]=0;
                                            System.out.println("Invalid Position, try again.");
                                            break;
                                        }
                                        else if(ship[a][b]==2)
                                        {
                                            block=1;
                                            System.out.println("Invalid Position, try again.");
                                            ship[a][b]=ship[a][b]-1;
                                            ship[a][b-1]=0;
                                            break;
                                        }
                                        else if(col1+x>10)
                                        {
                                            block=1;
                                            ship[a][b]=0;
                                            System.out.println("Invalid Position, try again.");
                                            break;
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
                                        if(ship[a-1][b]==1&&ship[a][b]==2)//example: 3 ships, 1*1 in (3,3), 1*2 in (1,3),(2,3),if placed 1*3 ship in (2,3)
                                        {
                                            block=1;
                                            ship[a][b]=ship[a][b]-1;
                                            ship[a-1][b]=0;
                                            System.out.println("Invalid Position, try again.");
                                        } 
                                        else if(ship[a][b]==2)
                                        {
                                            block=1;
                                            System.out.println("Invalid Position, try again.");
                                            ship[a][b]=ship[a][b]-1;
                                            ship[a-1][b]=0;
                                        }
                                        else if (row1+x>10)
                                        {
                                            block=1;
                                            ship[a][b]=0;
                                            System.out.println("Invalid Position, try again.");
                                        }                
                                    }
                                    if(block==1)
                                    {
                                        break;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Invalid type, try again.");
                                re=1;
                            }
                            }while(re==1);
                        }
                    }while(row1<1||row1>9||col1<1||col1>9);
                }while(block==1);
            }
        }

        //print map for player-----------------------------------------------------
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
                System.out.print("~  ");
                }
 			
			}
			System.out.println();
		}
//------------------------------------------------------------------------------------
        //player2 started
        //place ship player2
        System.out.println("Player 2's turn");
        for (int x=1;x<=ShipNum;x++)
        {
            if(x==1) //ship size = 1
            {
                do
                {    
                    System.out.print("Enter the position of your 1*");
                    System.out.print(x);
                    System.out.println(" ship (row(1-9) and col(A-I))");
                    row2=s.nextInt();
                    string2=s.next().charAt(0);
                    col2 = chartonum(string2);
                    if(row2<1||row2>9||col2<1||col2>9)
                    {
                        System.out.println("Invalid Position, try again.");
                    }
                    for (int a=row2;a<=row2;a++)
                    {
                        for (int b=col2;b<=col2;b++)
                        {
                            ship2[a][b]=ship2[a][b]+1;                       
                        }
                    }
                }while(row2<1||row2>9||col2<1||col2>9);
            }
            else //ship size > 1*1
            {
                do
                {
                    do
                    {
                        block=0;
                        System.out.print("Enter the position of your 1*");
                        System.out.print(x);
                        System.out.println(" ship (row(1-9) and col(A-I))");
                        row2=s.nextInt();
                        string2=s.next().charAt(0);
                        col2 = chartonum(string2);
                        int re2=0;
                        if(row2<1||row2>9||col2<1||col2>9)
                        {
                            System.out.println("Invalid Position, try again.");
                        }
                        else
                        {
                            do
                            {
                            //ships can only extend to right or bot, (1=horizontal, 2=vertical)
                            re2=0;
                            System.out.println("Choose the type of your ship(1.Hor or 2.Ver)");
                            int type2=s.nextInt();
                            if (type2==1)
                            {
                                for (int a=row2;a<=row2;a++)
                                {
                                    for (int b=col2;b<=col2+x-1;b++)
                                    {
                                        ship2[a][b]=ship2[a][b]+1;
                                        if (ship2[a][b-1]==1&&ship2[a][b]==2)  //example: 3 ships, 1*1 in (3,3), 1*2 in (3,1),(3,2),if placed 1*3 ship in (3,2)
                                        {
                                            block=1;
                                            ship2[a][b]=ship2[a][b]-1;
                                            ship2[a][b-1]=0;
                                            System.out.println("Invalid Position, try again.");
                                            break;
                                        }
                                        else if(ship2[a][b]==2)
                                        {
                                            block=1;
                                            System.out.println("Invalid Position, try again.");
                                            ship2[a][b]=ship2[a][b]-1;
                                            ship2[a][b-1]=0;
                                            break;
                                        }
                                        else if(col2+x > 10)
                                        {
                                            block=1;
                                            ship2[a][b]=0;
                                            System.out.println("Invalid Position, try again.");
                                            break;
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
                                        if(ship2[a-1][b]==1&&ship2[a][b]==2)//example: 3 ships, 1*1 in (3,3), 1*2 in (1,3),(2,3),if placed 1*3 ship in (2,3)
                                        {
                                            block=1;
                                            ship2[a][b]=ship2[a][b]-1;
                                            ship2[a-1][b]=0;
                                            System.out.println("Invalid Position, try again.");
                                        } 
                                        else if(ship2[a][b]==2)
                                        {
                                            block=1;
                                            System.out.println("Invalid Position, try again.");
                                            ship2[a][b]=ship2[a][b]-1;
                                            ship2[a-1][b]=0;
                                        }
                                        else if (row2+x>10)
                                        {
                                            block=1;
                                            ship2[a][b]=0;
                                            System.out.println("Invalid Position, try again.");
                                        }                
                                    }
                                    if(block==1)
                                    {
                                        break;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("Invalid type, try again.");
                                re2=1;
                            }
                            }while(re2==1);
                        }
                    }while(row2<1||row2>9||col2<1||col2>9);
                }while(block==1);
            }
        }

        //print map for player---------------------------------------------------------
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
                System.out.print("~  ");
                }
 			
			}
			System.out.println();
		}



    for(int stop=0;stop<99;stop++)
    {
        stop=0;
//--------------------------------------------------------------------------------
    //player1's turned to shoot
    //shot
    System.out.println("P1, Enter the position you want to shoot (row(1-9) and col(A-1)) ");
    int p1r=s.nextInt(); //p1 shot row
    string1=s.next().charAt(0);
    int p1c = chartonum(string1);
    for (int x=p1r;x<=p1r;x++)
    {
        for (int y=p1c;y<=p1c;y++)
        {
            shot[x][y]=1;
        }
    }
        
        // print p2'map after attacked by p1
        p1hit=0;
        p1miss=0;
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
                else if(ship2[i][j]==1 & shot[i][j]==1)
                {
                    System.out.print("H  ");    
                    p1hit=p1hit+1;                
                }
                else if(ship2[i][j]!=1&shot[i][j]==1)
                {
                    System.out.print("M  ");       
                    p1miss=p1miss+1;             
                }
                else
                {
                    System.out.print("~  ");
                }
 			
			}
			System.out.println();
		}
        System.out.println();
//----------------------------------------------------------------------------------------------------
    //player2's turned to shoot
    //shoot
        if(p1hit!=des)
        {
            System.out.println("P2, enter the position you want to shoot (row(1-9) and col(A-I)) ");
            int p2r=s.nextInt(); //p2 shoot row
            string2=s.next().charAt(0);
            int p2c = chartonum(string2);
            for (int x=p2r;x<=p2r;x++)
            {
                for (int y=p2c;y<=p2c;y++)
                {
                    shot2[x][y]=1;
                }
            }
            
            // print p1'map after attacked by p2
            p2hit=0;
            p2miss=0;
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
                        System.out.print("H  ");
                        p2hit=p2hit+1;
                                        
                    }
                    else if(ship[i][j]!=1 & shot2[i][j]==1)
                    {
                        System.out.print("M  ");
                        p2miss=p2miss+1;
                    }
                    else
                    {
                        System.out.print("~  ");
                    }
                
                }
                System.out.println();
            }
            System.out.println();
            if(p2hit==des)
            {
                break;
            }
        }
        else if(p1hit==des)
        {
            break;
        }
    }
//-------------------------------------------------------------------------------------- 
        if(p1hit==des)
        {
            System.out.println("Player 1 wins, game over.");
        }
        else if (p2hit==des)
        {
            System.out.println("Player 2 wins, game over.");
        }

    System.out.println("Game Summary");
    System.out.println("Player 1-----miss: "+ p1miss + "  hit: "+ p1hit);
    System.out.println("Player 2-----miss: "+ p2miss + "  hit: "+ p2hit);
    s.close();
    } 
    /**
     * This function converts a char to an int so that the program can use maps easier. When the player wants to place a ship or shoot
     * the second value is a char that this function converts to its appropriate int on the game board.
     * @param char char1
     * @return int num
     */
    public static int chartonum (char char1)
    {
        int num = 0;
        if(char1 == 'A')
        {
            num = 1;
        }
        else if(char1 == 'B')
        {
            num = 2;
        }
        else if(char1 == 'C')
        {
            num = 3;
        }
        else if(char1 == 'D')
        {
            num = 4;
        }
        else if(char1 == 'E')
        {
            num = 5;
        }
        else if(char1 == 'F')
        {
            num = 6;
        }
        else if(char1 == 'G')
        {
            num = 7;
        }
        else if(char1 == 'H')
        {
            num = 8;
        }
        else if(char1 == 'I')
        {
            num = 9;
        }
        return(num);
    }
}


























