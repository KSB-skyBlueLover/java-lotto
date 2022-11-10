package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final int lottoPrice = 1000;
    private static final String lottoPriceString = addComma(lottoPrice);
    private static final String errorMsg1 = "[ERROR] 숫자를 입력해 주세요.";
    private static final String errorMsg2 =
            "[ERROR] 구입 금액은 " + lottoPriceString + "원으로 나누어 떨어지는 자연수여야 합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static String addComma(int number) {
        final DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(number);
    }

    public static Integer readMoney() throws IllegalArgumentException{
        String userInput = Console.readLine();
        try {
            return Integer.valueOf(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException(errorMsg1);
        }
    }

    public static void validateMoney(int money) throws IllegalArgumentException{
        if (money <= 0 || money % lottoPrice != 0) {
            throw new IllegalArgumentException(errorMsg2);
        }
    }

    public static Integer howManyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        Integer money = readMoney();
        validateMoney(money);
        return Integer.valueOf(money/lottoPrice);
    }

    public static List<Lotto> getRandomNLotto(int n) {
        List<Integer> numbers;
        List<Lotto> lottos = new ArrayList<>();

        System.out.println(n + "개를 구매했습니다.");

        for (int i=0;i<n;i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto newLotto = new Lotto(numbers);
            newLotto.printAscending();
            lottos.add(newLotto);
        }
        return lottos;
    }



}
