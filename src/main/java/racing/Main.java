package racing;

import racing.domain.RacingGame;
import racing.dto.RacingGameCreateRequest;
import racing.dto.RacingGameStatus;

import static racing.ui.ConsoleUI.*;

/**
 * 초간단 자동차 경주 게임을 구현한다.
 * <p>
 * step1
 * <p>
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다.어느 시점에 출력할 것인지에 대한 제약은 없다.
 * <p>
 * step2
 * <p>
 * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * 자동차 이름은 쉼표(,)를 기준으로 구분한다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
 */
public class Main {

    public static void main(String[] args) {
        RacingGameCreateRequest request = getRacingGameCreateInput();

        // 레이싱게임 클래스를 생성합니다.
        RacingGame racingGame = new RacingGame(request);

        printResultHeader();
        // 횟수가 끝날때까지 작업을 수행합니다
        while (racingGame.isRacingAvailable()) {
            RacingGameStatus racingCarStatuses = racingGame.race();
            printRacingCarStatuses(racingCarStatuses);
        }

        // 우승자를 찍습니다.
        printRacingGameWinner(racingGame.getRacingGameStatus());
    }
}
