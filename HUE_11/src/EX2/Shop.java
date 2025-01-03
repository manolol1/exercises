package EX2;

public class Shop {
    private String name;
    private String street;
    private int number;
    private int postalCode;
    private String city;
    private String phone;
    private String email;

    public Shop(String name, String street, int number, int postalCode, String city, String phone, String email) {
        this.name = name;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    public Shop(String name, String street, int number, int postalCode, String city, String phone) {
        this(name, street, number, postalCode, city, phone, null);
    }

    public Shop(String name, String street, int number, int postalCode, String city) {
        this(name, street, number, postalCode, city, null, null);
    }

    @Override
    public String toString() {
        //OUTPUT:
        StringBuilder sb = new StringBuilder();
        String delimitingLine = new String(new char[Receipt.MAX_LINELENGTH]).replace("\0", "*");
        sb.append(delimitingLine).append('\n');

        sb.append(String.format("%-" + (Receipt.MAX_LINELENGTH - 1) + "s*\n", "*"));

        addLine(name, sb);
        addLine(street + " " + number, sb);
        addLine(postalCode + " " + city, sb);

        if (phone != null && !phone.isEmpty()) {
            addLine(phone, sb);
        }
        if (email != null && !email.isEmpty()) {
            addLine(email, sb);
        }

        sb.append(String.format("%-" + (Receipt.MAX_LINELENGTH - 1) + "s*\n", "*"));

        sb.append(delimitingLine).append('\n');
        return sb.toString();
    }

    private void addLine(String text, StringBuilder sb) {
        sb.append(String.format("*  %-" + (Receipt.MAX_LINELENGTH - 6) + "s  *\n", text));
    }



    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
