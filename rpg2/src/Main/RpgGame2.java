package Main;

import java.util.Scanner;

import Chracter.Arch;
import Chracter.Hero;
import Chracter.Magi;
import Chracter.Monster;
import Chracter.Racoon;
import Chracter.Warrior;
import Chracter.WildCat;
import Chracter.xDog;
import Chracter.xPig;
import Map.Mission;
import Map.PotionStore;
import Map.Quest;
import Map.WeaponStore;

public class RpgGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("**********RPG GAME**********\n1. 전사\n2. 마법사\n3. 궁수\n직업의 번호를 입력하세요. :");
		int select_num = in.nextInt();
		Hero myhero = new Hero();
		switch (select_num) {
		case 1 -> {
			System.out.println("전사를 선택하셨습니다.");
			myhero = new Warrior();
			myhero.defense = 25;
			myhero.power = 15;
			myhero.level = 1;
			myhero.hp = 80;
			myhero.mp = 0;
			myhero.experience = 0;
		}
		case 2 -> {
			System.out.println("마법사를 선택하셨습니다.");
			myhero = new Magi();
			myhero.defense = 25;
			myhero.power = 15;
			myhero.level = 1;
			myhero.hp = 80;
			myhero.mp = 50;
			myhero.experience = 0;
		}
		case 3 -> {
			System.out.println("궁수를 선택하셨습니다.");
			myhero = new Arch();
			myhero.defense = 40;
			myhero.power = 20;
			myhero.level = 1;
			myhero.hp = 80;
			myhero.mp = 0;
			myhero.experience = 0;
		}
		default -> {
			System.out.println("잘못된 입력입니다. 기본값으로 전사를 생성합니다.");
			myhero = new Warrior();
			myhero.defense = 25;
			myhero.power = 15;
			myhero.level = 1;
			myhero.hp = 80;
			myhero.mp = 0;
			myhero.experience = 0;
		}
		}
		;

		System.out.println("영웅의 이름을 입력하세요: ");
		myhero.name = in.next();
		System.out.println("이름이 입력되었습니다.");
		System.out.println("게임에 입장하였습니다.");

		while (true) {
			System.out.printf("\n******************\n현재 Hero의 이름: %s\n", myhero.name);
			System.out.printf("현재 %s의 레벨: %s \n", myhero.name, myhero.level);
			System.out.printf("현재 %s의 힘: %s \n", myhero.name, myhero.power);
			System.out.printf("현재 %s의 방어력: %s \n", myhero.name, myhero.defense);
			System.out.printf("현재 %s의 HP: %s \n", myhero.name, myhero.hp);
			System.out.printf("현재 %s의 MP: %s \n", myhero.name, myhero.mp);
			System.out.printf("현재 %s의 돈: %s \n", myhero.name, myhero.money);
			System.out.printf("현재 %s의 경험치: %s\n********************\n", myhero.name, myhero.experience);
			System.out.println("1.사냥터\n2.포션상점\n3.무기상점\n입장할 장소를 입력하세요:     (0.게임 종료 7.특별퀘스트 도전 8.감정표현)");

			int place = in.nextInt();
			if (place == 1) {
				System.out.println("사냥터에 입장하였습니다.");
				System.out.println("1.너구리\n2.살쾡이\n3.들개\n4.멧돼지 ");
				System.out.println("전투할 상대를 입력하세요:");

				int fight_with = in.nextInt();
				Monster monster = new Monster();
				switch (fight_with) {
				case 1 -> {
					monster = new Racoon();
					monster.name = "너구리";
					monster.hp = 100;
					monster.mp = 0;
					monster.level = 1;
					monster.power = 20;
					monster.defense = 5;
					monster.money = 10;
					monster.experience = 10;
				}
				case 2 -> {
					monster = new WildCat();
					monster.name = "살쾡이";
					monster.hp = 2000;
					monster.mp = 0;
					monster.level = 5;
					monster.power = 100;
					monster.defense = 20;
					monster.money = 30;
					monster.experience = 50;
				}
				case 3 -> {
					monster = new xDog();
					monster.name = "들개";
					monster.hp = 2500;
					monster.mp = 0;
					monster.level = 10;
					monster.power = 200;
					monster.defense = 40;
					monster.money = 80;
					monster.experience = 80;
				}
				case 4 -> {
					monster = new xPig();
					monster.name = "멧돼지";
					monster.hp = 5000;
					monster.mp = 0;
					monster.level = 27;
					monster.power = 500;
					monster.defense = 80;
					monster.money = 150;
					monster.experience = 200;
				}
				}
				if (fight_with == 2 && (myhero.hp <= 80 || myhero.power <= 15)) {
					System.out.println("기본 HP와 Power로는 살쾡이 공격이 불가능합니다. (HP:80초과, Power:15초과 요망)");
				} else if (fight_with == 3 && myhero.level < 4) {
					System.out.println("레벨이 부족하여 들개에게 도전할 수 없습니다. (레벨 4 이상 필요)");
				} else if (fight_with == 4 && myhero.level < 5) {
					System.out.println("레벨이 부족하여 멧돼지에게 도전할 수 없습니다. (레벨 5 이상 필요)");
				} else {
					// 전투 시작
					while (true) {
						System.out.printf("%s와 전투를 시작합니다.\n", monster.name);

						int damage = 0;

						// 🎯 유효한 공격이 나올 때까지 반복 (공격 실패 시 반복)
						while (damage == 0) {
							if (myhero instanceof Arch) {
								damage = ((Arch) myhero).archattack(monster);
							} else if (myhero instanceof Magi) {
								damage = ((Magi) myhero).magiattack(monster);
							} else if (myhero instanceof Warrior) {
								damage = ((Warrior) myhero).warriorattack(monster);
							} else {
								damage = myhero.attack();
							}

							if (damage == 0) {
								System.out.println("⚠️ 공격 조건이 충족되지 않았습니다. 다시 공격을 선택하세요.\n");
							}
						}

						// 여기까지 왔다는 건 공격 성공한 상태
						monster.attacked(damage);

						if (monster.hp <= 0) {
							System.out.printf("%s가 죽었습니다.\n", monster.name);
							myhero.experience += monster.experience;
							myhero.money += monster.money;
							break; // 전투 종료 → 장소 선택으로 복귀
						}

						myhero.attacked(monster.attack());

						if (myhero.hp <= 0) {
							System.out.printf("%s가 죽었습니다.\n", myhero.name);
							myhero.hp = 1;
							System.out.printf("%s가 부활했습니다.\n", myhero.name);
							break; // 전투 종료 → 장소 선택으로 복귀
						}
					}

				}

			} else if (place == 2) {
				PotionStore potion = new PotionStore();
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

				if (potion.potionStore_show(myhero.money, want) != 1) {
					if (want == 1)
						myhero.power += 3;
					if (want == 2)
						myhero.defense += 3;
					if (want == 3)
						myhero.experience += 50;
					if (want == 4)
						myhero.hp += 50;
					if (want == 5)
						myhero.mp += 50;
					myhero.money = potion.potionStore_show(myhero.money, want);
					System.out.printf("%d원 남았습니다.", myhero.money);
				} else {
					System.out.println("돈이 부족합니다");
				}

			} else if (place == 3) {
				WeaponStore weapon = new WeaponStore();
				System.out.println("무기상점에 입장하셨습니다.");
				System.out.println("1. 칭키스칸의 모자(전사용,100원)\n2. 알라딘의 양탄자(마법사용,150원)\n3. 주몽이 타던 말(궁수용,200원)\n4. 상점 나가기");

				int num1 = in.nextInt();

				if (num1 == 1 && myhero instanceof Warrior) {
					if (myhero.money >= weapon.xcal) {
						myhero.money -= weapon.xcal;
						myhero.power += 80;
						System.out.println("칭키스칸의 모자를 구매했습니다! (공격력 +80)");
					} else {
						System.out.println("돈이 부족합니다.");
					}
				} else if (num1 == 2 && myhero instanceof Magi) {
					if (myhero.money >= weapon.magistick) {
						myhero.money -= weapon.magistick;
						myhero.power += 150;
						System.out.println("알라딘의 양탄자를 구매했습니다! (공격력 +150)");
					} else {
						System.out.println("돈이 부족합니다.");
					}
				} else if (num1 == 3 && myhero instanceof Arch) {
					if (myhero.money >= weapon.firearr) {
						myhero.money -= weapon.firearr;
						myhero.power += 500;
						System.out.println("주몽이 타던 말을 구매했습니다! (공격력 +500)");
					} else {
						System.out.println("돈이 부족합니다.");
					}
				} else if (num1 == 4) {
					System.out.println("무기 상점을 나가겠습니다.");
				} else {
					System.out.println("직업에 맞지 않는 무기입니다.");
				}
			} else if (place == 8) {
				emotion(myhero);
			} else if (place == 0) {
				System.out.println("게임 종료하겠습니다");
				break;
			} else if (place == 7) {
				System.out.println("퀘스트를 시작합니다...");
				Quest.startQuest(myhero);
			}
			Mission.levelUpCheck(myhero.name, myhero);

		}

	}

	static void emotion(Hero myhero) {
		Scanner in = new Scanner(System.in);
		System.out.println("원하는 감정 표현을 선택하세요\n1.행복\n2.우울\n3.분노\n4.사랑");
		int emotion_num = in.nextInt();

		switch (emotion_num) {
		case 1:
			System.out.println("나 완전 행복해서 하늘을 날 것만 같아~");
			myhero.power += 5;
			myhero.hp += 5;
			break;
		case 2:
			System.out.println("너무 슬퍼 ㅠㅠㅠㅠ");
			myhero.money += 10;
			break;
		case 3:
			System.out.println("지금 매우 화나서 건드리지 마");
			myhero.power += 5;
			break;
		case 4:
			System.out.println("사랑해 i love you");
			myhero.mp += 5;
			break;
		}
	}

}
