package kursjavakursiyer;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static <List> ArrayList<List> read(ArrayList<List> e, int control) throws IOException {

		if(control==1){

			int i=1, j=1;
			BufferedReader br = new BufferedReader(new FileReader("kursiyer.txt"));
			String bilgi ;
			boolean deger = true, deger1=true;
			

			ArrayList<Kurs> kurslar = new ArrayList<Kurs>();

			String id = "";
			String ad = "";
			String yas = "";

			while(deger){

				try {

					bilgi = br.readLine();

					if(bilgi.charAt(0)=='*'){

						if(deger1!=true){

							((ArrayList<Kursiyer>) e).add(new Kursiyer(Integer.parseInt(id),ad, Integer.parseInt(yas), kurslar));
						}

						kurslar = new ArrayList<Kurs>();
						deger1 = false;
						i=1;

						id = "";
						ad = "";
						yas = "";

						while(true){

							if(bilgi.charAt(i)=='-'){
								break;
							}
							id+= bilgi.charAt(i);

							i+=1;
						}
						while(true){
							i+=1;
							if(bilgi.charAt(i)=='-'){
								break;
							}
							ad+= bilgi.charAt(i);
						}
						while(true){
							i+=1;
							if(i==bilgi.length()){
								break;
							}
							yas+= bilgi.charAt(i);
						}
					}
					else if(bilgi.charAt(0)=='%'){
						String kursId = "";
						String kursAd = "";
						j = 1;
						while(true){
							if(bilgi.charAt(j)=='-'){
								break;
							}
							kursId+= bilgi.charAt(j);
							j+=1;
						}
						while(true){
							j+=1;
							if(j==bilgi.length()){
								break;
							}
							kursAd+= bilgi.charAt(j);
						}
					kurslar.add(new Kurs(Integer.parseInt(kursId), kursAd));
					}
				}
				catch(Exception a) {
					((ArrayList<Kursiyer>) e).add(new Kursiyer(Integer.parseInt(id),ad, Integer.parseInt(yas), kurslar));
					break;
				}
			}
			return e;
		}
		else{
			int i=0;
			BufferedReader br = new BufferedReader(new FileReader("kurs.txt"));
			String veri;
			boolean deger=true;
			while(deger){
				try {
					String id = "";
					String ad = "";
					i=0;
					veri = br.readLine();
					while(true){
						if(veri.charAt(i)=='-'){
							break;
						}
						id+= veri.charAt(i);
						i+=1;
					}
					while(true){
						i+=1;
						if(i==veri.length()){
							break;
						}
						ad+= veri.charAt(i);
					}
					((ArrayList<Kurs>) e).add(new Kurs(Integer.parseInt(id), ad));
				}
				catch(Exception a) {
					break;
				}
			}
			return e;
		}}
	
	public static void main(String[] args) throws IOException {

		ArrayList<Kursiyer> kursiyer = new ArrayList<Kursiyer>();
		kursiyer = (ArrayList<Kursiyer>)read(kursiyer,1);

		ArrayList<Kurs> kurslar = new ArrayList<Kurs>();
		kurslar = (ArrayList<Kurs>)read(kurslar,0);

		Scanner scan = new Scanner(System.in);

		while(true){
			System.out.println("\nMENÜ");
			System.out.println("1) KURS EKLE");
			System.out.println("2) KURS LÝSTELE");
			System.out.println("3) KURSÝYER EKLE");
			System.out.println("4) KURSÝYER ARA");
			System.out.println("5) KURSÝYER SÝL");
			System.out.println("6) KURSÝYER LÝSTELE");
			System.out.println("7) KURSÝYERLERÝ AYRINTILI LÝSTELE");
			System.out.println("8) AYLIK ÜCRET HESAPLAMA");
			System.out.print("SEÇÝMÝNÝZÝ YAPIN : ");
			int secim = scan.nextInt();scan.nextLine();
			switch(secim) {
			case 1:
					System.out.println("Eklenecek kurs Id : ");
					String id0 = scan.next();
					int id = 0;
						id = Integer.parseInt(id0);					

					System.out.println("Eklenecek kurs ad : ");
					String ad = scan.next();

					kurslar = Kurs.KursEkle(kurslar,id,ad);
					break;
				

			

		case 2:
				
				Kurs.listele(kurslar);
			break;

		case 3:

			scan.nextLine();
				int kursiyerid=0;
				int kursiyeryas=0;
				String kursiyeradsoyad = "";

				
				System.out.print("Kursiyer Id : ");
				String kontrolid = scan.nextLine();

				System.out.print("Kursiyer Ad,soyad : ");
				kursiyeradsoyad = scan.nextLine();

				System.out.print("Kursiyer Yas : ");
				String kontrolyas = scan.nextLine();
				boolean deger0=true, deger1=true;

				while(true){

					if(deger0==false){

						System.out.print("Kursiyer Id : ");
						kontrolid = scan.nextLine();

						System.out.print("Kursiyer Ad,Soyad : "+kursiyeradsoyad);

						System.out.print("Kursiyer Yas : ");
						kontrolyas = scan.nextLine();
					}

					else if(deger1==false){

						System.out.print("Kursiyer Id : "+kursiyerid);


						System.out.print("Kursiyer Ad,Soyad : "+kursiyeradsoyad);

						System.out.print("Kursiyer Yas : ");
						kontrolyas = scan.nextLine();
					}

					deger0=true;
					deger1 = true;

					
						kursiyerid = Integer.parseInt(kontrolid);
					
			

					if(Kursiyer.control(kursiyer, kursiyerid)==1){

						deger0=false;
						System.out.println("Kursiyer Id baska bir kursiyere ait, tekrar denemek icin bir tuþa basiniz. ");
						scan.nextLine();
						continue;
					}

					try{
						kursiyeryas = Integer.parseInt(kontrolyas);
					} catch (Exception e){
						deger1=false;
						System.out.println("Kursiyer yas int veri tipinde olmali, tekrar denemek icin bir tuþa basiniz. ");
						scan.nextLine();
						continue;
					}

					break;
				}


				boolean deger = true;
				int i=1;
				ArrayList<Kurs> kurslar0 = new ArrayList<Kurs>();

				while(deger){

					String id_kurs0 = "";
					int id_kurs = 0;

					while(true){
						Kurs.listele(kurslar);

						System.out.print("Kursiyere Eklenecek Kurs Id : ");
						id_kurs0 = scan.nextLine();

						try{
							id_kurs = Integer.parseInt(id_kurs0);
						} catch (Exception e){
							System.out.println("Kurs Id int veri tipinde olmali. ");
							scan.nextLine();
							continue;
						}

						int control = Kurs.control(kurslar, id_kurs);
						String kurs_ad="";

						if(control==1){

							for(int j=0;j<kurslar.size();j++){
								if(id_kurs==kurslar.get(j).getKursId()){
									kurs_ad = kurslar.get(j).getKursAd();
									break;
								}
							}

							kurslar0.add(new Kurs(id_kurs, kurs_ad));
							break;
						}
						else{
							System.out.println("Eklenecek kurs Id bulunamadý. ");
							scan.nextLine();
						}
					}

					
					System.out.print("Kurs ekleme basarýlý");
				
						deger=false;
				}

				
				Kursiyer.add(kursiyer,kursiyerid,kursiyeradsoyad,kursiyeryas ,kurslar0);
              break;
			case 4:
				System.out.println(" Kursiyer ad soyad : ");
				String adi = scan.nextLine();
				Kursiyer.ara(kursiyer, adi);			
				break;
			case 5:

				int kursiyeridk=0;
					System.out.print("Kursiyer Id-------- : ");
					String kursiyeridkontrol = scan.nextLine();
					
					kursiyeridk = Integer.parseInt(kursiyeridkontrol);
					
				kursiyer = Kursiyer.remove(kursiyer, kursiyeridk);
				
				break;
			case 6:
				Kursiyer.listele(kursiyer, 1);
				break;

			case 7:
				Kursiyer.listele(kursiyer, 2);
				break;
			case 8:
				int kursiyerrid=0;
				System.out.println("-----------------------------------");
								
				System.out.print("Kursiyer Id : ");
				String kursiyerrid0 = scan.nextLine();				
					kursiyerrid = Integer.parseInt(kursiyerrid0);
				
			Kursiyer.parahesapla(kursiyer, kursiyerrid);
			break;
			}

		}

	}

}


