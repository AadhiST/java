import java.util.*;
class basic1
{
    public static void main(String args[])
    {
        /*String[] playlist=new String[5];
        playlist[0]="song1";
        System.out.println(playlist[0]);
       
        playlist[1]="song2";
        System.out.println(playlist[1]);
        
        playlist[2]="song3";
        System.out.println(playlist[2]);*/
        int[] score = new int[5];
        Scanner obj = new Scanner (System.in);
        score[0]=obj.nextInt();
        score[1]=obj.nextInt();
        score[2]=obj.nextInt();
        score[3]=obj.nextInt();
        score[4]=obj.nextInt();
        System.out.println(score[0]+score[1]+score[2]+score[3]+score[4]);
    }
}