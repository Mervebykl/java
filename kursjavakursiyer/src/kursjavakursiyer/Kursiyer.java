package kursjavakursiyer;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class Kursiyer {

    private int KursiyerId;
    private String KursiyerAdSoyad;
    private int KursiyerYas;
    public ArrayList<Kurs> AlinanKurslar;

    public Kursiyer(int KursiyerId, String KursiyerAdSoyad, int KursiyerYas, ArrayList<Kurs> AlinanKurslar){
       
    	this.setKursiyerId(KursiyerId);
        this.setKursiyerAdSoyad(KursiyerAdSoyad);
        this.setKursiyerYas(KursiyerYas);
        this.setAlinanKurslar(AlinanKurslar);

    }

    public static ArrayList<Kursiyer> add(ArrayList<Kursiyer> kursiyerler, int id, String ad, int yas, ArrayList<Kurs> AlinanKurslar) throws IOException {

        if(control(kursiyerler, id)==0){
            Kursiyer temp = new Kursiyer(id, ad, yas, AlinanKurslar);
            kursiyerler.add(temp);
            write(kursiyerler);
        }
        else{
            System.out.println(" Bu Kursiyer id baska bir kursiyere ait.");
        }
        return kursiyerler;

    }

    public static int control(ArrayList<Kursiyer> kursiyerler, int id){

        int a = 0;

        for(int i=0;i<kursiyerler.size();i++){
            if(id==kursiyerler.get(i).getKursiyerId()){
                a=1;
            }
        }
        return a;
    }

    public static void write(ArrayList<Kursiyer> kursiyerler) throws IOException {

        FileWriter myWriter = new FileWriter("kursiyer.txt");

        String veri="";

        for(int i=0;i<kursiyerler.size();i++){

            veri+="*"+kursiyerler.get(i).getKursiyerId()+"-"+kursiyerler.get(i).getKursiyerAdSoyad();
            veri+="-"+kursiyerler.get(i).getKursiyerYas()+"\n";

            for(int j=0;j<kursiyerler.get(i).getAlinanKurslar().size();j++){

            	veri+="%"+kursiyerler.get(i).getAlinanKurslar().get(j).getKursId();
            	veri+="-"+kursiyerler.get(i).getAlinanKurslar().get(j).getKursAd()+"\n";

            }
        }

        myWriter.write(veri);
        myWriter.close();

    }

    public static void ara(ArrayList<Kursiyer> kursiyerler, String ad){

        boolean deger = false;

        for(int i=0;i<kursiyerler.size();i++){

            if(kursiyerler.get(i).getKursiyerAdSoyad().equals(ad)){

                deger = true;
                System.out.println("-----------------");
                System.out.println(" Kursiyer Id : "+kursiyerler.get(i).getKursiyerId());
                System.out.println(" Kursiyer adi : "+kursiyerler.get(i).getKursiyerAdSoyad());
                System.out.println(" Kursiyer yas : "+kursiyerler.get(i).getKursiyerYas());

                System.out.println("  Kurslar ;");

                for(int j=0;j<kursiyerler.get(i).getAlinanKurslar().size();j++){

                    System.out.println((j+1)+". Kurs Id : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursId());
                    System.out.println((j+1)+". Kurs Ad : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursAd());

                }
            }
        }

        if(deger!=true){
            System.out.printf("Aranan kisi bulunamadi");
        }
    }

    public static ArrayList<Kursiyer> remove(ArrayList<Kursiyer> kursiyerler, int id) throws IOException {

        boolean deger = true;

        for(int i=0;i<kursiyerler.size();i++){

            if(kursiyerler.get(i).getKursiyerId()==id){

                kursiyerler.remove(i);
                write(kursiyerler);

                System.out.println("id : "+id+" Silindi");
                deger=false;
                break;

            }

        }

        if(deger==true){
            System.out.println("Kursiyer bulunamadý. ");
        }

        return kursiyerler;

    }

    public static void listele(ArrayList<Kursiyer> kursiyerler, int deger){

        if(deger==1){

            for(int i=0;i<kursiyerler.size();i++){

                int id = kursiyerler.get(i).getKursiyerId();
                String ad = kursiyerler.get(i).getKursiyerAdSoyad();
                int yas = kursiyerler.get(i).getKursiyerYas();

                System.out.println(id+" "+ad+" "+yas);

            }

        }

        else if(deger==2){

            for(int i=0;i<kursiyerler.size();i++){

                System.out.println(" Kursiyer Id : "+kursiyerler.get(i).getKursiyerId());
                System.out.println(" Kursiyer Ad,Soyad : "+kursiyerler.get(i).getKursiyerAdSoyad());
                System.out.println(" Kursiyer Yas : "+kursiyerler.get(i).getKursiyerYas());
                System.out.println("  Kurslar ;");
                for(int j=0;j<kursiyerler.get(i).getAlinanKurslar().size();j++){
                    System.out.println((j+1)+". Kurs Id : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursId());
                    System.out.println((j+1)+". Kurs Ad : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursAd());

                }
            }

        }

    }

    public static void parahesapla(ArrayList<Kursiyer> kursiyerler, int id){

        float hesap = -99;
        int deger = 0;

        for(int i=0;i<kursiyerler.size();i++){

            if(id==kursiyerler.get(i).getKursiyerId()){

                deger = kursiyerler.get(i).getAlinanKurslar().size();

                if(deger==0 || deger==1){

                    hesap = (100) * deger;

                    System.out.println("Herhangi bir kampanyadan yararlanmýyor tutar : "+hesap);
                }

                else if(deger==2){

                    hesap = (100*4) + (85*4);

                    System.out.println("Kampanya 1 den yararlanýyor tutar  : "+hesap);

                }

                else if(deger==3){

                    hesap = (2*(100*4))  + (75*4);

                    System.out.println("Kampanya 2 den yararlanýyor tutar : "+hesap);
                }

                else if(deger>3){

                    hesap = (90*4) * deger;

                    System.out.println("Kampanya 3 den yararlanýyor tutar: "+hesap);
                }

                break;

            }

        }

        if((int)hesap==-99){
            System.out.println("Kullanici Id bulunamadi.");
        }

    }

    public int getKursiyerId() {

        return KursiyerId;
    }

    public void setKursiyerId(int kursiyerId) {

        KursiyerId = kursiyerId;
    }

    public String getKursiyerAdSoyad() {

        return KursiyerAdSoyad;
    }

    public void setKursiyerAdSoyad(String kursiyerAdSoyad) {

        KursiyerAdSoyad = kursiyerAdSoyad;
    }

    public int getKursiyerYas() {

        return KursiyerYas;
    }

    public void setKursiyerYas(int kursiyerYas) {

        KursiyerYas = kursiyerYas;
    }

    public ArrayList<Kurs> getAlinanKurslar() {

        return AlinanKurslar;
    }

    public void setAlinanKurslar(ArrayList<Kurs> alinanKurslar) {

        AlinanKurslar = alinanKurslar;
    }
}

