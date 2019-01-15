package hibernate;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mata
 */
public class Hibernate {

    public static void main(String[] args) throws SQLException {

        Uradi();

    }

    public static void Uradi() throws SQLException {
        Scanner unos = new Scanner(System.in);
        System.out.println("Pozdrav!\n Izaberi opciju?");
        System.out.println("(L)ist zaposleni,(S)earch,(C)hange,(D)elete,(A)dd novog ili (E)xit");
        String opcija = unos.nextLine();

        if (opcija.equalsIgnoreCase("l")) {
            System.out.println("Izaberi (L)ist");
            List<Podaci> pod = Podaci.List();
            for (Podaci pod1 : pod) {
                System.out.println(pod1);

            }
            Uradi();
        } else if (opcija.equalsIgnoreCase("s")) {
            System.out.println("Unesi (S)earch");
            System.out.println("Unesi ime koje te zanima: ");
            String ime = unos.nextLine();
            List<Podaci> pod = Podaci.Search(ime);
            if (pod.isEmpty()) {
                System.out.println("Ne postoji!");
                Uradi();
            }
            for (Podaci pod1 : pod) {

                System.out.println(pod1);

            }
            Uradi();
        } else if (opcija.equalsIgnoreCase("c")) {
            System.out.println("Izaberi (C)hange");
            List<Podaci> pod = Podaci.List();
            for (Podaci pod1 : pod) {
                System.out.println(pod1);

            }
            Podaci p = new Podaci();
            System.out.print("Unesi id zaposlenog koji zelis da izmenis: ");
            p.setId(unos.nextInt());
            unos.nextLine();
            System.out.println("Sta zelis da izmenis?Unesi vd za visinu dohotka ili a za adresu");
            String izbor = unos.nextLine();
            if (izbor.equalsIgnoreCase("vd")) {
                System.out.println("Unesi novu visinu dohotka:");
                p.setVisinaDohotka(unos.nextInt());
                p.UpdateVisinaDohotka();
            } else if (izbor.equalsIgnoreCase("a")) {
                System.out.println("Unesi novu adresu: ");
                p.setAdresa(unos.nextLine());
                p.UpdateAdresa();
            }
            Uradi();
        } else if (opcija.equalsIgnoreCase("d")) {
            System.out.println("Izaberi (D)elete");
            List<Podaci> pod = Podaci.List();
            for (Podaci pod1 : pod) {
            System.out.println(pod1);

            }
            Podaci p = new Podaci();
            System.out.print("Unesi id zaposlenog kojeg zelis da izbrises: ");
            p.setId(unos.nextInt());
            unos.nextLine();
            p.Delete();
            Uradi();
        } else if (opcija.equalsIgnoreCase("a")) {
            System.out.println("Izaberi (A)dd novog zaposlenog");
            Podaci p = new Podaci();
            System.out.println("Unesi ime: ");
            p.setIme(unos.nextLine());
            System.out.println("Unesi broj godina: ");
            p.setBrojGodina(unos.nextInt());
            System.out.println("Unesi adresu: ");
            p.setAdresa(unos.next());
            System.out.println("Unesi visinu dohotka: ");
            p.setVisinaDohotka(unos.nextInt());
            p.Add();
            Uradi();
        } else if (opcija.equalsIgnoreCase("e")) {
            System.out.println("Izaberi (E)xit");
            System.exit(0);
        } else {
            System.out.println("Pokusajte ponovo");
            Uradi();
        }
    }
}
