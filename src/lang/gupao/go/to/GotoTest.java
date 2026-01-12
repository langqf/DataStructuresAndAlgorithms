package lang.gupao.go.to;

public class GotoTest {

    public static void main(String[] args) {
        feng:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(j >= 4){
                    break feng;// continue feng; break; continue
                }
                System.out.println(i + " : " + j);
            }
        }
    }
}
