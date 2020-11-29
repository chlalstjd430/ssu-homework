import java.util.ArrayList;
import java.util.List;

public class Fuzzy {

    public static void main(String[] args) {
        // 퍼지화
        double[] A = {0.5, 0.2, 0.0};
        double[] B = {0.1, 0.7};
        System.out.println("\n===== 퍼지화 =====");
        System.out.println("A1(0.5), A2(0.2), A3(0)  \n" +
                "B1(0.5), B2(0.2)");
        // 규칙 평가
        List<K> kList = new ArrayList<>();
        int rule = Integer.max(A.length, B.length);

        for (int i = 0; i < rule; i++) {
            if (A[i] == A[2] || B[i] == B[0]) {
                kList.add(new K(Double.max(A[2], B[0]), 20));
                break;
            }
        }

        for (int i = 0; i < A.length; i++) {
            boolean isRule = false;

            for (int j = 0; j < B.length; j++) {
                if (A[i] == A[1] && B[j] == B[1]) {
                    kList.add(new K(Double.min(A[1], B[1]), 50));

                    isRule = true;
                    break;
                }

                if (isRule) break;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == A[0]) {
                kList.add(new K(A[0], 80));

                break;
            }
        }

        System.out.println("\n===== 규칙 평가 =====");
        for (int i = 0; i < kList.size(); i++) {
            System.out.println("규칙 " + i + " > " + kList.get(i).toString());
        }

        // 규칙 후건의 통합 및 역퍼지화
        double cogBottom = 0;
        double cogTop = 0;
        for (int i = 0; i < kList.size(); i++) {
            K k = kList.get(i);
            cogBottom += k.getZ();
            cogTop += k.getRuleNo() * k.getZ();
        }
        System.out.println("\n===== 통합 및 역퍼지화 =====");
        System.out.println("가중 평균식 분자 : " + cogTop + " / 가중 평균식 분모 : " + cogBottom);


        double cog = cogTop / cogBottom;
        System.out.println("\n===== 크리스프 출력 =====");

        System.out.println("> 프로젝트 위험성 : " + (int)cog + "%");
    }
}

class K {
    private double z;
    private int ruleNo;

    public K(double z, int ruleNo) {
        this.z = z;
        this.ruleNo = ruleNo;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public int getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(int ruleNo) {
        this.ruleNo = ruleNo;
    }

    @Override
    public String toString() {
        return "z = k(" + z + ")";
    }
}