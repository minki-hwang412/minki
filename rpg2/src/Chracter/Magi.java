package Chracter;

import java.util.Scanner;

public class Magi extends Hero {
	public int magiattack(Monster target) {
		Scanner in = new Scanner(System.in);
		System.out.println("1.쓰러스트\n2.디아볼리카");
		System.out.println("공격 번호를 입력하세요:");
		int number = in.nextInt();
		int sum = 0;

		switch (number) {
		case 1 -> {
			sum += level * 10;
			sum += power * 30;
			System.out.printf("데미지는 %d 입니다.\n", sum);
			return sum;
		}
		case 2 -> {
			if (level >= 3) {
				sum += level * 70;
				sum += power * 100;

				// 특별 조건: xPig에게 추가 피해
				if (target instanceof xPig) {
					sum += power * 200;
				}

				System.out.printf("데미지는 %d 입니다.\n", sum);
				return sum;
			} else {
				System.out.println("레벨이 부족하여 사용할 수 없습니다. (레벨 3 이상 필요)");
				return 0;
			}
		}
		default -> {
			System.out.println("잘못된 번호입니다.");
			return 0;
		}
		}
	}

}
