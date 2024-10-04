
class Detaly {
    protected String nazva;
    protected String material;
    protected double vaga;
    
    public Detaly(String nazva, String material, double vaga) {
        this.nazva = nazva;
        this.material = material;
        this.vaga = vaga;
    }
    
    public void Show() {
        System.out.println("Назва: " + nazva);
        System.out.println("Матеріал: " + material);
        System.out.println("Вага: " + vaga + " кг");
    }
}

class Vuzol extends Detaly {
    private int kilkistDetalei;
    
    public Vuzol(String nazva, String material, double vaga, int kilkistDetalei) {
        super(nazva, material, vaga);
        this.kilkistDetalei = kilkistDetalei;
    }
    
    @Override
    public void Show() {
        super.Show();
        System.out.println("Кількість деталей у вузлі: " + kilkistDetalei);
    }
}

class Mechanizm extends Detaly {
    private String typDvyguna; 
    
    public Mechanizm(String nazva, String material, double vaga, String typDvyguna) {
        super(nazva, material, vaga);
        this.typDvyguna = typDvyguna;
    }
    
    @Override
    public void Show() {
        super.Show();
        System.out.println("Тип двигуна: " + typDvyguna);
    }
}

class Vyrib extends Detaly {
    private int kilkistVuzliv;
    
    public Vyrib(String nazva, String material, double vaga, int kilkistVuzliv) {
        super(nazva, material, vaga);
        this.kilkistVuzliv = kilkistVuzliv;
    }
    
    @Override
    public void Show() {
        super.Show();
        System.out.println("Кількість вузлів: " + kilkistVuzliv);
    }
}

public class Main {
    public static void main(String[] args) {
    
        Detaly[] masivDetalei = new Detaly[3];

        masivDetalei[0] = new Vuzol("Вузол 1", "Сталь", 12.5, 5);
        masivDetalei[1] = new Mechanizm("Механізм 1", "Алюміній", 8.3, "Електричний");
        masivDetalei[2] = new Vyrib("Виріб 1", "Пластик", 2.1, 3);

        for (Detaly detaly : masivDetalei) {
            detaly.Show();
            System.out.println("-----------------");
        }
    }
}
