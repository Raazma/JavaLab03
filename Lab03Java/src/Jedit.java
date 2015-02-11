import java.io.Console;

/**
 * Created by Razma on 2015-02-09.
 */
public class Jedit {

   private void WithNumber(String fileName) {
       int compteur = 1;
       java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
       String ligne = new String();

          if(Verif(fileName)) {
              try {
                  java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(fileName)));

                  ligne = reader.readLine();
                  while (!ligne.isEmpty()) {
                      writer.println(compteur + ": " + ligne);
                      ligne = reader.readLine();
                      compteur++;
                  }
                  writer.close();
              } catch (java.io.IOException e) {
                  System.out.println("Erreur lors de la lectureS");
              }
          }
   }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void WithoutNumber(String fileName) {

        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String ligne = new String();

        if(Verif(fileName)) {
            try {
                java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(fileName)));
                ligne = reader.readLine();
                while (!ligne.isEmpty()) {
                    writer.println(ligne);
                    ligne = reader.readLine();
                }
                writer.close();
            } catch (java.io.IOException e) {
                System.out.println("Erreur lors de la lectureS");
            }
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void editer( String args[] ) {
        if(args.length > 0 && args.length < 3)
        {
            if(args[0].equals("-n"))
                WithNumber(args[1]);
           else
            if(args.length == 1 )
                WithoutNumber(args[0]);
       }
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean Verif(String fileName) {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        java.io.File file = new java.io.File(fileName);
        String line = new String();
        
        if(file.exists()) {
            System.out.println("le fichier existe deja voulez vous l'ecraser O/Oui N/Non: ");

            try {
                line = reader.readLine();
            } catch (java.io.IOException e) {
                System.out.println(e);
            }
            if (line.equals("O") || line.equals("o")) {
                file.delete();
                return true;
            } else
                return false;
        }
        else
           return true;
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main( String args[] ) {
        Jedit app = new Jedit();
        app.editer( args );
    }

}
