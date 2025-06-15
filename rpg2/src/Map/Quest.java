package Map;

import java.util.Scanner;

import Chracter.Arch;
import Chracter.Hero;
import Chracter.Magi;
import Chracter.Monster;
import Chracter.Warrior;

public class Quest {
	public static void startQuest(Hero myhero) {
		Scanner in = new Scanner(System.in);
		Monster monster = new Monster();

		monster.name = "보스 달팽이";
		monster.hp = 10000;
		monster.mp = 0;
		monster.level = 50;
		monster.power = 600;
		monster.defense = 80;
		monster.money = 400;
		monster.experience = 300;

		System.out.println("\n퀘스트 시작! 보스 달팽이를 처치하라!");

		while (monster.hp > 0) {
			System.out.println("공격할 준비 되었나요? (1을 누르세요)");
			int ready = in.nextInt();

			int damage = 0;
			if (myhero instanceof Arch) {
				damage = ((Arch) myhero).archattack(monster);
			} else if (myhero instanceof Magi) {
				damage = ((Magi) myhero).magiattack(monster);
			} else if (myhero instanceof Warrior) {
				damage = ((Warrior) myhero).warriorattack(monster);
			} else {
				damage = myhero.attack();
			}

			monster.attacked(damage);

			if (monster.hp <= 0) {
				System.out.println("보스 달팽이를 처치했습니다! 퀘스트 완료!");
				myhero.level += 1;
				myhero.experience = 0;
				System.out.printf("%s의 레벨이 %d로 상승했습니다!\n", myhero.name, myhero.level);
				break;
			}

			myhero.attacked(monster.attack());

			if (myhero.hp <= 0) {
				System.out.printf("%s가 죽었습니다. 퀘스트 실패\n", myhero.name);
				myhero.hp = 1;
				break;
			}
		}
	}
}