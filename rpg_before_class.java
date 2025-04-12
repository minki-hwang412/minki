package homework;

import java.util.Scanner;

public class rpg_before_class {
	static int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money;
	static int monster_hp, monster_defense, monster_power, monster_mp, monster_Level, monster_experience, monster_money;
	static String hero_name, monster_name;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hero_level = 1;
		hero_power = 15;
		hero_hp = 80;
		hero_defense = 25;
		hero_experience = 0;
		hero_money = 0;
		hero_mp = 0;

		Scanner in = new Scanner(System.in);
		System.out.println("영웅의 이름을 입력하세요:");
		hero_name = in.next();
		System.out.println("이름이 입력되었습니다.");
		System.out.println("게임에 입장하였습니다.");

		now_state();

		while (true) {
			System.out.println("1.사냥터\n2.포션상점\n입장할 장소를 입력하세요:     (0.게임 종료 8.감정표현)");
			int place = in.nextInt();

			if (place == 1) {
				System.out.println("사냥터에 입장하였습니다.");
				System.out.println("1.너구리\n2.살쾡이\n ");
				System.out.println("전투할 상대를 입력하세요:");

				int fight_with = in.nextInt();

				if (fight_with == 1) {
					while (true) {
						System.out.println("너구리와 전투를 시작합니다.");
						monster_name = "너구리";
						monster_hp = 100;
						monster_mp = 0;
						monster_Level = 1;
						monster_power = 20;
						monster_defense = 5;
						monster_money = 10;
						monster_experience = 10;
						monster_attacked(hero_attack());
						if (monster_hp <= 0) {
							System.out.printf("%s가 죽었습니다.", monster_name);
							hero_experience += monster_experience;
							hero_money += monster_money;
							break;
						}
						hero_attacked(monster_attack());
						if (hero_hp <= 0) {
							System.out.printf("%s가 죽었습니다.", hero_name);
							hero_hp = 1;
							System.out.printf("%s가 부활했습니다.", hero_name);
							break;
						}
					}
				}

				if (fight_with == 2) {
					while ((hero_hp > 80) && (hero_power > 15)) {
						while (true) {
							System.out.println("살쾡이와 전투를 시작합니다.");
							monster_name = "살쾡이";
							monster_hp = 2000;
							monster_mp = 0;
							monster_Level = 5;
							monster_power = 100;
							monster_defense = 20;
							monster_money = 30;
							monster_experience = 50;
							monster_attacked(hero_attack());
							if (monster_hp <= 0) {
								System.out.printf("%s가 죽었습니다.", monster_name);
								hero_experience += monster_experience;
								hero_money += monster_money;
								break;
							}
							hero_attacked(monster_attack());
							if (hero_hp <= 0) {
								System.out.printf("%s가 죽었습니다.\n", hero_name);
								hero_hp = 1;
								System.out.printf("%s가 부활했습니다.\n", hero_name);
								break;
							}
						}

					}
					System.out.println("기본 hp와 power로는 살쾡이 공격이 불가합니다.");
				}

			}
			if (place == 2) {
				System.out.println("포션상점에 입장하였습니다.");
				System.out.println("1.힘 증강 포션 (30원)");
				System.out.println("2.방어 증강 포션 (30원)");
				System.out.println("3.경험치 증강 포션 (100원)");
				System.out.println("4.HP 증강 포션 (10원)");
				System.out.println("5.MP 증강 포션 (10원)");
				System.out.println("6.상점 나가기");
				System.out.println("원하는 물건을 입력하세요: ");
				int want = in.nextInt();
				if (want == 6) {
					System.out.println("상점을 나갑니다.");
					continue;
				}
				System.out.println("포션 상점에서 물건을 구매 시도중입니다.");

				if (potionStore_show(hero_money, want) != 1) {
					if (want == 1)
						hero_power += 3;
					if (want == 2)
						hero_defense += 3;
					if (want == 3)
						hero_experience += 50;
					if (want == 4)
						hero_hp += 50;
					if (want == 5)
						hero_mp += 50;
					hero_money = potionStore_show(hero_money, want);
					System.out.printf("%d원 남았습니다.", hero_money);
				} else {
					System.out.println("돈이 부족합니다");
				}
			}
			if (place == 0) {
				System.out.println("게임 종료허겠습니다");
				break;
			}
			if (place == 8) {
				emotion();

			}

			if (hero_experience >= hero_level * 80) {
				hero_level += 1;
				System.out.printf("%s의 레벨이 %d되었습니다.\n", hero_name, hero_level);
				hero_money += hero_level * 50;
				System.out.printf("레벨업 기념으로 돈이 %d원 증가하여\n %d원이 되었습니다.", hero_level * 50, hero_money);
				hero_experience = 0;
			}
			now_state();
		}

	}

	static int hero_attack() {
		System.out.printf("%s의 공격입니다\n1.쓰러스트\n공격 번호를 입력하세요:\n", hero_name);
		Scanner in = new Scanner(System.in);
		int attack_num = in.nextInt();
		int sum = 0;
		if (attack_num == 1) {
			sum = hero_level * 10 + hero_power * 30;
			System.out.printf("%s의 데미지는 %d 입니다.\n", monster_name, sum);

		}
		return sum;

	}

	static void monster_attacked(int sum) {
		if (monster_defense >= monster_power) {
			monster_hp += 0;
		} else {
			monster_hp += monster_defense - sum;
		}

	}

	static int monster_attack() {
		System.out.printf("%s의 공격입니다\n", monster_name);
		System.out.printf("%s의 데미지는 %d 입니다.\n", hero_name, monster_power);
		return monster_power;
	}

	static void hero_attacked(int sum) {
		if (hero_defense >= monster_power) {
			hero_hp += 0;
		} else {
			hero_hp = hero_hp + hero_defense - monster_power;
		}

	}

	static int potionStore_show(int hero_money, int num) {
		int power = 30;
		int defense = 30;
		int experience = 100;
		int hp = 10;
		int mp = 10;
		if (num == 1) {
			if (hero_money >= power)
				return hero_money - power;
		}
		if (num == 2) {
			if (hero_money >= defense)
				return hero_money - defense;
		}
		if (num == 3) {
			if (hero_money >= experience)
				return hero_money - experience;
		}
		if (num == 4) {
			if (hero_money >= hp)
				return hero_money - hp;
		}
		if (num == 5) {
			if (hero_money >= mp)
				return hero_money - mp;
		}
		return 1;
	}

	static void emotion() {
		Scanner in = new Scanner(System.in);
		System.out.println("원하는 감정 표현을 선택하시오\n1.행복\n2.우울\n3.분노\n4.사랑");
		int emotion_num = in.nextInt();
		switch (emotion_num) {
		case 1:
			System.out.println("나 완전 행복해서 하늘을 날 것만 같아~");
			hero_power += 5;
			hero_hp += 5;
			break;
		case 2:
			System.out.println("너무 슬퍼 ㅠㅠㅠ");
			hero_money += 10; // 위로금
			break;
		case 3:
			System.out.println("지금 매우 화나 건들지 마.");
			hero_power += 5; // 분노조절실패로 힘이 증가
			break;
		case 4:
			System.out.println("사랑해 i love you");
			hero_mp += 5; // 사랑으로 마력 증가
			break;
		default:
			System.out.println("해당 번호의 감정 표현은 없습니다.");
			break;
		}

	}

	static void now_state() {
		System.out.printf("\n******************\n현재 Hero의 이름: %s\n", hero_name);
		System.out.printf("현재 %s의 레벨: %s \n", hero_name, hero_level);
		System.out.printf("현재 %s의 힘: %s \n", hero_name, hero_power);
		System.out.printf("현재 %s의 방어력: %s \n", hero_name, hero_defense);
		System.out.printf("현재 %s의 HP: %s \n", hero_name, hero_hp);
		System.out.printf("현재 %s의 MP: %s \n", hero_name, hero_mp);
		System.out.printf("현재 %s의 돈: %s \n", hero_name, hero_money);
		System.out.printf("현재 %s의 경험치: %s\n********************\n", hero_name, hero_experience);
	}
}
