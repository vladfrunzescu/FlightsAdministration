package socialnetwork;


public class Main {
    public static void main(String[] args) {
        /*
        String fileName=ApplicationContext.getPROPERTIES().getProperty("data.socialnetwork.angajati");
        Repository<Long, Membru> membruFileRepository = new MembruFile(fileName
                , new MembruValidator());

        String fileName2=ApplicationContext.getPROPERTIES().getProperty("data.socialnetwork.discutiiCuSefu");
        Repository<Long, Mesaj> mesajFileRepository = new MesajFile(fileName2
                , new MesajValidator(membruFileRepository));

        membruFileRepository.findAll().forEach(System.out::println);
        mesajFileRepository.findAll().forEach(System.out::println);
         */

       // System.out.println(args[0]);
        MainApp.main(args);




    }
}



