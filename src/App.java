//program untuk menghitung statistik menggunakan distribusi binomial
// author: Bagas Rayhan Sebastian
// NIM: A11.2022.14715
// Bug: jika angka terlalu besar, maka akan menyebabkan kondisi divided by 0
// argument maksimum adalah 30
public class App {
    public static void main(String[] args) throws Exception {
        int time = -20; 
        int event = 4; 
        double pro = 0;
        
        Binomial p = new Binomial(time, event, pro);
        p.display();  
    }
}       