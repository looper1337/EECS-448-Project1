import java.util.Scanner;

public class Run
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        //player1 var
        int map[][]=new int [105][105];
        int ship[][]=new int [105][105];
        int shot[][]=new int [105][105];
        int hit1=0;
        int miss1=0;
        int des1=0;
        //player2 var
        int map2[][]=new int [105][105];
        int ship2[][]=new int [105][105];
        int shot2[][]=new int [105][105];
        int hit2=0;
        int miss2=0;
        int des2=0;
        
        
        //player1 started
        for(int i=1;i<10;i++)
        {
            for(int j=1;j<10;j++)
            {
                map[i][j]=0;
                ship[i][j]=0;
            }
        }
        System.out.println("Please select the number of ships");
        int ShipNum=s.nextInt();

        //place ship player1
        for (int x=1;x<=ShipNum;x++)
        {
            System.out.print("Enter the position of your 1*");
            System.out.print(x);
            System.out.println(" ship (row and col)");
            if(x==1) //ship size = 1
            {
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
                            for (int b=col1;b<=col1+ShipNum-1;b++)
                            {
                                ship[a][b]=ship[a][b]+1;                       
                            }
                        }
                    }
                    else if (type==2)
                    {
                        for (int a=row1;a<=row1+ShipNum-1;a++)
                        {
                            for (int b=col1;b<=col1;b++)
                            {
                                ship[a][b]=ship[a][b]+1;                       
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invaild type, try again.");
                        re=1;
                    }
                    }while(re==1);
            }
        }


        //print map for player
       	for(int i=1;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
                if(ship[i][j]==1)
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
    }
}

























