package Map;

public class PotionStore {
	public static int potionStore_show(int hero_money, int num) {
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

}
