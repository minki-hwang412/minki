package Map;

import java.util.Scanner;

import Chracter.Arch;
import Chracter.Hero;
import Chracter.Magi;
import Chracter.Monster;
import Chracter.Warrior;
import Chracter.WildCat;

public class Mission {
	public static void levelUpCheck(String hero_name, Hero myhero) {
		if (myhero.experience >= myhero.level * 80) {
			Scanner in = new Scanner(System.in);

			// 보스 살쾡이 객체 생성 (WildCat을 활용)
			Monster monster = new WildCat();
			monster.name = "보스 살쾡이";
			monster.hp = (int) (2000 * 1.5); // 기존 2000 → 보스 1.5배
			monster.power = (int) (100 * 1.5); // 공격력
			monster.defense = (int) (20 * 1.5); // 방어력

			System.out.println("\n보스 살쾡이가 나타났습니다. 공격 번호를 선택하여 처치하세요.");

			while (monster.hp > 0) {
				System.out.println("공격할 준비 되었나요? (1번을 누르시오.) ");
				int attackType = in.nextInt();

				int damage = 0;
				if (myhero instanceof Arch) {
					damage = ((Arch) myhero).archattack(monster);
				} else if (myhero instanceof Magi) {
					damage = ((Magi) myhero).magiattack(monster);
				} else if (myhero instanceof Warrior) {
					damage = ((Warrior) myhero).warriorattack(monster);
				} else {
					damage = myhero.attack(); // 기본 공격
				}

				// 데미지 계산: 보스 방어력 적용
				if (damage <= monster.defense) {
					System.out.println("공격이 막혔습니다. (보스의 방어력이 너무 강력함)");
				} else {
					monster.hp -= (damage - monster.defense);
					if (monster.hp > 0) {
						System.out.printf("보스 살쾡이의 남은 체력: %d\n", monster.hp);
					} else {
						System.out.println("보스 살쾡이를 처치했습니다. 레벨업합니다.");
						myhero.level += 1;
						myhero.money += myhero.level * 100;
						myhero.experience = 0;
						System.out.printf("%s의 레벨이 %d가 되었고, 보상으로 %d원을 획득했습니다.\n", hero_name, myhero.level,
								myhero.level * 100);
					}
				}
			}
		}
	}
}