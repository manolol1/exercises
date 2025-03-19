package EX_1;

public class Main {
    public static void main(String[] args){

        //Anlegen der Artikel
        Item i1 = new Item(2733,"Antman", 9.99);
        Item i2 = new Item(2734,"Antman and the wasp", 19.99);
        Item i3 = new Item(5929,"Antman and the wasp, quantumania", 29.99);
        Item i4 = new Item(1111,"Fenster zum Hof", 14.90);
        Item i5 = new Item(1220,"Die Vögel", 14.90);
        Item i6 = new Item(1333,"Bei Anruf Mord", 14.90);
        Item i7 = new Item(2020,"Hitchcocks Meisterwerke", 59.90);
        Item i8 = new Item(3333,"How I met your mother - Staffel 1", 14.50);
        Item i9 = new Item(3334,"How I met your mother - Staffel 2", 14.50);
        Item i10 = new Item(3335,"How I met your mother - Staffel 3", 14.50);
        Item i11 = new Item(4259,"Friends - Staffel 10", 17.90);
        Item i12 = new Item(4261,"Friends - Staffel 11", 17.90);
        Item i13 = new Item(4545,"911-OV, Staffel 5", 12.90);
        Item i14 = new Item(4546,"911-OV, Staffel 6", 12.90);
        Item i15 = new Item(9987,"König der Löwen", 15.90);
        Item i16 = new Item(9988,"Merida",9.90);
        Item i17 = new Item(9989,"Alles steht Kopf", 15.99);
        Item i18 = new Item(9990,"Happy feet", 9.90);
        Item i19 = new Item(9991,"Die Eiskönigin", 12.90);
        Item i20 = new Item(2345,"Harry Potter und der Stein der Weisen", 9.90);
        Item i21 = new Item(2350,"Harry Potter und die Kammer des Schreckens", 9.90);
        Item i22 = new Item(2355,"Harry Potter und der Gefangene von Askaban", 9.90);
        Item i23 = new Item(2360,"Harry Potter und der Feuerkelch", 9.90);
        Item i24 = new Item(2365,"Harry Potter und der Orden des Phönix", 9.90);
        Item i25 = new Item(2370,"Harry Potter und der Halbblutprinz", 9.90);
        Item i26 = new Item(2375,"Harry Potter und die Heiligtümer des Todes 1", 12.90);
        Item i27 = new Item(2380,"Harry Potter und die Heiligtümer des Todes 2", 12.90);
        Item i28 = new Item(7888,"Phantastische Tierwesen und wo sie zu finden sind", 17.90);
        Item i29 = new Item(8023,"Phantastische Tierwesen: Grindlwalds Verbrechen", 21.90);
        Item i30 = new Item(8592,"Phantastische Tierwesen: Dumbledores Geheimnisse", 24.99);

        //Anlegen von Einkaufsarrays für die acht Kunden
        Item[] shoping1 = {i2,i5,i15,i28,i29,i30,null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        Item[] shoping2 = {i12,i3,i8, i9, i10, i15,i21,null, null, null, null, null, null, null, null, null, null, null, null, null};
        Item[] shoping3 = {i4,i5,i6,i7,i14,i15,i16,null, null, null, null, null, null, null, null, null, null, null, null, null};
        Item[] shoping4 = {i8,i9,i10,i11,i12,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        Item[] shoping5 = {i20,i21,i22,i23,i24,i25,i26,i27,i28,i29,i30,null,null,null,null,null,null,null,null,null};
        Item[] shoping6 = {i1,i2,i3,null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        Item[] shoping7 = {i13,i17,i18,i19,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        Item[] shoping8 = {i4,i13,i19,i22,i24,i29,i30,null,null,null,null,null,null,null,null,null,null,null,null,null};

        //Anlegen der Kunden
        StoreCustomer sc1 = new StoreCustomer("Schleich Patrick", "Wien-Hitzing", "Bahnhofstr. 14, 1070 Wien", 7);
        StoreCustomer sc2 = new StoreCustomer("Affenzeller Paul", "Linz-Urfahr", "Ferdinand-Markl-Str. 2, 4040 Linz",9);
        StoreCustomer sc3 = new StoreCustomer("Winters Daniela", "Linz-Urfahr", "Gründbergstr. 7, 4040 Linz", 3);
        StoreCustomer sc4 = new StoreCustomer("Zehetner Peter", "Wien-Penzing", "Unterer Markt 19a, 1120 Wien", 5);

        OnlineCustomer ol1 = new OnlineCustomer("Schweiger Eugen", "e.schweiger77@gmail.com", 17);
        OnlineCustomer ol2 = new OnlineCustomer("Macher Michael", "mmminigolf@gmail.com", 25);
        OnlineCustomer ol3 = new OnlineCustomer("Enders Elisabeth", "e.enders@liwest.at", 10);
        OnlineCustomer ol4 = new OnlineCustomer("Silbereisen Florian", "f.silbereisen@gmail.com", 12);

        sc1.setPurchase(shoping1);
        sc2.setPurchase(shoping2);
        sc3.setPurchase(shoping3);
        sc4.setPurchase(shoping4);
        ol1.setPurchase(shoping5);
        ol2.setPurchase(shoping6);
        ol3.setPurchase(shoping7);
        ol4.setPurchase(shoping8);

        Customer[] customers = new Customer[20];
        customers[2] = sc1;
        customers[18] = sc2;
        customers[7] = sc3;
        customers[6] = sc4;
        customers[15] = ol1;
        customers[12] = ol2;
        customers[1] = ol3;
        customers[0] = ol4;

        printCustomers(customers);
        System.out.println();
        sortCustomers(customers);
        printCustomers(customers);

        System.out.printf("%nTotal discounts OnlineCustomer: %.2f%n", OnlineCustomer.getTotalDiscounts());
        System.out.printf("Total discounts StoreCustomer: %.2f%n%n", StoreCustomer.getTotalDiscounts());

        printCustomersWithItems(customers, "Staffel");
    }

    public static void printCustomers(Customer[] customers) {
        for (Customer customer : customers) {
            if (customer != null) {
                System.out.println(customer.toString());
            }
        }
    }

    public static void sortCustomers(Customer[] customers) {
        Customer temp;
        int minIndex = 0;

        for (int i = 0; i < customers.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < customers.length; j++) {
                if (customers[minIndex] == null) {
                    continue;
                }
                if (customers[minIndex].compareTo(customers[j]) < 0) {
                    minIndex = j;
                }
            }
            temp = customers[minIndex];
            customers[minIndex] = customers[i];
            customers[i] = temp;
        }
    }

    public static void printCustomersWithItems(Customer[] customers, String itemName) {
        for (Customer customer : customers) {
            if (customer != null) {
                if (customer.searchItemName(itemName)) {
                    System.out.println(customer.toString());
                }
            }
        }
    }
}
