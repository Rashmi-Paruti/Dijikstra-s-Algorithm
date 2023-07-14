import java.lang.*;
import java.util.*;
public class DIJKSTRA 
{
    int n,ne,source;
    int d[][]=new int[10][10];
    int path[]=new int[10];
    int visited[]=new int[10];
    void getdata()
    {
        Scanner read=new Scanner(System.in);
        System.out.println("Enter no.of nodes:");
        n=read.nextInt();
        System.out.println("Enter the matrix:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                d[i][j]=read.nextInt();          
            }
        }
        System.out.println("Enter source node:");
        source=read.nextInt();
        for(int i=0;i<n;i++)
        {
            visited[i]=0;
        }
        
    }
    void shortest()
    {
        int i,j,u=0,v=0,min; 
        ne=0;
        for(i=0;i<n;i++)
        {
            path[i]=d[source][i];
        }
        visited[source]=1;
       while(ne!=n-1)
        {
            min=999;
            for(j=0;j<n;j++)
            {
                if(path[j]<min && visited[j]==0)
                {
                    min=path[j];
                    u=j;
                }
            }
            visited[u]=1;
            ne++;
            for(v=0;v<n;v++)
            {
                if(path[u]+d[u][v]<path[v]&&visited[v]==0)
                {
                    path[v]=path[u]+d[u][v];
                }
            }
        }
    }
    void display()
    {
        System.out.println("***Shortest Path***");
        for(int i=0;i<n;i++)
        {
            System.out.println(source+"-"+i+"="+path[i]);
        }
    }
    public static void main(String args[])
    {
        DIJKSTRA ob=new DIJKSTRA();
        ob.getdata();
        ob.shortest();
        ob.display();
    }
    
}