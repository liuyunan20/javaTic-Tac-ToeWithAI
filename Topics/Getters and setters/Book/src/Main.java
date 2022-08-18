class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setYearOfPublishing(int year) {
        this.yearOfPublishing = year;
    }

    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getAuthors() {
        return this.authors;
    }
}