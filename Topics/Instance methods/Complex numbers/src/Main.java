class Complex {

    double real;
    double image;

    public void add(Complex n) {
        this.real += n.real;
        this.image += n.image;
    }

    public void subtract(Complex n) {
        this.real -= n.real;
        this.image -= n.image;
    }
}