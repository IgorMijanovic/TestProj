import java.util.Scanner;

public class Main{


    public static void main(String[] args) throws ClassNotFoundException {
//        Class.forName("ZakazivanjeJedanImpl");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Odaberite imlementaciju:\n-prva-\t-druga-");
        String unos = scanner.nextLine();
        int flag;
        if(unos.equals("prva")){
            flag = 1;
            Class.forName("ZakazivanjeJedanImpl");
            ObradaTermina.getObj().initRaspored();
        } else if (unos.equals("druga")) {
            flag = 2;
            Class.forName("PeriodImplementacija");
            ObradaTermina.getObj().initRaspored();
        }else {
            System.out.println("Pogresan unos");
            return;
        }
        int opcija;
        System.out.println("Odaberite opciju:\n" +
                "1.Zakazi termin : -1-\n" +
                "2.Brisanje zakazanog termina : -2-\n" +
                "3.Premestanje termina : -3-\n" +
                "4.Pretraga : -4-\n" +
                "5.Export : -5-\n" +
                "6.Import : -6-\n" +
                "7.Exit : -7-");
        unos = scanner.nextLine();
        opcija = Integer.parseInt(unos);
        while (opcija != 7){

            if(opcija == 1){

                System.out.println("unesite novi termin(unos treba da bude odvojen zarezima)");
                unos = scanner.nextLine();
                String[] split = unos.split(",");
//                System.out.println(split[0]);

                if(ObradaTermina.getObj().dodajNoviTermin(split)){
                    System.out.println("Termin uspesno zakazan");
                }else
                    System.out.println("Termin nije zakazan");

            } else if (opcija == 2) {

                System.out.println("unesite termin koji zelite da obrisete(unos treba da bude odvojen zarezima)");
                unos = scanner.nextLine();
                String[] split = unos.split(",");
                if(ObradaTermina.getObj().brisanjeTermina(split))
                    System.out.println("termin je uspesno obrisan");
                else
                    System.out.println("doslo je do greske pri brisanju");

            }else if (opcija == 3){

                System.out.println("unesite termin koji zelite da premestite i datum kada zelite da ga premestite" +
                        "(unos treba da bude odvojen zarezima)");
                unos = scanner.nextLine();
                String[] split = unos.split(",");
                if(ObradaTermina.getObj().premestanjeTermina(split))
                    System.out.println("termin je uspesno pomeren");
                else
                    System.out.println("doslo je do greske pri pomeranju termina");

            } else if (opcija == 4) {

                System.out.println("unesite kako zelite da pretrazite raspored(unos treba da bude odvojen zarezima)");
                unos = scanner.nextLine();
                String[] split = unos.split(",");
                ObradaTermina.getObj().pretragaTermina(split);

            } else if (opcija == 5) {

                System.out.println("unesite koji format exporta zelite\n-csv-\t-json-\t-pdf-");
                unos = scanner.nextLine();
                if(unos.equals("csv")){
                    System.out.println("unesit sta hocete da exportujete(odvojeno zarezima)");
                    unos = scanner.nextLine();
                    String[] split = unos.split(",");
                    ObradaTermina.getObj().exportCSV(split);
                }else if(unos.equals("json")){
                    unos = scanner.nextLine();
                    String[] split = unos.split(",");
                    ObradaTermina.getObj().exportJson(split);
                }else if(unos.equals("pdf")){
                    unos = scanner.nextLine();
                    String[] split = unos.split(",");
                    ObradaTermina.getObj().exportPDF(split);
                }
            } else if (opcija == 6) {
                System.out.println("unesite koji format importa zelite\n-csv-\t-json-");
                unos = scanner.nextLine();
                if(unos.equals("csv")){
                    unos = scanner.nextLine();
                    ObradaTermina.getObj().importovanjeCSV(unos);
                }else if(unos.equals("json")) {
                    unos = scanner.nextLine();
                    ObradaTermina.getObj().importovanjeJson(unos);
                }
            }else
                break;
//            System.out.println("Odaberite opciju:\n" +
//                    "1.Zakazi termin : -1-\n" +
//                    "2.Brisanje zakazanog termina : -2-\n" +
//                    "3.Premestanje termina : -3-\n" +
//                    "4.Pretraga : -4-\n" +
//                    "5.Export : -5-\n" +
//                    "6.Import : -6-\n" +
//                    "7.Exit : -7-");
            unos = scanner.nextLine();
            opcija = Integer.parseInt(unos);
        }

//        ObradaTermina.getObj().dodajNoviTermin("s1", "13","15","01.10.2023", "Prof:aleksa", "Tip:predavanje");
//        System.out.println(ObradaTermina.getObj().getRaspored());
//        s1,13,15,01.10.2023,Prof:aleksa,Tip:predavanje
        System.out.println(ObradaTermina.getObj().getRaspored());
    }

}
