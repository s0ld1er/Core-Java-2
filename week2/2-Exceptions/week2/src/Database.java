public class Database {
    private String name;

    public Database(String name) {
        if (name.equals(""))
            throw new DatabaseCorruptedException("Some database error");
        else
            this.name = name;
    }

}
