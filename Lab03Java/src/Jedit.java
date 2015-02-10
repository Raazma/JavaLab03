import java.io.Console;

/**
 * Created by Razma on 2015-02-09.
 */
public class Jedit
{

   private void WithNumber(String fileName)
   {




   }
    private void WithoutNumber(String fileName) {

        java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(System.in));
        String ligne = new String();
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(
                    new java.io.BufferedWriter(new java.io.FileWriter(fileName)));
            //while (ligne != null)
            ligne = reader.readLine();
            while (!ligne.isEmpty())
                {

                writer.println(ligne);
                    ligne = reader.readLine();
                }
            writer.close();

        }

        catch(java.io.IOException  e)
        {
            System.out.println("Erreur lors de la lectureS");
        }



    }

    public void editer( String args[] )
    {

        if(args.length > 0)
        {
            if(args[0].equals("-n"))
                WithNumber(args[1]);
           else
                WithoutNumber(args[0]);
       }





    }

    public static void main( String args[] )
    {
        Jedit app = new Jedit();
        app.editer( args );
    }

}
