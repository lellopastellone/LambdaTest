package it.unibs.pajc;

public class App {
    public static void main(String[] args) throws Exception {
        //printAsciiTable();
        //System.out.println("\u001B[33m" + "TESTO GIALLO" + "\u001B[0m")
        //System.out.print(Colorizer.RED.highlight("cacona puzzolente", "o"));

        RowProcessor coloraRigheAlterne = (nrighe,s) -> {
            if(nrighe % 2 == 0) {
                s = Colorizer.RED.colorize(s);
            }
            System.out.println(s);
        };

        FileUtil.printFile("/home/lello/CODE/JAVA/LambdaTest/src/it/unibs/pajc/App.java", 
        (nrighe, s) -> 
        {
            String row_id = String.format("%4d", nrighe);
            s = Colorizer.RED.highlight(s, "printf");
            System.out.printf("%s ... %s\n", Colorizer.RED.colorize(row_id), s);
        }
        );

        FileUtil.printFile("/home/lello/CODE/JAVA/LambdaTest/src/it/unibs/pajc/App.java", coloraRigheAlterne);
    }

    public static void printAsciiTable() {
        for(int i = 0;i < 128; i++) {
            if (i % 16 == 0){
                System.out.printf("\n%04X\t", i);
            }
            if (Character.isISOControl(i)) {
                System.out.print(". ");
            }
            System.out.printf("%c ", i);
        }
    }
    
}
